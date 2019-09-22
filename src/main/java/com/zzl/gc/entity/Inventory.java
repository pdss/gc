package com.zzl.gc.entity;

import lombok.Data;

/**
 * @author luotao
 * @Package com.zzl.gc.entity
 * @date 2019/8/23 11:08
 */
@Data
public class  Inventory {
    private int countId;// 库存记录id
    private int pId;// mini馆编号
    private int bId;// 图书编号
    private int invertoryNumber;// 总库存数
    private int lentNumber;// 借书数
    private int unreturnedNumber;// 未归还书
    private int damagedNumber;// 受损数
    private int differentNumber;// 异馆归还数
}
