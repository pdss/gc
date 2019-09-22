package com.zzl.gc.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author luotao
 * @Package com.zzl.gc.entity
 * @date 2019/8/23 10:37
 */
@Data
public class Person implements Serializable {
    private int personId;// 身份证id
    private String personName;// 姓名
    private String personNickname;// 昵称
    private String personPassword;// 密码
    private String personPhone;// 电话
    private int personSex;// 性别
}
