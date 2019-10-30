package com.fx.site.dto.cond;

import lombok.Getter;
import lombok.Setter;

/**
 * @auther: mabaofeng
 * @date: 2019/10/30 13:48
 * @description: 评论的查找参数
 */
@Setter
@Getter
public class CommentCond {

    /**
     * 状态
     */
    private String status;
    /**
     * 开始时间戳
     */
    private Integer startTime;
    /**
     * 结束时间戳
     */
    private Integer endTime;

    /**
     * 父评论编号
     */
    private Integer parent;
}
