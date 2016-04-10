package com.cdisample.webservice;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import com.cdisample.adaptor.SampleFacade;
import com.cdisample.adaptor.VersionStub;
import com.cdisample.annotations.JacksonMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

@ApplicationScoped
public class RestApiImpl implements RestApi {

	@Inject
	@JacksonMapper
	private ObjectMapper mapper;

	@Inject
	private SampleFacade sampleFacade;

	@Override
	public Response getVersions() {
		final List<VersionStub> result = this.sampleFacade.getVersions();
		final JacksonStreamingOutput<List<VersionStub>> stream = new JacksonStreamingOutput<>(this.mapper, result);
		return Response.ok(stream).build();
	}

	@Override
	public Response addVersion(final String version) {
		this.sampleFacade.addVersion(version);
		return Response.ok().build();
	}

	@Override
	public Response modifyVersion(final String oldVersion, final String newVersion) {
		return this.sampleFacade.modifyVersion(oldVersion, newVersion) ? Response.ok().build() : Response.notModified().build();
	}

	@Override
	public Response deleteVersion(final String version) {
		return this.sampleFacade.deleteVersion(version) ? Response.ok().build() : Response.notModified().build();
	}

}
