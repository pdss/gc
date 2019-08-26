package com.zzl.gc.VO;

import lombok.Data;

/**
 * @author luotao
 * @Package com.zzl.gc.VO
 * @date 2019/8/23 12:53
 * @Description: 返回json数据最外层格式
 */
@Data
public class ResultVO<T> {
    private int code;
    private String msg;
    private T data;
}
