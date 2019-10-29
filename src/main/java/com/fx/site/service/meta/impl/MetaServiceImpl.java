package com.fx.site.service.meta.impl;

import com.fx.site.constant.WebConst;
import com.fx.site.dao.MetaDao;
import com.fx.site.entity.MetaEntity;
import com.fx.site.service.meta.MetaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther: mabaofeng
 * @date: 2019/10/29 14:39
 * @description:
 */
@Service
public class MetaServiceImpl implements MetaService {

    @Autowired(required = false)
    private MetaDao metaDao;


    @Override
    public List<MetaEntity> getMetaList(String type, int limit) {
        if (StringUtils.isNotEmpty(type)) {
            if (limit < 0 | limit > WebConst.MAX_POSTS) {
                limit = 10;
            }
            Map<String, Object> parameters = new HashMap<>(4);
            parameters.put("limit", limit);
            parameters.put("type", type);
            return metaDao.selectFromSql(parameters);
        }
        return null;
    }
}
