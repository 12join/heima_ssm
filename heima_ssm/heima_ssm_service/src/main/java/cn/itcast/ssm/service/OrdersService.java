package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Orders;

import java.util.List;

//订单管理
public interface OrdersService {

    List<Orders> findAll() throws Exception;
}
