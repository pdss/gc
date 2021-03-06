package com.zzl.gc.exception;

import com.zzl.gc.VO.ResultVO;
import com.zzl.gc.util.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author luotao
 * @Package com.zzl.gc.exception
 * @date 2019/8/23 14:22
 * @Description: 异常拦截处理器
 */
@ControllerAdvice
@Slf4j
public class ExceptionHandle {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultVO exceptionHandle(Exception e){
        /**
         * @author luotao
         * @date 2019/8/26 11:40
         * @param e 异常
         * @return com.zzl.gc.VO.ResultVO
         * @describe 异常拦截
         */
        if(e instanceof MyException){
            log.warn("异常码{}，异常信息{}",((MyException) e).getCode(),((MyException) e).getMessage());
            return ResultVOUtil.error(((MyException) e).getCode(),((MyException) e).getMessage());
        }
        log.error("服务器异常，异常信息{}",e.getMessage());
        return ResultVOUtil.error(-1,"服务器异常");
    }
}
