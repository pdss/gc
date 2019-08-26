package com.zzl.gc.service;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.HttpClientUtil;
import com.arronlong.httpclientutil.common.HttpConfig;
import com.arronlong.httpclientutil.exception.HttpProcessException;
import com.zzl.gc.DTO.WXAuth;
import com.zzl.gc.DTO.WXSessionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: luotao
 * @CreateTime: 2019-08-25 23:31
 * @Description: 微信相关
 */
@Service
public class WXService {
    @Autowired
    WXAuth wxAuth;
    public WXSessionModel getWxSession(String code) throws HttpProcessException {
        Map<String,Object> map = new HashMap<>();
        map.put("appid", wxAuth.getAppId());
        map.put("secret", wxAuth.getSecret());
        map.put("js_code", code);
        map.put("grant_type", wxAuth.getGrantType());
        HttpConfig config = HttpConfig.custom()
                .url(wxAuth.getSessionHost())
                .map(map)
                ;
        String result = HttpClientUtil.get(config);
        System.out.println(result);
        System.out.println(wxAuth);
        JSONObject wxJson = JSONObject.parseObject(result);
        WXSessionModel model = JSON.toJavaObject(wxJson, WXSessionModel.class);
        return model;
    }
}
