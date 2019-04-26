package com.example.wl;/**
 * @Auther: Administrator
 * @Date: 2019/4/26 0026 16:02
 * @Description:
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: wl
 *
 * @description:
 *
 * @author: Carson Wei
 *
 * @create: 2019-04-26 16:02
 **/
@Controller
public class TestController {

    @RequestMapping("/test")
    public String test(){
      return "test";
    }
}
