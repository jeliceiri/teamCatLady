package com.teamcatlady.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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
     * A utility object used for mapping POJOs to XML strings.
     */
    private XmlMapper xmlMapper = new XmlMapper();

    /**
     * Log4J2 instance for all logging.
     */
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Helper method for all API endpoints that return a singular president value as JSON, as a string.
     *
     * @param president a singular president returned from the dao
     * @return a JSON response as a string
     */
    public String jsonFormatHelper(President president) {
        String responseJSON = "";

        try {
            responseJSON = objectMapper.writeValueAsString(president);
        } catch (Exception e) {
            logger.error("", e);
        }

        return responseJSON;
    }

    /**
     * Helper method for all API endpoints that return a List of presidents formatted as JSON, as a string.
     *
     * @param listOfPresidents a list of presidents returned by the dao
     * @return a JSON Response as a String
     */
    public String jsonFormatHelper(List<President> listOfPresidents) {
        String responseJSON = "";

        try {
            responseJSON = objectMapper.writeValueAsString(listOfPresidents);
        } catch (Exception e) {
            logger.error("", e);
        }

        return responseJSON;
    }

    /**
     * Helper method for all API endpoints that return a singular president value as XML, as a string.
     *
     * @param president a singular president returned from the dao
     * @return a XML response as a string
     */
    public String xmlFormatHelper(President president) {
        String responseXML = "";

        try {
            responseXML = xmlMapper.writeValueAsString(president);
        } catch (Exception e) {
            logger.error("", e);
        }

        return responseXML;
    }

    /**
     * Helper method for all API endpoints that return a List of presidents formatted as XML, as a string.
     *
     * @param listOfPresidents a list of presidents returned by the dao
     * @return a XML Response as a String
     */
    public String xmlFormatHelper(List<President> listOfPresidents) {
        String responseXML = "";

        try {
            responseXML = xmlMapper.writeValueAsString(listOfPresidents);
        } catch (Exception e) {
            logger.error("", e);
        }

        return responseXML;
    }

    /**
     * This endpoint returns all the presidents in JSON format.
     *
     * @return a Response of all presidents as JSON
     */
    @GET
    @Produces("application/json")
    public Response getAllPresidents() {
        List<President> allPresidents = dao.getAll();
        String responseJSON = "";

        try {
            responseJSON = objectMapper.writeValueAsString(allPresidents);
        } catch (Exception e) {
            logger.error("", e);
        }

        return Response.status(200).entity(responseJSON).build();
    }

    /**
     * This endpoint returns all the presidents in an XML format.
     *
     * @return a Response of all presidents as XML
     */
    @GET
    @Produces("application/xml")
    @Path("xml")
    public Response getAllPresidentsXML() {
        List<President> allPresidents = dao.getAll();
        String responseXML = "";

        try {
            responseXML = xmlMapper.writeValueAsString(allPresidents);
        } catch (Exception e) {
            logger.error("", e);
        }

        return Response.status(200).entity(responseXML).build();
    }

    /**
     * This endpoint returns all the presidents in a plaintext format.
     *
     * @return a Response of all presidents as plaintext
     */
    @GET
    @Produces("text/plain")
    @Path("plaintext")
    public Response getAllPresidentsPlaintext() {
        List<President> allPresidents = dao.getAll();
        String responseString = "";

        try {
            responseString = allPresidents.toString();
        } catch (Exception e) {
            logger.error("", e);
        }

        return Response.status(200).entity(responseString).build();
    }

    // TODO /presidents/id/:id/
    @GET
    @Path("/id/{id}/")
    @Produces("application/json")
    public Response getPresidentByID(@PathParam("id") int id) {
        President president = dao.getById(id);
        String responseJSON = jsonFormatHelper(president);
        return Response.status(200).entity(responseJSON).build();
    }

    @GET
    @Path("/id/{id}/xml")
    @Produces("application/xml")
    public Response getPresidentByIDXML(@PathParam("id") int id) {
        President president = dao.getById(id);
        String responseXML = xmlFormatHelper(president);
        return Response.status(200).entity(responseXML).build();
    }

//    @GET
//    @Path("/id/{id}/plaintext")
//    @Produces("text/plain")
//    public Response getPresidentByIDPlaintext(@PathParam("id") int id) {
//        President president = dao.getById(id);
//        String response = president.toString();
//        return Response.status(200).entity(response).build();
//    }

    // TODO /presidents/id/:id/:responseType
//    @GET
//    @Path("{id}/{responseType}")
//    @Produces("application/json")
//    public Response getPresidentByID(int id, String responseType) {
//
//    }

    // TODO /presidents/party/:party/:responseType


    // TODO /presidents/living/:aliveOrDeadBool/:responseType

    // TODO PUT /president/id/:id

}
