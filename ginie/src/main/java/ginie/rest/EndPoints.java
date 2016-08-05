package ginie.rest;

import com.google.inject.Inject;
import ginie.common.ResponseUtil;
import ginie.mongo.service.MongoServices;
import ginie.settings.GinieSettings;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by dhruvr
 */
@Path("/")
@Singleton
public class EndPoints {

    private static final Logger LOGGER = LoggerFactory.getLogger(EndPoints.class);

    @Inject
    private MongoServices mongoServices;

    @Inject
    private GinieSettings settings;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hi() {
        return "\"_\"";
    }


    @POST
    @Path("/echo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String echo(String json) {
        LOGGER.info("Json {} ", json);
        return json;
    }

    @Path("/save")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insert(String json) {

        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            return ResponseUtil.badRequest();
        }

        try {
            mongoServices.insertMicroInfo(jsonObject);
            return ResponseUtil.successResponse();
        } catch (Exception e) {
            return ResponseUtil.internalServerError();
        }
    }


    @Path("/find")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByTag(String json) {

        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            return ResponseUtil.badRequest();
        }

        try {
            String jsonResult = mongoServices.getMicroByTag(jsonObject).toString();
            return Response.ok(jsonResult).build();
        } catch (Exception e) {
            return ResponseUtil.internalServerError();
        }
    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAll() {
        try {
            return Response.ok(mongoServices.listAllMicrosInfo().toString()).build();
        } catch (Exception e) {
            return ResponseUtil.internalServerError();
        }
    }


    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(String json) {

        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(json);
        } catch (JSONException e) {
            return ResponseUtil.badRequest();
        }

        try {

            String username = jsonObject.getString("username");
            String password = jsonObject.getString("password");

            if (username.equals(settings.get("username")) && password.equals(settings.get("password"))) {
                return ResponseUtil.token(settings.get("security.token"));
            } else {
                return ResponseUtil.unauthorised();
            }
        } catch (Exception e) {
            return ResponseUtil.internalServerError();
        }
    }


}
