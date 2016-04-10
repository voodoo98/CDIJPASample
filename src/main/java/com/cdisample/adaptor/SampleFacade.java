package com.cdisample.adaptor;

import java.util.List;

public interface SampleFacade {

	List<VersionStub> getVersions();

	void addVersion(String version);

	boolean modifyVersion(String oldVersion, String newVersion);

	boolean deleteVersion(String version);

}
