package com.fx.site.entity;

import lombok.Data;
import lombok.NonNull;

/**
 * @auther: mabaofeng
 * @date: 2019/10/29 10:47
 * @description: 网站图片相关
 */
@Data
public class AttAchEntity {

    /** 主键编号 */
    @NonNull
    private Integer id;
    /** 文件名称 */
    @NonNull
    private String fname;
    /** 文件类型 */
    @NonNull
    private String ftype;
    /** 文件的地址 */
    @NonNull
    private String fkey;
    /** 创建人的id */
    @NonNull
    private Integer authorId;
    /** 创建的时间戳 */
    @NonNull
    private Integer created;

}
