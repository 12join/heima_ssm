package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.Syslog;
import cn.itcast.ssm.service.SyslogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/syslog")
public class SyslogController {
    @Autowired
    private SyslogService syslogService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")int page, @RequestParam(name = "size",required = true,defaultValue = "1")int size) throws Exception {
        ModelAndView mv = new ModelAndView();
         List<Syslog> syslogs=syslogService.findAll(page,size);
        PageInfo pageInfo=new PageInfo(syslogs);
        mv.addObject("pageInfo",pageInfo );
        mv.setViewName("syslog-list");
        return mv;
    }
}
