package com.laiiiii.service;

import com.laiiiii.domain.Emp;
import com.laiiiii.domain.EmpQueryParam;
import com.laiiiii.domain.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    /**
     * 批量删除员工信息
     */
    void delete(List<Integer> ids);

    /**
     * 根据员工id查询员工信息
     */
    Emp getInfo(Integer id);

    /**
     * 修改员工
     */
    void update(Emp emp);
}
