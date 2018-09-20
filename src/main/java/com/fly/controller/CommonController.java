package com.fly.controller;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/8/31
 */
@Controller("common")
@RequestMapping("/con")
public class CommonController {

  @RequestMapping("/index.do")
  public ModelAndView index() {

    ModelAndView modelAndView = new ModelAndView();

    modelAndView.setViewName("index");

    return modelAndView;
  }
}
