package com.laiiiii.controller;

import com.laiiiii.domain.Clazz;
import com.laiiiii.domain.ClazzQueryParam;
import com.laiiiii.domain.PageResult;
import com.laiiiii.domain.Result;
import com.laiiiii.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    /**
     *  分页查询
     */
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam){
        log.info("分页查询, {}", clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);
        return Result.success(pageResult);
    }

    /**
     * 删除员工
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer  id){
        log.info("删除员工, id: {}", id);
        clazzService.delete(id);
        return Result.success();
    }

    /**
     * 添加班级
     */
    @PostMapping
    public Result save(@RequestBody Clazz clazz){
        log.info("添加班级, {}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    /**
     * 根据id查询班级信息
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查询班级信息, id: {}", id);
        Clazz clazz = clazzService.getInfo(id);
        return Result.success(clazz);
    }

    /**
     * 修改班级信息
     */
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("修改班级信息, {}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }



}
