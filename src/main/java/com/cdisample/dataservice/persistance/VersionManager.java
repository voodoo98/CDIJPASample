package com.cdisample.dataservice.persistance;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.cdisample.dataservice.persistance.exception.PersistenceServiceException;

@Stateless
public class VersionManager {

	@PersistenceContext(unitName = "VersionService")
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<Version> get() {
		return this.entityManager.createNamedQuery(VersionQuery.GET_VERSION).getResultList();
	}

	public void add(final String version) {
		final Version ver = new Version(version);
		this.entityManager.persist(ver);
		this.entityManager.flush();
	}

	public void modify(final String oldVersion, final String newVersion) throws PersistenceServiceException {
		final Version ver = this.getEntityByVersion(oldVersion);
		ver.setVersion(newVersion);
		this.entityManager.merge(ver);
		this.entityManager.flush();
	}

	public void delete(final String version) throws PersistenceServiceException {
		final Version ver = this.getEntityByVersion(version);
		this.entityManager.remove(ver);
		this.entityManager.flush();
	}

	private Long getVersionId(final String version) throws PersistenceServiceException {
		try {

			final TypedQuery<Version> createNamedQuery = this.entityManager.createNamedQuery(VersionQuery.GET_VERSION_BY_VERSION, Version.class);
			final TypedQuery<Version> setParameter = createNamedQuery.setParameter(VersionParameter.VERSION, version);
			final Version versionResult = setParameter.getSingleResult();
			return versionResult.getId();
		} catch (final Exception e) {
			throw new PersistenceServiceException(version + " not found");
		}
	}

	private Version getEntityByVersion(final String oldVersion) throws PersistenceServiceException {
		final Long oldVersionId = this.getVersionId(oldVersion);
		final Version ver = this.entityManager.find(Version.class, oldVersionId);
		return ver;
	}

}
