package com.laiiiii.service;

import com.laiiiii.domain.Clazz;
import com.laiiiii.domain.ClazzQueryParam;
import com.laiiiii.domain.PageResult;

public interface ClazzService {

    /**
     * 条件分页查询班级信息
     */
    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    /**
     * 删除班级信息
     */
    void delete(Integer id);

    /**
     * 新增班级信息
     */
    void save(Clazz clazz);

    /**
     * 根据ID查询班级信息
     */
    Clazz getInfo(Integer id);

    /**
     * 修改班级信息
     */
    void update(Clazz clazz);
}
