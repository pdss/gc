package com.zzl.gc.DTO;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: luotao
 * @CreateTime: 2019-08-25 23:18
 * @Description: 小程序的基础信息
 */
@Data
@Component
@ConfigurationProperties(prefix = "wxapp")
public class WXAuth {
    private String appId;

    private String secret;

    private String grantType;

    private String sessionHost;
}
