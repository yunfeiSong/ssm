package com.fly.controller;

import com.fly.mybatis.Role;
import com.fly.mybatis.RoleEnum;
import com.fly.spring.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/8/31
 */
@Controller("common")
@RequestMapping("/con")
@SessionAttributes(names = {"id"}, types = {Role.class})
public class TestController {

  @Autowired
  private RoleService roleService1;


  /**
   * 控制器，
   * method 指定接受怎样的请求，不指定则接收所有请求
   * value 控制器的 URI
   *
   * @return ModelAndView
   */
  @RequestMapping(value = "/index.do" /*method = RequestMethod.POST*/)
  /*
   直接获取参数： （允许参数为空）
      传递过来的参数名和方法签名中的参数名保持一致，spring mvc 会自动映射
      当参数过多少，可通过映射 pojo 的方式获取参数，spring mvc 支持映射 model 对象

   使用注解获取参数：
      @RequestParam  （为解决传递参数名和接收参数名不一致问题）
      <=>
      String id = request.getParameter("id"); Long id = Long.parseLong(id);
      value http 请求中的参数名
      required 默认为 true 不允许参数为空，如果为空会抛出异常
      defaultValue 参数默认值

      @RequestAttribute
      作用于方法签名中的注解
      从 request 对象中获取指定参数，不能为空，可指定 required 属性为 false 来允许参数为空

      @SessionAttribute
      作用于方法签名中的注解
      从 session 中获取对应名称的参数，不能为空，可指定 required 属性为 false 来允许参数为空

      @SessionAttributes
      作用于类上的注解
      将指定参数放入 session 对象中，names 属性为数组，指定要放入的参数名，types 属性也是数组，指定参数对应的对象

      @CookieValue
      从 cookie 中获取参数，不能为空

      @RequestHeader
      从请求头中获取参数，不能为空

   */
  public ModelAndView index(@RequestParam(value = "id", required = false, defaultValue = "0") Long id, @SessionAttribute(value = "userName", required = false) String userName, @RequestAttribute(value = "attr", required = false) String attr,
                            @CookieValue(value = "JSESSIONID", required = false, defaultValue = "MyJsessionId") String jsessionId,
                            @RequestHeader(value = "User-Agent", required = false, defaultValue = "attr") String userAgent) {

    System.out.println("收到的参数id：" + id);

    ModelAndView modelAndView = new ModelAndView();

    modelAndView.addObject("jsessionId", jsessionId);
    modelAndView.addObject("userAgent", userAgent);

    modelAndView.setViewName("index");//设置要返回的 jsp 名称

    return modelAndView;
  }

  //@ResponseBody
  @RequestMapping("/addListRole.do")
  public ModelAndView addListRole(ModelMap modelMap, Model model) {
    ModelAndView modelAndView = new ModelAndView();

    Role role = new Role();
    role.setRoleEnum(RoleEnum.Employee);
    role.setNote("控制器中添加");
    roleService1.addRole(role);

    /*
      model 和 modelMap 初始化的实例都是  BindingAwareModelMap 对象 ，
      使用 modelAndView 的 addObject() 方法和 model、modelMap 都可以传递参数至视图层
     */
    modelAndView.addObject("role", role);//添加参数传递至视图层
//    modelMap.addAttribute("role", role);
//    model.addAttribute("role", role);

    //返回对象
    modelAndView.setViewName("roleList");//设置要返回的 jsp 名称
    /*
       返回 json 字符串，需要 jackson 包的支持
       效果同 @ResponseBody
     */
    //modelAndView.setView(new MappingJackson2JsonView());
    return modelAndView;
  }

  /*
    @PathVariable
    接收 URL 中带的参数，允许参数为空
   */
  @RequestMapping("/getRole/{id}.do")
  public ModelAndView getRole(@PathVariable("id") int id) {
    ModelAndView modelAndView = new ModelAndView();

    Role role = roleService1.getRole(id);

    modelAndView.addObject("role", role);

    modelAndView.setViewName("role");
    return modelAndView;
  }

  @ResponseBody
  @RequestMapping("/findRole.do")
  /*
    @RequestBody
    接收请求体中的参数，可映射单个参数、集合、 pojo ，但是请求体中参数名和 pojo 参数名需一致
   */
  public String findRole(@RequestBody Role id) {
    System.out.println(id.toString());
    return String.valueOf(id.toString());
  }


  @RequestMapping("/showRoleInfo.do")
  public ModelAndView showRoleInfo(Role role) {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setView(new MappingJackson2JsonView());

    modelAndView.addObject("role", role);

    return modelAndView;
  }

  @RequestMapping("/addRole.do")
  /*
     RedirectAttributes
     在重定向中加入 pojo 类型参数，使用其 addFlashAttributes（） 方法，将 pojo（Java 对象） 放于 session中，待重定向结束，将 pojo 从 session 中删除

     ★★★ 测试时需从浏览器访问 URL ，idea 自带的 REST Client 不能进行重定向
   */
  public String addRole(Model model, RedirectAttributes rs) {

    Role role = new Role();
    role.setNote("测试重定向");
    role.setRoleEnum(RoleEnum.ChairMan);

    roleService1.addRole(role);

//    model.addAttribute("role", role.getNote());
    rs.addFlashAttribute("role", role);//将 pojo 放入 session 中，达到重定向传递 Java 对象的目的
    return "redirect:./showRoleInfo.do";//重定向到当前类的 其他方法中 . 当前类
  }
}
