package com.teamcatlady.api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents the entire Presidents API
 *
 * @author Team Cat Lady
 */
@ApplicationPath("/api")
public class API extends Application {

    /**
     * Establishes endpoints for the API
     *
     * @return hashset of endpoints
     */
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(PresidentAPI.class);
        return h;
    }

}
