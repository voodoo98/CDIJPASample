package com.cdisample.dataservice;

import java.util.List;

import com.cdisample.dataservice.persistance.Version;

public interface SampleDataService {

	List<Version> getVersion();

	void addVersion(String version);

	boolean modifyVersion(String oldVersion, String newVersion);

	boolean deleteVersion(String version);

}
