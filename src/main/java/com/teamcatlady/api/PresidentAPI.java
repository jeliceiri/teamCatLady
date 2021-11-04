package com.teamcatlady.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teamcatlady.entity.President;
import com.teamcatlady.persistence.PresidentDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * This contains all the endpoints underneath /presidents, which is most of our application!
 *
 * @author Team Cat Lady
 */
@Path("/presidents")
public class PresidentAPI {

    /**
     * Represents and handles all database connectivity for Presidents-related data
     */
    private PresidentDao dao = new PresidentDao();

    /**
     * A utility object, used for mapping POJOs to JSON strings here.
     */
    private ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Log4J2 instance for all logging.
     */
    private final Logger logger = LogManager.getLogger(this.getClass());

    @GET
    // TODO what should the default return type be? JSON?
    public Response getAllPresidents() {
        List<President> allPresidents = new ArrayList<>();
        String responseJSON = "";

        try {
            responseJSON = objectMapper.writeValueAsString(allPresidents);
        } catch (Exception e) {
            logger.error(e.getStackTrace());
        }

        return Response.status(200).entity(responseJSON).build();
    }

}
