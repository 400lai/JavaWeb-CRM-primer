package com.laiiiii.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class EmpQueryParam {
    private Integer page = 1;   // 当前页码
    private Integer pageSize = 10;  // 每页显示记录数量
    private String name;    //  姓名
    private Integer gender; // 性别
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;    // 入职日期-开始
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;      // 入职日期-结束
}
