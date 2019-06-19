package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Orders;

import java.util.List;

//订单管理
public interface OrdersService {

    List<Orders> findAll(int page,int size) throws Exception;

    //根据id查询详情
    Orders findById(String id) throws  Exception;
}
