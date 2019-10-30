package com.fx.site.service.content.impl;

import com.fx.site.dao.ContentDao;
import com.fx.site.dto.cond.ContentCond;
import com.fx.site.entity.ContentEntity;
import com.fx.site.service.content.ContentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther: mabaofeng
 * @date: 2019/10/30 10:35
 * @description:
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired(required = false)
    private ContentDao contentDao;

    /**
     * 根据条件分页查找文章
     * @param contentCond
     * @param p
     * @param limit
     * @return
     */
    @Override
    public PageInfo<ContentEntity> getArticlesByCond(ContentCond contentCond, int p, int limit) {
        PageHelper.startPage(p, limit);
        List<ContentEntity> contents = contentDao.getArticlesByCond(contentCond);
        PageInfo<ContentEntity> pageInfo = new PageInfo<>(contents);
        return pageInfo;
    }
}
