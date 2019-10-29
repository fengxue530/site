package com.fx.site.entity;

import lombok.Data;
import lombok.NonNull;

/**
 * @auther: mabaofeng
 * @date: 2019/10/29 13:54
 * @description: 文章关联信息表
 */
@Data
public class RelationShipEntiry {

    /**
     * 文章主键编号
     */
    @NonNull
    private Integer cid;
    /**
     * 项目编号
     */
    @NonNull
    private Integer mid;
}
