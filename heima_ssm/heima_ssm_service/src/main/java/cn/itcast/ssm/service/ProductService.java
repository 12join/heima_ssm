package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.Product;

import java.util.List;

public interface ProductService {

    //查询产品的方法
    List<Product> findAll(int page,int size);
    //保存产品的方法
    void save(Product product);
}
