package com.fx.site.service.comment.impl;

import com.fx.site.dao.CommentDao;
import com.fx.site.service.comment.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther: mabaofeng
 * @date: 2019/10/30 10:44
 * @description:
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired(required = false)
    private CommentDao commentDao;

}
