package com.laiiiii.controller;

import com.laiiiii.domain.Emp;
import com.laiiiii.domain.EmpQueryParam;
import com.laiiiii.domain.PageResult;
import com.laiiiii.domain.Result;
import com.laiiiii.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/**
 * 员工管理的Controller
 */
// @Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    private static final Logger log = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    private EmpService empService;

    /**
     * @RequestParam 设置默认值
     */
//    @GetMapping
//    public Result page(@RequestParam(defaultValue = "1") Integer page,
//                       @RequestParam(defaultValue = "10") Integer pageSize,
//                       String name, Integer gender,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
//        log.info("分页查询, {},{},{},{},{},{}", page, pageSize, name, gender, begin, end);
//        PageResult<Emp> pageResult = empService.page(page, pageSize, name, gender, begin, end);
//        return Result.success(pageResult);
//    }

    /**
     * 分页查询
     */
    @GetMapping
    public Result page(EmpQueryParam empQueryParam){
        log.info("分页查询, {}", empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 新增员工
     */
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("请求参数emp: {}", emp);
        empService.save(emp);
        return Result.success();
    }

}

