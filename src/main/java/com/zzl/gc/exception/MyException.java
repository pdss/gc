package com.zzl.gc.exception;

import com.zzl.gc.myEnum.ErrorMessageEnum;
import lombok.Data;

/**
 * @author luotao
 * @Package com.zzl.gc.exception
 * @date 2019/8/23 14:07
 */
@Data
public class MyException extends RuntimeException {
    private int code;
    public MyException(ErrorMessageEnum errorMessage){
        super(errorMessage.getMsg());
        this.code = errorMessage.getCode();
    }
}
