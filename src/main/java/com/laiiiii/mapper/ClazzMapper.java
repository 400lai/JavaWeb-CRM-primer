package com.laiiiii.mapper;

import com.laiiiii.domain.Clazz;
import com.laiiiii.domain.ClazzQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ClazzMapper {
    /**
     * 条件分页查询班级信息
     */
    List<Clazz> list(ClazzQueryParam clazzQueryParam);

    /**
     * 根据ID删除班级信息
     */
    void deleteById(Integer id);

    /**
     * 新增班级信息
     */
    void insert(Clazz clazz);

    /**
     * 根据ID查询班级信息
     */
    @Select("select * from clazz where id = #{id}")
    Clazz getById(Integer id);

    /**
     * 根据ID更新班级信息
     */
    void updateById(Clazz clazz);
}
