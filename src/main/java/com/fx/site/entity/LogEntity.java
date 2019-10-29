package com.fx.site.entity;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

/**
 * @auther: mabaofeng
 * @date: 2019/10/29 11:43
 * @description: 日志实体
 */
@Data
public class LogEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日志主键
     */
    @NonNull
    private Integer id;

    /**
     * 产生的动作
     */
    @NonNull
    private String action;

    /**
     * 产生的数据
     */
    @NonNull
    private String data;

    /**
     * 发生人id
     */
    private Integer authorId;

    /**
     * 日志产生的ip
     */
    private String ip;

    /**
     * 日志创建时间
     */
    @NonNull
    private Integer created;

}
