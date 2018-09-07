package com.fly.controller;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : SongYF
 * @desc :
 * @date : 2018/8/31
 * @Copyright (c) 2015 jigoon
 */
@Controller
@RequestMapping("/con")
public class CommonController {
  @RequestMapping("/index")
  public String index(){
    return "index";
  }
}
