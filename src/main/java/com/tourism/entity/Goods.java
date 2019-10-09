package com.tourism.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Goods {
    /**
    * 商品ID
    */
    private Integer gId;

    /**
    * 商品标题
    */
    private String title;

    /**
    * 商品图片
    */
    private String pic;

    /**
    * 商品名称
    */
    private String name;

    /**
    * 出发地点
    */
    private String address;

    /**
    * 目的地
    */
    private String goAddress;

    /**
    * 原价
    */
    private BigDecimal price;

    /**
    * 库存
    */
    private Integer goodsNum;

    /**
    * 优惠价
    */
    private String newPrice;

    /**
    * 描述
    */
    private String describe;

    /**
    * 旅行时长
    */
    private String longTime;

    /**
    * 进行日期
    */
    private Date date;

    /**
    * 状态
    */
    private Integer isDelete;
}