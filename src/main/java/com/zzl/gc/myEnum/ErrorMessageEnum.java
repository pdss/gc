package com.zzl.gc.myEnum;

import lombok.Getter;

/**
 * @author luotao
 * @Package com.zzl.gc.myEnum
 * @date 2019/8/23 14:02
 */
@Getter
public enum  ErrorMessageEnum {
    TEST_ERROR(1,"sad")
    ;
    private int code;
    private String msg;
    ErrorMessageEnum(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
