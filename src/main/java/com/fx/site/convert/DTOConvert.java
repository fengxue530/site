package com.fx.site.convert;

/**
 * @auther: mabaofeng
 * @date: 2019/10/29 16:05
 * @description:  entity 和 dto 转化接口
 */
public interface DTOConvert<S, T> {
    T convert(S s);
}
