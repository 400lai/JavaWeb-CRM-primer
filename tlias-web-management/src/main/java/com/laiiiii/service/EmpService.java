package com.laiiiii.service;

import com.laiiiii.domain.Emp;
import com.laiiiii.domain.EmpQueryParam;
import com.laiiiii.domain.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface EmpService {
    /**
     * 分页查询员工信息
     * @param page 页码
     * @param pageSize 每页记录数
     * @return
     */
    // PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end );

    /**
     * 分页查询员工信息
     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    /**
     * 新增 员工信息
     */
    void save(Emp emp);
}
