package com.teamcatlady.api;

import io.swagger.jaxrs.config.BeanConfig;

import javax.servlet.ServletConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents the entire Presidents API
 *
 * @author Team Cat Lady
 */
@ApplicationPath("/api")
public class API extends Application {

    public API(@Context ServletConfig servletConfig) {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setTitle("Presidents API");
        beanConfig.setBasePath("/teamCatLady_war/api");
        //beanConfig.setBasePath("/todo/api");
        beanConfig.setResourcePackage("com.teamcatlady.api");
        beanConfig.setScan(true);
    }
    /**
     * Establishes endpoints for the API
     *
     * @return hashset of endpoints
     */
    /*
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(PresidentAPI.class);
        return h;
    }

     */

}
