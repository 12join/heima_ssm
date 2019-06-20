package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.Orders;
import cn.itcast.ssm.service.OrdersService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page,@RequestParam(name = "size",required = true,defaultValue = "4")int size) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Orders> orders = ordersService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(orders);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("orders-list");
        return mv;
    }
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String id) throws Exception {
        ModelAndView mv=new ModelAndView();
        Orders orders = ordersService.findById(id);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
    @RequestMapping("/remover")
    public ModelAndView remove(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv=new ModelAndView();
        String deletes = request.getParameter("deletes");
        List<String> delList=new ArrayList<String>();
        String[] delete = deletes.split(",");
        for (String string : delete) {
            delList.add(string);
        }
        ordersService.remover(delList);
        mv.setViewName("orders-list");
        return mv;
    }
    @RequestMapping("/open")
    public ModelAndView open(HttpServletRequest request, HttpServletResponse response){
         ModelAndView mv=new ModelAndView();
        String deletes = request.getParameter("open");
        List<String> delList=new ArrayList<String>();
        String[] delete = deletes.split(",");
        for (String string : delete) {
            delList.add(string);
        }
        ordersService.open(delList);
        mv.setViewName("orders-list");
        return mv;
    }

    @RequestMapping("/close")
    public ModelAndView close(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv=new ModelAndView();
        String deletes = request.getParameter("open");
        List<String> delList=new ArrayList<String>();
        String[] delete = deletes.split(",");
        for (String string : delete) {
            delList.add(string);
        }
        ordersService.close(delList);
        mv.setViewName("orders-list");
        return mv;
    }
}
