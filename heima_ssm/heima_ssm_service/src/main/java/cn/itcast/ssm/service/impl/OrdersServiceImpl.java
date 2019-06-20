package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.OrdersDao;
import cn.itcast.ssm.domain.Orders;
import cn.itcast.ssm.service.OrdersService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;
    @Override
    public List<Orders> findAll(int page,int size) throws Exception {
        //参数pageNum 是页码值   参数pageSize 代表是每页显示条数
        PageHelper.startPage(page,size);
        List<Orders> orders = ordersDao.findAll();
        return orders;
    }

    @Override
    public Orders findById(String id) throws Exception {
        Orders orders = ordersDao.findById(id);
        return orders;
    }

    @Override
    public void remover(List<String> delList) {
        for (String id : delList) {
            ordersDao.remover(id);
        }
    }
}
