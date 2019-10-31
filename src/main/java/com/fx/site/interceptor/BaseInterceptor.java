package com.fx.site.interceptor;

import com.fx.site.service.option.OptionService;
import com.fx.site.service.user.UserService;
import com.fx.site.utils.AdminCommons;
import com.fx.site.utils.Commons;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @auther: mabaofeng
 * @date: 2019/10/31 15:18
 * @description:
 */
@Component
public class BaseInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(BaseInterceptor.class);

    private static String USER_AGENT = "user_agent";

    @Autowired
    private UserService userService;

    @Autowired
    private OptionService optionService;

    @Autowired
    private Commons commons;

    @Autowired
    private AdminCommons adminCommons;

}
