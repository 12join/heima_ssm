package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.Orders;
import cn.itcast.ssm.domain.Product;
import cn.itcast.ssm.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;


    @RequestMapping("/findAll")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page, @RequestParam(name = "size",required = true,defaultValue = "2")int size ) {
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(productList);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-list");
        return mv;
    }

    @RequestMapping("/save")
    public String save(Product product){
        productService.save(product);
        return "redirect:findAll";
    }
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String id) throws Exception {
        ModelAndView mv=new ModelAndView();
        Product product = productService.findById(id);
        mv.addObject("products",product);
        mv.setViewName("product-show");
        return mv;
    }
    @RequestMapping("/remover")
    public String remove(HttpServletRequest request, HttpServletResponse response){
       // ModelAndView mv=new ModelAndView();
        String deletes = request.getParameter("deletes");
        List<String> delList=new ArrayList<String>();
        String[] delete = deletes.split(",");
        for (String string : delete) {
            delList.add(string);
        }
        productService.remover(delList);
        //mv.setViewName("product-list");
        return "redirect:findAll";
    }

    @RequestMapping("/open")
    public String open(HttpServletRequest request, HttpServletResponse response){
        // ModelAndView mv=new ModelAndView();
        String deletes = request.getParameter("open");
        List<String> delList=new ArrayList<String>();
        String[] delete = deletes.split(",");
        for (String string : delete) {
            delList.add(string);
        }
        productService.open(delList);
        //mv.setViewName("product-list");
        return "redirect:http://localhost/product/findAll?aaa="+new Date().getTime();
    }

    @RequestMapping("/close")
    public String close(HttpServletRequest request, HttpServletResponse response){
        // ModelAndView mv=new ModelAndView();
        String deletes = request.getParameter("open");
        List<String> delList=new ArrayList<String>();
        String[] delete = deletes.split(",");
        for (String string : delete) {
            delList.add(string);
        }
        productService.close(delList);
        //mv.setViewName("product-list");
        return "redirect:findAll";
    }

}
