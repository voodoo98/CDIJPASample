package com.cdisample.adaptor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.cdisample.dataservice.SampleDataService;
import com.cdisample.dataservice.persistance.Version;

public class SampleFacadeImpl implements SampleFacade {

	@Inject
	private SampleDataService dataService;

	@Override
	public List<VersionStub> getVersions() {
		final List<Version> versionList = this.dataService.getVersion();
		final List<VersionStub> result = new ArrayList<>(versionList.size());
		for (final Version version : versionList) {
			result.add(VersionStub.create(version.getVersion()));
		}
		return result;
	}

	@Override
	public void addVersion(final String version) {
		this.dataService.addVersion(version);
	}

	@Override
	public boolean modifyVersion(final String oldVersion, final String newVersion) {
		return this.dataService.modifyVersion(oldVersion, newVersion);
	}

	@Override
	public boolean deleteVersion(final String version) {
		return this.dataService.deleteVersion(version);
	}

}
