package com.fx.site;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@EnableCaching
public class SiteApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SiteApplication.class, args);
    }

    @Profile(value = {"war"})
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SiteApplication.class);
    }
}
