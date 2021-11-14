package com.teamcatlady.api;

import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


/**
 * Represents the entire Presidents API
 * Inspiration for this class from: https://github.com/synaptik-labs/javaee-series
 *
 * @author Team Cat Lady
 */
@ApplicationPath("/api")
public class API extends Application {

    /**
     * Instantiates a new Api.
     */
    public API() {
        init();
    }

    private void init() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setTitle("Presidents API");
        beanConfig.setBasePath("/teamCatLady_war/api");
        beanConfig.setResourcePackage(API.class.getPackage().getName());
        beanConfig.setScan(true);
    }

}