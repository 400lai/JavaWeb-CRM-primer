package com.laiiiii.exception;

import com.laiiiii.domain.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handleException(Exception e){
        log.error("程序出错啦~", e);
        return Result.error("出错啦, 请联系管理员~");
    }

    // DuplicateKeyException是Exception的子类，遇到具体处理，否则交给大类处理
    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e){
        log.error("程序出错啦~", e);
        String message = e.getMessage();        // 获取错误信息
        int i = message.indexOf("Duplicate entry");
        String errMsg = message.substring(i);
        String[] arr = errMsg.split(" ");
        return Result.error( arr[2] + " 已存在");  // 将错误的重复的信息返回到前端用户界面
    }

}
