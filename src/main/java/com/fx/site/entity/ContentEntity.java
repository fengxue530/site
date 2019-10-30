package com.fx.site.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @auther: mabaofeng
 * @date: 2019/10/29 11:20
 * @description: 文章实体
 */
@Setter
@Getter
public class ContentEntity {

    /**
     * 文章的主键编号
     */
    @NonNull
    private Integer cid;
    /**
     * 内容标题
     */
    @NonNull
    private String title;

    /**
     * 标题图片
     */
    private String titlePic;
    /**
     * 内容缩略名
     */
    private String slug;
    /**
     * 内容生成时的GMT unix时间戳
     */
    @NonNull
    private Integer created;
    /**
     * 内容更改时的GMT unix时间戳
     */
    @NonNull
    private Integer modified;
    /**
     * 内容文字
     */
    @NonNull
    private String content;
    /**
     * 内容所属用户id
     */
    @NonNull
    private Integer authorId;
    /**
     * 内容类别
     */
    @NonNull
    private String type;
    /**
     * 内容状态
     */
    @NonNull
    private String status;
    /**
     * 标签列表
     */
    @NonNull
    private String tags;
    /**
     * 分类列表
     */
    @NonNull
    private String categories;
    /**
     * 点击次数
     */
    @NonNull
    @Builder.Default
    private Integer hits = 0;
    /**
     * 内容所属评论数
     */
    @NonNull
    private Integer commentsNum = 0;
    /**
     * 是否允许评论
     */
    @NonNull
    private Integer allowComment;
    /**
     * 是否允许ping
     */
    @NonNull
    private Integer allowPing;
    /**
     * 允许出现在聚合中
     */
    @NonNull
    private Integer allowFeed;
}
