package com.fly.controller;

import com.fly.mybatis.Role;
import com.fly.mybatis.RoleEnum;
import com.fly.spring.RoleService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/8/31
 */
@Controller("common")
@RequestMapping("/con")
public class TestController {

  @Autowired
  private RoleService roleService1;




  /**
   *  控制器，
   *  method 指定接受怎样的请求，不指定则接收所有请求
   *  value 控制器的 URI
   * @return ModelAndView
   */
  @RequestMapping(value = "/index.do" /*method = RequestMethod.POST*/)
  /*
      @RequestParam <=> String id = request.getParameter("id"); Long id = Long.parseLong(id);
      value http 请求中的参数名
      required 默认为 true 不允许参数为空
      defaultValue 参数默认值

      @SessionAttribute
      从 session 中获取对应名称的参数
   */
  public ModelAndView index(@RequestParam(value = "id",required = false, defaultValue = "0") Long id, @SessionAttribute(value = "userName", required = false) String userName) {

    System.out.println("收到的参数id："+ id);

    ModelAndView modelAndView = new ModelAndView();

    modelAndView.setViewName("index");

    System.out.println(123);
    return modelAndView;
  }

  //@ResponseBody
  @RequestMapping("/addListRole.do")
  public ModelAndView addListRole(){
    ModelAndView modelAndView = new ModelAndView();

    Role role = new Role();
    role.setRoleEnum(RoleEnum.Employee);
    role.setNote("控制器中添加");
    roleService1.addRole(role);

    modelAndView.addObject("role", role);

    //返回对象
    modelAndView.setViewName("roleList");
    /*
       返回 json 字符串，需要 jackson 包的支持
       效果同 @ResponseBody
     */
    //modelAndView.setView(new MappingJackson2JsonView());
    return modelAndView;
  }
}
