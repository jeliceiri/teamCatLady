package com.teamcatlady.api;

import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


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
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setTitle("Presidents API");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("teamcatladypresidentsrestfulapi-env.eba-3avvmewu.us-east-2.elasticbeanstalk.com/");
        beanConfig.setBasePath("/api");
        //beanConfig.setBasePath("/teamCatLady_war/api");
        beanConfig.setResourcePackage(API.class.getPackage().getName());
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();
        resources.add(com.teamcatlady.api.PresidentAPI.class);
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        return resources;
    }
}