package com.fx.site.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @auther: mabaofeng
 * @date: 2019/10/29 13:49
 * @description: 网站配置项实体
 */
@Setter
@Getter
public class OptionsEntity {

    /** 名称 */
    private String name;
    /** 内容 */
    private String value;
    /** 备注 */
    private String description;
}
