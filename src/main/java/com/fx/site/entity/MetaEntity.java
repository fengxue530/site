package com.fx.site.entity;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

/**
 * @auther: mabaofeng
 * @date: 2019/10/29 13:46
 * @description: 项目类实体
 */
@Data
public class MetaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目主键
     */
    @NonNull
    private Integer mid;

    /**
     * 名称
     */
    @NonNull
    private String name;

    /**
     * 项目缩略名
     */
    private String slug;

    /**
     * 项目类型
     */
    @NonNull
    private String type;

    /**
     * 对应的文章类型
     */
    private String contentType;

    /**
     * 选项描述
     */
    private String description;

    /**
     * 项目排序
     */
    @NonNull
    private Integer sort;

    private Integer parent;
}
