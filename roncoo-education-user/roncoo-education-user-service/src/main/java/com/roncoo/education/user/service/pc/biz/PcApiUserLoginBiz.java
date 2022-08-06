package com.roncoo.education.user.service.pc.biz;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.roncoo.education.common.core.base.Result;
import com.roncoo.education.common.core.enums.LoginStatusEnum;
import com.roncoo.education.common.core.enums.RedisPreEnum;
import com.roncoo.education.common.core.enums.StatusIdEnum;
import com.roncoo.education.common.core.tools.JSUtil;
import com.roncoo.education.common.core.tools.JWTUtil;
import com.roncoo.education.system.feign.interfaces.IFeignSysMenu;
import com.roncoo.education.user.dao.PlatformDao;
import com.roncoo.education.user.dao.UserDao;
import com.roncoo.education.user.dao.UserLogLoginDao;
import com.roncoo.education.user.dao.impl.mapper.entity.Platform;
import com.roncoo.education.user.dao.impl.mapper.entity.User;
import com.roncoo.education.user.dao.impl.mapper.entity.UserLogLogin;
import com.roncoo.education.user.service.pc.req.UserLoginPasswordREQ;
import com.roncoo.education.user.service.pc.resq.UserLoginRESQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class PcApiUserLoginBiz {

    @Autowired
    private PlatformDao platformDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserLogLoginDao userLogLoginDao;
    @Autowired
    private IFeignSysMenu feignSysMenu;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public Result<UserLoginRESQ> loginPassword(UserLoginPasswordREQ req) {
        if (StringUtils.isEmpty(req.getClientId())) {
            return Result.error("clientId不能为空");
        }
        if (StringUtils.isEmpty(req.getMobile())) {
            return Result.error("手机号不能为空");
        }
        if (StringUtils.isEmpty(req.getPassword())) {
            return Result.error("密码不能为空");
        }
        Platform platform = platformDao.getByClientId(req.getClientId());
        if (null == platform) {
            return Result.error("该平台不存在");
        }
        if (!StatusIdEnum.YES.getCode().equals(platform.getStatusId())) {
            return Result.error("该平台状态异常，请联系管理员");
        }

        // 密码错误次数校验

        // 用户校验
        User user = userDao.getByMobile(req.getMobile());
        if (null == user) {
            return Result.error("账号或者密码不正确");
        }
        // 密码校验
        if (!DigestUtil.sha1Hex(user.getMobileSalt() + req.getPassword()).equals(user.getMobilePsw())) {
            loginLog(user.getUserNo(), req.getClientId(), LoginStatusEnum.FAIL, req.getIp());
            // 放入缓存，错误次数+1
            return Result.error("账号或者密码不正确");
        }
        // 获取用户菜单权限
        System.out.println(user.getUserNo());
        List<String> menuList = feignSysMenu.listByUserAndMenu(user.getUserNo());
        String[] test=new String[]{
                "",
        "/course/pc/order/info/edit",
                "/user/pc/user/ext/view",
                "/user/pc/lecturer/view",
                "/course/pc/order/info/statistical",
                "/course/pc/order/info/view",
                "/course/pc/adv/edit",
                "/course/pc/adv/add",
                "/course/pc/zone/course/edit",
                "/course/pc/course/list",
                "/course/pc/zone/view",
                "/course/pc/zone/add",
                "/system/pc/nav/bar/edit",
                "/system/pc/nav/bar/add",
                "/system/pc/website/nav/add",
                "/system/pc/website/nav/edit",
                "/system/pc/website/nav/article/view",
                "/system/pc/website/link/edit",
                "/system/pc/website/link/add",
                "/course/pc/course/get",
                "/course/pc/course/audit/view",
                "/course/pc/course/category/view",
                "/course/pc/course/category/add",
                "/user/pc/lecturer/view",
                "/user/pc/lecturer/audit/isAudit",
                "/user/pc/lecturer/audit/check",
                "/user/pc/lecturer/audit/view",
                "/user/pc/lecturer/audit/add",
                "/user/pc/lecturer/profit/edit",
                "/user/pc/user/ext/view",
                "/user/pc/user/list",
                "/system/pc/sys/role/user/list",
                "/system/pc/sys/role/list",
                "/system/pc/sys/user/password",
                "/system/pc/sys/user/view",
                "/system/pc/sys/user/add",
                "/system/pc/menu/role/list",
                "/system/pc/menu/list",
                "/system/pc/sys/role/view",
                "/system/pc/sys/role/add",
                "/system/pc/menu/view",
                "/system/pc/menu/add",
                "/system/pc/website/view",
                "/system/pc/sys/view",
                "/user/pc/platform/view",
                "/user/pc/platform/add",
                "",
                "/course/pc/order/info/list",
                "",
                "/course/pc/adv/list",
                "/course/pc/zone/list",
                "/course/pc/zone/course/list",
                "/system/pc/nav/bar/list",
                "/system/pc/website/nav/list",
                "/system/pc/website/link/list",
                "",
                "/course/pc/course/list",
                "/course/pc/course/audit/list",
                "/course/pc/course/category/list",
                "",
                "/user/pc/lecturer/list",
                "/user/pc/lecturer/audit/list",
                "/user/pc/lecturer/profit/list",
                "",
                "/user/pc/user/ext/list",
                "",
                "/system/pc/sys/user/list",
                "/system/pc/sys/role/list",
                "/system/pc/menu/list",
                "",
                "",
                "/user/pc/platform/list"
};
        //List<String> menuList= Arrays.asList(test);
        if (CollectionUtil.isEmpty(menuList)) {
            return Result.error("没权限！");
        }

        // 登录日志
        loginLog(user.getUserNo(), req.getClientId(), LoginStatusEnum.SUCCESS, req.getIp());

        // 用户菜单存入缓存, 时间

        redisTemplate.opsForValue().set(RedisPreEnum.ADMINI_MENU.getCode().concat(user.getUserNo().toString()), JSUtil.toJSONString(menuList), 1, TimeUnit.DAYS);

        UserLoginRESQ dto = new UserLoginRESQ();
        dto.setUserNo(user.getUserNo());
        dto.setMobile(user.getMobile());
        dto.setToken(JWTUtil.create(user.getUserNo(), JWTUtil.DATE));

        // 登录成功，存入缓存，单点登录使用
        // redisTemplate.opsForValue().set(dto.getUserNo().toString(), dto.getToken(),
        // 1, TimeUnit.DAYS);

        return Result.success(dto);
    }

    private void loginLog(Long userNo, String clientId, LoginStatusEnum status, String ip) {
        UserLogLogin record = new UserLogLogin();
        record.setUserNo(userNo);
        record.setClientId(clientId);
        record.setLoginStatus(status.getCode());
        record.setLoginIp(ip);
        userLogLoginDao.save(record);
    }
}
