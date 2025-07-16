package com.laiiiii.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.laiiiii.domain.*;
import com.laiiiii.mapper.EmpExprMapper;
import com.laiiiii.mapper.EmpMapper;
import com.laiiiii.service.EmpLogService;
import com.laiiiii.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogService empLogService;

    /**
     * 原始分页查询员工信息
     * @param page 页码
     * @param pageSize 每页显示的记录数
     * @return
     */
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//        //1. 获取总记录数 total
//        Long total = empMapper.count();
//
//        //2. 获取分页查询结果列表 rows
//        //2.1 计算起始索引
//        Integer start = (page - 1) * pageSize;
//        //2.2 执行查询
//        List<Emp> empList = empMapper.list(start, pageSize);
//
//        //3. 封装分页结果
//        return new PageResult<Emp>(total, empList);
//    }


    /**
     * PageHelper分页查询
     * @param page 页码
     * @param pageSize 每页记录数
     * @return
     */
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end) {
//        // 1.设置分页参数（PageHelper）
//        PageHelper.startPage(page, pageSize);
//
//        // 2.执行查询
//        List<Emp> empList = empMapper.list(name, gender, begin, end);
//
//        // 3.解析查询结果，并封装
//        Page<Emp> p = (Page<Emp>) empList;
//        return new PageResult<Emp>(p.getTotal(), p.getResult());
//
//    }

    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {
        // 1.设置分页参数（PageHelper）
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        // 2.执行查询
        List<Emp> empList = empMapper.list(empQueryParam);

        // 3.解析查询结果，并封装
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(), p.getResult());

    }

    @Transactional(rollbackFor = {Exception.class})  // 事务管理 - 默认出现运行时异常RuntimeException才会回滚
    @Override
    public void save(Emp emp) {

        try {
            //1.补全基础属性
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            //2.保存员工基本信息
            empMapper.insert(emp);

            //3. 保存员工的工作经历信息 - 批量
            Integer empId = emp.getId();
            List<EmpExpr> exprList = emp.getExprList();
            if(!CollectionUtils.isEmpty(exprList)){
                // 遍历集合，为empId赋值
                exprList.forEach (empExpr ->
                        empExpr.setEmpId(empId));
                empExprMapper.insertBatch(exprList);
            }
        } finally {     // 需求：在新增员工信息时，无论是成功还是失败，都要记录操作日志
            // 记录操作日志
            EmpLog empLog = new EmpLog(null,LocalDateTime.now(),"新增员工"+emp);
            empLogService.insertLog(empLog);
        }


    }


}

