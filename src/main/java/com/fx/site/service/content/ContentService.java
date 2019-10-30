package com.fx.site.service.content;

import com.fx.site.dto.cond.ContentCond;
import com.fx.site.entity.ContentEntity;
import com.github.pagehelper.PageInfo;

/**
 * @auther: mabaofeng
 * @date: 2019/10/30 10:35
 * @description:
 */
public interface ContentService {
    PageInfo<ContentEntity> getArticlesByCond(ContentCond contentCond, int p, int limit);
}
