package com.laiiiii.mapper;

import com.laiiiii.domain.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 员工工作经历
 */
@Mapper
public interface EmpExprMapper {

    /**
     * 批量插入员工工作经历信息
     */
    public void insertBatch(List<EmpExpr> exprList);

    /**
     * 根据员工id批量删除员工工作经历信息
     */
    void deleteByEmpIds(List<Integer> empIds);
}