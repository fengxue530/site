package com.fx.site.entity;

import lombok.Data;
import lombok.NonNull;

/**
 * @auther: mabaofeng
 * @date: 2019/10/29 10:49
 * @description:  评论实体
 */
@Data
public class CommentEntity {

    /**
     * comment表主键
     */
    @NonNull
    private Integer coid;

    /**
     * contents表主键,关联字段
     */
    @NonNull
    private Integer cid;

    /**
     * 评论生成时的GMT unix时间戳
     */
    @NonNull
    private Integer created;

    /**
     * 评论作者
     */
    @NonNull
    private String author;

    /**
     * 评论所属用户id
     */
    @NonNull
    private Integer authorId;

    /**
     * 评论所属内容作者id
     */
    @NonNull
    private Integer ownerId;

    /**
     * 评论者邮件
     */
    private String mail;

    /**
     * 评论者网址
     */
    private String url;

    /**
     * 评论者ip地址
     */
    private String ip;

    /**
     * 评论者客户端
     */
    private String agent;

    /**
     * 评论类型
     */
    @NonNull
    private String type;

    /**
     * 评论状态
     */
    @NonNull
    private String status;

    /**
     * 父级评论
     */
    @NonNull
    private Integer parent;

    /**
     * 评论内容
     */
    @NonNull
    private String content;
}
