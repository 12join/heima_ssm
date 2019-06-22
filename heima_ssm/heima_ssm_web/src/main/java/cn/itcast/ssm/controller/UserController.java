package cn.itcast.ssm.controller;


import cn.itcast.ssm.domain.Product;
import cn.itcast.ssm.domain.UserInfo;
import cn.itcast.ssm.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page, @RequestParam(name = "size",required = true,defaultValue = "2")int size ) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<UserInfo> users = userService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(users);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(UserInfo userInfo) throws Exception {
        userService.save(userInfo);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String id) throws Exception {
        ModelAndView mv=new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

}
