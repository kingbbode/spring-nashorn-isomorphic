package com.kingbbode.isomorphic.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by YG on 2016-09-19.
 */
@RestController
public class HomeRestController {
    
    @RequestMapping("/rest")
    @ResponseBody
    public Map home() throws Exception {
        Map data = new HashMap<>();
        data.put("text", "client");
        return data;
    }    
}
