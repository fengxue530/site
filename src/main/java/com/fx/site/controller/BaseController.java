package com.fx.site.controller;

import com.fx.site.constant.Types;
import com.fx.site.constant.WebConst;
import com.fx.site.entity.MetaEntity;
import com.fx.site.service.meta.MetaService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @auther: mabaofeng
 * @date: 2019/10/29 14:37
 * @description: 获取一些公共数据
 */
public abstract class BaseController {

    @Autowired
    private MetaService metaService;


    public BaseController blogBaseData(HttpServletRequest request) {
        List<MetaEntity> links = metaService.getMetaList(Types.LINK.getType(), WebConst.MAX_POSTS);
        request.setAttribute("links", links);
        return this;
    }
}
