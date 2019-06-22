package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.Orders;
import cn.itcast.ssm.domain.Permission;
import cn.itcast.ssm.domain.Role;
import cn.itcast.ssm.domain.UserInfo;
import cn.itcast.ssm.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page, @RequestParam(name = "size",required = true,defaultValue = "1")int size ) throws Exception {
        ModelAndView mv=new ModelAndView();
        List<Role> roles = roleService.findAll(page, size);
        PageInfo pageInfo=new PageInfo(roles);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll";
    }

    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String roleId) throws Exception {
        ModelAndView mv=new ModelAndView();
        Role role = roleService.findById(roleId);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }

    @RequestMapping("/findPermisssionByIdAndAllRole")
    public ModelAndView findPermisssionByIdAndAllRole(@RequestParam(name = "id",required = true)String roleid) throws Exception {
        ModelAndView mv=new ModelAndView();
        Role role = roleService.findById(roleid);
        List<Permission> permissions = roleService.findOtherRole(roleid);
        mv.addObject("role",role);
        mv.addObject("permissionList",permissions);
        mv.setViewName("permission-role-add");
        return mv;
    }

    @RequestMapping("/addPermissionToRole")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true) String roleId,@RequestParam(name = "permissionids",required = true) String[] permisssionIds){
        roleService.addPermissionToRole(roleId,permisssionIds);
        return "redirect:findAll";
    }
}
