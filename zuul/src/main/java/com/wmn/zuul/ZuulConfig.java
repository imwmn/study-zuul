package com.wmn.zuul;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: wmn
 * @Date: 2020/4/27 11:12
 */
@ConfigurationProperties(prefix = "zuul")
@RefreshScope
public class ZuulConfig {

    public ZuulProperties zuulProperties(){
        return new ZuulProperties();
    }
}
