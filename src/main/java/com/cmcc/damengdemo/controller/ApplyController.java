package com.cmcc.damengdemo.controller;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/product")
@RestController
public class ApplyController {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @RequestMapping("/test")
    public String test() {
        return "hello world";
    }


    /**
     * 注入 jdbcTemplate 模板对象
     */

    @GetMapping("/queryDbVersion")
    public List queryDbVersion() {
        return jdbcTemplate.queryForList(
                "SELECT banner as 版本信息 FROM v$version");
    }
    @PostMapping("/create")
    public List<Map<String, Object>> create(@RequestBody JSONObject jc) {
        String name = jc.getString("name");
        String productCategoryId = jc.getString("productCategoryId");

        String sql = "insert into product_category(name,product_category_id) values(?,?)";
        jdbcTemplate.update(sql, name, productCategoryId);

        return jdbcTemplate.queryForList("select * from product_category");
    }

}

