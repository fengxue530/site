package com.fx.site.controller;

import com.fx.site.constant.Types;
import com.fx.site.constant.WebConst;
import com.fx.site.dto.cond.CommentCond;
import com.fx.site.dto.cond.ContentCond;
import com.fx.site.entity.ContentEntity;
import com.fx.site.service.comment.CommentService;
import com.fx.site.service.content.ContentService;
import com.fx.site.service.site.SiteService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;

/**
 * @auther: mabaofeng
 * @date: 2019/10/30 10:27
 * @description:
 */
@Api
@Controller
@RequestMapping
public class HomeController extends BaseController {

    @Autowired
    private ContentService contentService;

    @Autowired
    private SiteService siteService;

    @Autowired
    private CommentService commentService;

    @ApiIgnore
    @GetMapping(value = {"/adout", "/index/about"})
    public String getAbout(HttpServletRequest request) {
        this.blogBaseData(request);
        request.setAttribute("active", "about");
        return "site/about";
    }

    @ApiOperation("blog首页")
    @GetMapping(value = {"/blog/", "/blog/index"})
    public String blogIndex(HttpServletRequest request,
                            @ApiParam(name = "limit", value = "页数", required = false)
                            @RequestParam(name = "limit", required = false, defaultValue = "10")
                                    int limit) {
        return this.blogIndex(request, 1, limit);

    }

    @ApiOperation("blog首页 - 分页")
    @GetMapping(value = {"/blog", "/blog/index/"})
    public String blogIndex(HttpServletRequest request,
                            @PathVariable
                                    int p,
                            @RequestParam(name = "limit", required = false, defaultValue = "10")
                                    int limit) {
        p = p < 0 || p > WebConst.MAX_POSTS ? 10 : p;
        ContentCond contentCond = new ContentCond();
        contentCond.setType(Types.ARTICLE.getType());
        PageInfo<ContentEntity> articles = contentService.getArticlesByCond(contentCond, p, limit);
        request.setAttribute("articles", articles);
        request.setAttribute("type", "articles");
        request.setAttribute("active", "blog");
        return "site/blog";
    }
}

