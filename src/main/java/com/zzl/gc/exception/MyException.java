package com.zzl.gc.exception;

import com.zzl.gc.myEnum.ErrorMessageEnum;
import lombok.Data;

/**
 * @author luotao
 * @Package com.zzl.gc.exception
 * @date 2019/8/23 14:07
 * @Description: 自定义异常类
 */
@Data
public class MyException extends RuntimeException {
    private int code;
    public MyException(ErrorMessageEnum errorMessage){
        /**
         * @author luotao
         * @date 2019/8/26 11:40
         * @param errorMessage
         * @describe 自定义异常
         */
        super(errorMessage.getMsg());
        this.code = errorMessage.getCode();
    }
}
