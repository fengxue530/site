package com.fx.site.constant;

/**
 * @auther: mabaofeng
 * @date: 2019/10/29 14:45
 * @description: 类型
 */
public enum Types {

    ARTICLE("post"),
    /**
     * 附件存放的URL，默认为网站地址，如集成第三方则为第三方CDN域名
     */
    ATTACH_URL("attach_url"),
    /**
     * 网站要过滤，禁止访问的ip列表
     */
    BLOCK_IPS("site_block_ips"),
    CATEGORY("category"),
    COMMENTS_FREQUENCY("comments:frequency"),
    CSRF_TOKEN("csrf_token"),
    DRAFT("draft"),
    FILE("file"),
    IMAGE("image"),
    LINK("link"),
    PAGE("page"),
    PUBLISH("publish"),

    PHOTO("photo"),

    TAG("tag");

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    Types(String type) {
        this.type = type;
    }

}
