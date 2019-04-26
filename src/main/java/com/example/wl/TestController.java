package com.example.wl;/**
 * @Auther: Administrator
 * @Date: 2019/4/26 0026 16:02
 * @Description:
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: wl
 * @description:
 * @author: Carson Wei
 * @create: 2019-04-26 16:02
 **/
@Controller
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @PostMapping(value = "/testLogin")
    @ResponseBody
    public Map<String, String> testLogin(HttpServletRequest request, HttpServletResponse response,String urlstr,int number) {

        Map<String, String> map = new HashMap<>();
        try {
            for (int i = 0; i < number; i++) {

                URL url = new URL(urlstr);
                InputStream in = url.openStream();
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader bufr = new BufferedReader(isr);
                String str;
                while ((str = bufr.readLine()) != null) {
                    System.out.println(str);
                }
                bufr.close();
                isr.close();
                in.close();
            }
            map.put("code", "200");
            map.put("message", "success");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "500");
            map.put("message", "异常");
        }
        return map;
    }
}
