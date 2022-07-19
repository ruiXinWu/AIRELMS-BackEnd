package com.roncoo.education.course.dao.impl;

import com.roncoo.education.common.core.base.Page;
import com.roncoo.education.common.core.base.PageUtil;
import com.roncoo.education.common.core.tools.IdWorker;
import com.roncoo.education.course.dao.OrderPayDao;
import com.roncoo.education.course.dao.impl.mapper.OrderPayMapper;
import com.roncoo.education.course.dao.impl.mapper.entity.OrderPay;
import com.roncoo.education.course.dao.impl.mapper.entity.OrderPayExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderPayDaoImpl implements OrderPayDao {
    @Autowired
    private OrderPayMapper orderPayMapper;

    public int save(OrderPay record) {
        record.setId(IdWorker.getId());
        return this.orderPayMapper.insertSelective(record);
    }

    public int deleteById(Long id) {
        return this.orderPayMapper.deleteByPrimaryKey(id);
    }

    public int updateById(OrderPay record) {
        return this.orderPayMapper.updateByPrimaryKeySelective(record);
    }

    public OrderPay getById(Long id) {
        return this.orderPayMapper.selectByPrimaryKey(id);
    }

    public Page<OrderPay> listForPage(int pageCurrent, int pageSize, OrderPayExample example) {
        int count = this.orderPayMapper.countByExample(example);
        pageSize = PageUtil.checkPageSize(pageSize);
        pageCurrent = PageUtil.checkPageCurrent(count, pageSize, pageCurrent);
        int totalPage = PageUtil.countTotalPage(count, pageSize);
        example.setLimitStart(PageUtil.countOffset(pageCurrent, pageSize));
        example.setPageSize(pageSize);
        return new Page<OrderPay>(count, totalPage, pageCurrent, pageSize, this.orderPayMapper.selectByExample(example));
    }

    @Override
    public OrderPay getByOrderNo(long orderNo) {
        OrderPayExample example = new OrderPayExample();
        OrderPayExample.Criteria c = example.createCriteria();
        c.andOrderNoEqualTo(orderNo);
        List<OrderPay> list = this.orderPayMapper.selectByExample(example);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public OrderPay getBySerialNumber(long serialNumber) {
        OrderPayExample example = new OrderPayExample();
        OrderPayExample.Criteria c = example.createCriteria();
        c.andSerialNumberEqualTo(serialNumber);
        List<OrderPay> list = this.orderPayMapper.selectByExample(example);
        if (list.isEmpty() || list.size() < 1) {
            return null;
        }
        return list.get(0);
    }
}
