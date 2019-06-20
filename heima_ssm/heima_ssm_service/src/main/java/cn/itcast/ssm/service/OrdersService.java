package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Orders;

import java.util.List;

//订单管理
public interface OrdersService {

    List<Orders> findAll(int page,int size) throws Exception;

    //根据id查询详情
    Orders findById(String id) throws  Exception;
    //删除订单信息
    void remover(List<String> delList);
    //定义开启的方法
    void open(List<String> delList);
    //定义关闭的方法
    void close(List<String> delList);
}
