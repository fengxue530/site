package com.fx.site.dto.cond;

import lombok.Getter;
import lombok.Setter;

/**
 * @auther: mabaofeng
 * @date: 2019/10/30 13:53
 * @description:
 */
@Getter
@Setter
public class ContentCond {

    /**
     * 标签
     */
    private String tag;
    /**
     * 类别
     */
    private String category;
    /**
     * 状态
     */
    private String status;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容匹配
     */
    private String content;
    /**
     * 文章类型
     */
    @Setter
    private String type;

    /**
     * 开始时间戳
     */
    private Integer startTime;

    /**
     * 结束时间戳
     */
    private Integer endTime;
}
