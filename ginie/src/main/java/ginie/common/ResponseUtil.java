package ginie.common;

import ginie.enums.Result;

import javax.ws.rs.core.Response;

/**
 * Created by dhruvr on 6/8/16.
 */
public class ResponseUtil {


    private static String RESULT = "result";

    public static Response successResponse() {
        return Response.ok(JsonUtils.getResultJson(RESULT, Result.SUCCESS)).build();
    }


    public static Response internalServerError() {
        return Response.serverError().entity(JsonUtils.getResultJson(RESULT, Result.FAILURE)).build();
    }

    public static Response badRequest() {
        return Response.status(Response.Status.BAD_REQUEST).entity(JsonUtils.getResultJson(RESULT, Result.FAILURE)).build();
    }
}
