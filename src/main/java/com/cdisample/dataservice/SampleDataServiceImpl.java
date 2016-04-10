package com.cdisample.dataservice;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cdisample.dataservice.persistance.Version;
import com.cdisample.dataservice.persistance.VersionManager;
import com.cdisample.dataservice.persistance.exception.PersistenceServiceException;

public class SampleDataServiceImpl implements SampleDataService {

	private final static Logger LOGGER = LoggerFactory.getLogger(SampleDataServiceImpl.class);

	@Inject
	private VersionManager versionManager;

	@Override
	public List<Version> getVersion() {
		return this.versionManager.get();
	}

	@Override
	public void addVersion(final String version) {
		this.versionManager.add(version);
	}

	@Override
	public boolean modifyVersion(final String oldVersion, final String newVersion) {
		boolean result;
		try {
			this.versionManager.modify(oldVersion, newVersion);
			result = true;
		} catch (final PersistenceServiceException e) {
			result = false;
			LOGGER.warn(e.getMessage());
		}
		return result;
	}

	@Override
	public boolean deleteVersion(final String version) {
		boolean result;
		try {
			this.versionManager.delete(version);
			result = true;
		} catch (final PersistenceServiceException e) {
			result = false;
			LOGGER.warn(e.getMessage());
		}
		return result;
	}

}
