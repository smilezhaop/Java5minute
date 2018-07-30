package com.qingguatang.Java5minute.course1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhaopei
 * @date 2018/7/28
 */
@Controller
public class HelloWorld {

  @RequestMapping(value = "/")
  @ResponseBody
  public String hello() {
    String message = "hello world";
    return message;
  }
}
