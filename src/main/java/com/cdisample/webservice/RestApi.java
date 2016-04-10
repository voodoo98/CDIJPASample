package com.cdisample.webservice;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/restapi")
@Produces(MediaType.APPLICATION_JSON)
public interface RestApi {

	@GET
	@Path("/versions")
	Response getVersions() throws Exception;

	@POST
	@Path("/version/{version}")
	Response addVersion(@PathParam("version") String version);

	@PUT
	@Path("/version/{oldversion}/{newversion}")
	Response modifyVersion(@PathParam("oldversion") String oldVersion, @PathParam("newversion") String newVersion);

	@DELETE
	@Path("/version/{version}")
	Response deleteVersion(@PathParam("version") String version);

}
