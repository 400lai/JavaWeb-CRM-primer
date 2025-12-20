package com.laiiiii.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobOption {

    private List jobList;   // 职位列表
    private List dateList;  // 数据列表

}
