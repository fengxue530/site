package com.fx.site.service.meta;

import com.fx.site.entity.MetaEntity;

import java.util.List;

/**
 * @auther: mabaofeng
 * @date: 2019/10/29 14:39
 * @description:
 */
public interface MetaService {
    /**
     * 获取所有外链
     *
     * @param type
     * @param limit
     * @return
     */
    List<MetaEntity> getMetaList(String type, int limit);
}
