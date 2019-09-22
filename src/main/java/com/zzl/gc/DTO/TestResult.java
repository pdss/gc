package com.zzl.gc.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @Author: luotao
 * @CreateTime: 2019-09-17 00:47
 * @Description:
 */
@Data
public class TestResult {
    private Integer id;
    private String username;
    @JsonIgnore
    private String password;
    private String url;
}
