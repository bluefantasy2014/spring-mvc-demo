package com.sjj.springmvcdemo.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sjj.springmvcdemo.other.ConcurrentLimit;

@Controller
@RequestMapping("/mytest")
public class TestDemoControler {
    @ResponseBody
    @ConcurrentLimit
    @RequestMapping(value = "test", method = {RequestMethod.GET})
    public String test() {
        throw new RuntimeException("test");
//       return "Hello world!";
    }
}
