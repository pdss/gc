package com.zzl.gc.DTO;

import lombok.Data;

/**
 * @Author: luotao
 * @CreateTime: 2019-08-25 21:48
 * @Description: 微信返回的sessionkey和openid
 */
@Data
public class WXSessionModel {
    private String session_key;
    private String openid;
}
