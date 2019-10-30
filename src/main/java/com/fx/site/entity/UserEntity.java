package com.fx.site.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @auther: mabaofeng
 * @date: 2019/10/29 13:55
 * @description:
 */
@Setter
@Getter
public class UserEntity {

    /** 主键编号 */
    @NonNull
    private Integer uid;
    /** 用户名 */
    @NonNull
    private String username;
    /** 密码 */
    @NonNull
    private String password;
    /** email */
    private String email;
    /** 主页地址 */
    private String homeUrl;
    /**  用户显示的名称 */
    private String screenName;
    /** 用户注册时的GMT unix时间戳 */
    @NonNull
    private Integer created;
    /** 最后活动时间 */
    private Integer activated;
    /** 上次登录最后活跃时间 */
    private Integer logged;
    /** 用户组 */
    private String groupName;
}
