package com.fx.site.dao;

import com.fx.site.dto.cond.ContentCond;
import com.fx.site.entity.ContentEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @auther: mabaofeng
 * @date: 2019/10/30 10:36
 * @description:
 */
@Mapper
public interface ContentDao {
    List<ContentEntity> getArticlesByCond(ContentCond contentCond);
}
