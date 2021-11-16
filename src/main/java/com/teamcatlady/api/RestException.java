package com.teamcatlady.api;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * The type Rest exception.
 * Inspired by: https://self-learning-java-tutorial.blogspot.com/2017/08/return-http-status-code-for-exceptions.html
 */
public class RestException extends WebApplicationException {

    private static final long serialVersionUID = 1L;

    /**
     * Instantiates a new Rest exception.
     *
     * @param message the message
     * @param status  the status
     */
    public RestException(String message, Status status) {
        super(Response.status(status).entity(message).type(MediaType.TEXT_PLAIN).build());
    }
}
