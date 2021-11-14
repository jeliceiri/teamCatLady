package com.teamcatlady.api;

import javax.ws.rs.*;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.teamcatlady.entity.President;
import com.teamcatlady.persistence.PresidentDao;
import io.swagger.annotations.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This contains all the endpoints underneath /presidents, which is most of our application!
 *
 * @author Team Cat Lady
 */
@Path("/presidents")
@Api(tags={"presidents"})
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
     * Helper method for all API endpoints that returns an individual president in plaintext, as a string.
     * While this might be a bit redundant, I added this for hypothetical future-proofing, in case we did
     * want to change how the API formats its plaintext response.
     *
     * @param president a single president returned by the dao
     * @return a string of plaintext representing that president
     */
    public String plaintextFormatHelper(President president) {
        String responseString = president.toString();
        return responseString;
    }

    /**
     * Helper method for all API endpoints that returns a list of presidents in plaintext, as a string.
     * While this might be a bit redundant, I added this for hypothetical future-proofing, in case we did
     * want to change how the API formats its plaintext response. Having a second method is required for
     * polymorphism, but also hypothetically you might want to format a list of presidents differently.
     *
     * @param listOfPresidents a list of presidents returned by the dao
     * @return a string of plaintext representing that list of presidents
     */
    public String plaintextFormatHelper(List<President> listOfPresidents) {
        String responseString = listOfPresidents.toString();
        return responseString;
    }

    /**
     * This endpoint returns all the presidents in JSON format.
     *
     * @return a List of all presidents as JSON
     */
    @GET
    @Produces("application/json")
    @ApiOperation(value="Fetches all presidents")
    @ApiResponses({
            @ApiResponse(code=200, message="Success")
    })
    public Response getAllPresidents() {
        logger.info("getAllPresidents JSON endpoint called.");
        List<President> allPresidents = dao.getAll();
        String responseJSON = "";

        try {
            responseJSON = objectMapper.writeValueAsString(allPresidents);
        } catch (Exception e) {
            logger.error("", e);
        }

        logger.info("Returning 200 response now...");
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
    @ApiOperation(value="Fetches all presidents, formatted as XML")
    @ApiResponses({
            @ApiResponse(code=200, message="Success")
    })
    public Response getAllPresidentsXML() {
        logger.info("getAllPresidents XML endpoint called.");
        List<President> allPresidents = dao.getAll();
        String responseXML = "";

        try {
            responseXML = xmlMapper.writeValueAsString(allPresidents);
        } catch (Exception e) {
            logger.error("", e);
        }

        logger.info("Returning 200 response now...");
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
    @ApiOperation(value="Fetches all presidents, formatted as plaintext")
    @ApiResponses({
            @ApiResponse(code=200, message="Success")
    })
    public Response getAllPresidentsPlaintext() {
        logger.info("getAllPresidents plaintext endpoint called.");
        List<President> allPresidents = dao.getAll();
        String responseString = plaintextFormatHelper(allPresidents);

        logger.info("Returning 200 response now...");
        return Response.status(200).entity(responseString).build();
    }

    /**
     * This endpoint returns a singular president by ID formatted as JSON.
     *
     * @param id of the president to search for
     * @return a JSON string representing the president
     */
    @GET
    @Path("/id/{id}/")
    @ApiOperation(value="Fetches a president by ID number")
    @ApiResponses({
            @ApiResponse(code=200, message="Success"),
            @ApiResponse(code=404, message="Not found")
    })
    @Produces("application/json")
    public Response getPresidentByID(@ApiParam(required=true) @PathParam("id") int id) {
        logger.info("getPresidentByID (JSON) searching for ID: " + id);
        President president = dao.getById(id);
        String responseJSON = jsonFormatHelper(president);
        logger.info("Returning 200 response now...");
        return Response.status(200).entity(responseJSON).build();
    }

    /**
     * This endpoint returns a singular president by ID formatted as XML.
     *
     * @param id of the president to search for
     * @return an XML string representing the president
     */
    @GET
    @Path("/id/{id}/xml")
    @ApiOperation(value="Fetches a president by ID number, formatted as XML")
    @ApiResponses({
            @ApiResponse(code=200, message="Success"),
            @ApiResponse(code=404, message="Not found")
    })
    @Produces("application/xml")
    public Response getPresidentByIDXML(@ApiParam(required=true) @PathParam("id") int id) {
        logger.info("getPresidentByID (XML) searching for ID: " + id);
        President president = dao.getById(id);
        String responseXML = xmlFormatHelper(president);
        logger.info("Returning 200 response now...");
        return Response.status(200).entity(responseXML).build();
    }

    /**
     * This endpoint returns a singular president by ID formatted as plaintext.
     *
     * @param id of the president to search for
     * @return a plaintext string representing the president
     */
    @GET
    @Path("/id/{id}/plaintext")
    @ApiOperation(value="Fetches a president by ID number, formatted as plaintext")
    @ApiResponses({
            @ApiResponse(code=200, message="Success"),
            @ApiResponse(code=404, message="Not found")
    })
    @Produces("text/plain")
    public Response getPresidentByIDPlaintext(@ApiParam(required=true) @PathParam("id") int id) {
        logger.info("getPresidentByID (plaintext) searching for ID: " + id);
        President president = dao.getById(id);
        String response = plaintextFormatHelper(president);
        logger.info("Returning 200 response now...");
        return Response.status(200).entity(response).build();
    }

    /**
     * This endpoint returns a list of presidents by party, formatted as JSON.
     *
     * @param party A string representing the party to search for
     * @return A JSON string representing the list of presidents
     */
    @GET
    @Path("/party/{party}")
    @Produces("application/json")
    @ApiOperation(value="Gets all presidents by party")
    @ApiResponses({
            @ApiResponse(code=200, message="Success"),
            @ApiResponse(code=404, message="Not found")
    })
    public Response getPresidentByParty(@ApiParam(required=true) @PathParam("party") String party) {
        logger.info("getPresidentByParty (JSON) searching by party: " + party);
        List<President> listOfPresidents = dao.getByParty(party);
        String responseJSON = jsonFormatHelper(listOfPresidents);
        logger.info("Returning 200 response now...");
        return Response.status(200).entity(responseJSON).build();
    }

    /**
     * This endpoint returns a list of presidents by party, formatted as XML.
     *
     * @param party A string representing the party to search for
     * @return An XML string representing the list of presidents
     */
    @GET
    @Path("/party/{party}")
    @Produces("application/xml")
    @ApiOperation(value="Gets all presidents by party, formatted as XML")
    @ApiResponses({
            @ApiResponse(code=200, message="Success"),
            @ApiResponse(code=404, message="Not found")
    })
    public Response getPresidentByPartyXML(@ApiParam(required=true) @PathParam("party") String party) {
        logger.info("getPresidentByParty (XML) searching by party: " + party);
        List<President> listOfPresidents = dao.getByParty(party);
        String responseJSON = xmlFormatHelper(listOfPresidents);
        logger.info("Returning 200 response now...");
        return Response.status(200).entity(responseJSON).build();
    }

    /**
     * This endpoint returns a list of presidents by party, as plaintext.
     *
     * @param party A string representing the party to search for
     * @return An plaintext string representing the list of presidents
     */
    @GET
    @Path("/party/{party}")
    @Produces("text/plain")
    @ApiOperation(value="Gets all presidents by party, formatted as plaintext")
    @ApiResponses({
            @ApiResponse(code=200, message="Success"),
            @ApiResponse(code=404, message="Not found")
    })
    public Response getPresidentByPartyPlaintext(@ApiParam(required=true) @PathParam("party") String party) {
        logger.info("getPresidentByParty (plaintext) searching by party: " + party);
        List<President> listOfPresidents = dao.getByParty(party);
        String responseJSON = plaintextFormatHelper(listOfPresidents);
        logger.info("Returning 200 response now...");
        return Response.status(200).entity(responseJSON).build();
    }

    /**
     * This endpoint returns a list of presidents according to whether they are alive
     * or not. The endpoint must receive a boolean.
     *
     * @param isAlive a boolean indicating whether they want living (true) or dead (false) presidents
     * @return A JSON string representing the list of presidents
     */
    @GET
    @Path("living/{isAlive}")
    @Produces("application/json")
    @ApiOperation(value="Gets a list of all presidents according to whether they are alive or not",
            notes = "Accepts a boolean. True will return living presidents, and false will return deceased presidents.")
    @ApiResponses({
            @ApiResponse(code=200, message="Success"),
    })
    public Response getPresidentByLivingStatus(@ApiParam(required=true) @PathParam("isAlive") Boolean isAlive) {
        logger.info("getPresidentByLivingStatus (JSON) searching by living status: " + isAlive);
        List<President> listOfPresidents = isAlive ? dao.getAllLivingPresidents() : dao.getAllDeadPresidents();
        String responseJSON = jsonFormatHelper(listOfPresidents);
        logger.info("Returning 200 response now...");
        return Response.status(200).entity(responseJSON).build();
    }

    /**
     * This endpoint returns a list of presidents according to whether they are alive
     * or not. The endpoint must receive a boolean.
     *
     * @param isAlive a boolean indicating whether they want living (true) or dead (false) presidents
     * @return An XML string representing the list of presidents
     */
    @GET
    @Path("living/{isAlive}/xml")
    @Produces("application/xml")
    @ApiOperation(value="Gets a list of all presidents according to whether they are alive or not, formatted as XML",
            notes = "Accepts a boolean. True will return living presidents, and false will return deceased presidents. ")
    @ApiResponses({
            @ApiResponse(code=200, message="Success"),
    })
    public Response getPresidentByLivingStatusXML(@ApiParam(required=true) @PathParam("isAlive") Boolean isAlive) {
        logger.info("getPresidentByLivingStatus (XML) searching by living status: " + isAlive);
        List<President> listOfPresidents = isAlive ? dao.getAllLivingPresidents() : dao.getAllDeadPresidents();
        String responseJSON = xmlFormatHelper(listOfPresidents);
        logger.info("Returning 200 response now...");
        return Response.status(200).entity(responseJSON).build();
    }

    /**
     * This endpoint returns a list of presidents according to whether they are alive
     * or not. The endpoint must receive a boolean.
     *
     * @param isAlive a boolean indicating whether they want living (true) or dead (false) presidents
     * @return A plaintext string representing the list of presidents
     */
    @GET
    @Path("living/{isAlive}/plaintext")
    @Produces("text/plain")
    @ApiOperation(value="Gets a list of all presidents according to whether they are alive or not, formatted as plaintext",
            notes = "Accepts a boolean. True will return living presidents, and false will return deceased presidents.")
    @ApiResponses({
            @ApiResponse(code=200, message="Success"),
    })
    public Response getPresidentByLivingStatusPlaintext(@ApiParam(required=true) @PathParam("isAlive") Boolean isAlive) {
        logger.info("getPresidentByLivingStatus (plaintext) searching by living status: " + isAlive);
        List<President> listOfPresidents = isAlive ? dao.getAllLivingPresidents() : dao.getAllDeadPresidents();
        String responseJSON = plaintextFormatHelper(listOfPresidents);
        logger.info("Returning 200 response now...");
        return Response.status(200).entity(responseJSON).build();
    }

    /**
     * Use this endpoint to update a presidential record.
     *
     * @param id The ID of the president being updated
     * @param president a JSON object shaped as the President class that contains the ID
     *                  of the president to update, and any values to replace
     *                  its existing values in the database.
     * @return A 200 response if was successful
     */
    @PUT
    @Path("id/{id}")
    @Consumes("application/json")
    @ApiOperation(value="Updates an existing President")
    // Trying to format the model property to look like an object, this is not working
    /*
    @ApiModelProperty(
            value = "A JSON value representing a transaction. An example of the expected schema can be found down here. The fields marked with an * means that they are required.",
            example = "{foo: whatever, bar: whatever2}")

     */
    @ApiResponses({
            @ApiResponse(code=204, message="Success"),
            @ApiResponse(code=404, message="Not Found")
    })
    public void updatePresident(
            @ApiParam(required = true) @PathParam("id") int id,
            @ApiParam(required = true) String president) throws JsonProcessingException

    {
        President presidentToUpdate = objectMapper.readValue(president, President.class);
        logger.info("Updating the president with ID: " + id);
        logger.info("Presidential data provided: " + president.toString());
        dao.saveOrUpdate(presidentToUpdate);
        logger.info("Returning 200 response now...");
    }

    /**
     * This endpoint is used for administrative purposes to add a new president.
     *
     * @param president a JSON object representing the President, with all instance
     *                  values except ID provided.
     * @return a 200 response if the POST was successful, otherwise a bad request status
     */
    @POST
    @Consumes("application/json")
    @ApiOperation(value="Creates a new President")
    @ApiResponses({
            @ApiResponse(code=204, message="Success")
    })
    public void addPresident(@ApiParam(required=true)President president) {
        logger.info("Adding a new president with the presidential data: " + president.toString());
        int id = dao.insert(president);
        if (id == 0) {
            logger.info("Returning bad request.");
        } else {
            logger.info("Successfully added ID: " + id);
        }
    }
}