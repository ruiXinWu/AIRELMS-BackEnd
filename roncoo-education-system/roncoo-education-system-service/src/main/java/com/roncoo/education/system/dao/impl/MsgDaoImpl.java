package com.roncoo.education.system.dao.impl;

import com.roncoo.education.common.core.base.Page;
import com.roncoo.education.common.core.base.PageUtil;
import com.roncoo.education.common.core.tools.IdWorker;
import com.roncoo.education.system.dao.MsgDao;
import com.roncoo.education.system.dao.impl.mapper.MsgMapper;
import com.roncoo.education.system.dao.impl.mapper.entity.Msg;
import com.roncoo.education.system.dao.impl.mapper.entity.MsgExample;
import com.roncoo.education.system.dao.impl.mapper.entity.MsgExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class MsgDaoImpl implements MsgDao {
    @Autowired
    private MsgMapper msgMapper;

    @Override
    public int save(Msg record) {
        record.setId(IdWorker.getId());
        return this.msgMapper.insertSelective(record);
    }

    @Override
    public int deleteById(Long id) {
        return this.msgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateById(Msg record) {
        return this.msgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public Msg getById(Long id) {
        return this.msgMapper.selectByPrimaryKey(id);
    }

    @Override
    public Page<Msg> listForPage(int pageCurrent, int pageSize, MsgExample example) {
        int count = this.msgMapper.countByExample(example);
        pageSize = PageUtil.checkPageSize(pageSize);
        pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
        int totalPage = PageUtil.countTotalPage(count, pageSize);
        example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
        example.setPageSize(pageSize);
        return new Page<Msg>(count, totalPage, pageCurrent, pageSize, this.msgMapper.selectByExample(example));
    }

    @Override
    public List<Msg> listByStatusIdAndIsSendAndIsTimeSendAndSendTime(Integer statusId, Integer isSend, Integer isTimeSend, Date sendTime) {
        MsgExample example = new MsgExample();
        Criteria c = example.createCriteria();
        c.andStatusIdEqualTo(statusId);
        c.andIsSendEqualTo(isSend);
        c.andIsTimeSendEqualTo(isTimeSend);
        c.andSendTimeLessThanOrEqualTo(sendTime);
        List<Msg> list = this.msgMapper.selectByExample(example);
        if (list.isEmpty() || list.size() < 1) {
            return null;
        }
        return list;
    }
}
