package com.zzl.gc.DTO;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: luotao
 * @CreateTime: 2019-08-25 23:18
 * @Description: 小程序的配置信息
 */
@Data
@Component
public class WXAuth {
    @Value("${wxapp.appId}")
    private String appId;
    @Value("${wxapp.secret}")
    private String secret;
    @Value("${wxapp.grantType}")
    private String grantType;
    @Value("${wxapp.sessionHost}")
    private String sessionHost;
}
