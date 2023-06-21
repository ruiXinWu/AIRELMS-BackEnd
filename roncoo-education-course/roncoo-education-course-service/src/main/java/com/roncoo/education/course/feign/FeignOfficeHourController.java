package com.roncoo.education.course.feign;

import com.roncoo.education.common.core.base.BaseController;

import com.roncoo.education.course.feign.biz.FeignOfficeHourBiz;
import com.roncoo.education.course.feign.interfaces.IFeignOfficeHour;
import com.roncoo.education.course.feign.interfaces.vo.OfficeHourVO;
import com.roncoo.education.course.feign.interfaces.vo.ProgramVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignOfficeHourController extends BaseController implements IFeignOfficeHour {
    @Autowired
    private FeignOfficeHourBiz biz;

    @Override
    public OfficeHourVO getByProgramId(@PathVariable(value = "id") Long id){
        System.out.println("FeignOfficeHourController success");
        return biz.getByProgramId(id);
    }
}
