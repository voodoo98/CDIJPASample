package com.cdisample.dataservice.persistance;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "table1")
@NamedQueries(value = { //
        @NamedQuery(name = VersionQuery.GET_BY_ID, //
                    query = "SELECT v FROM Version v WHERE v.id=:" + VersionParameter.ID), //
        @NamedQuery(name = VersionQuery.GET_VERSION_BY_VERSION, //
                    query = "SELECT v FROM Version v WHERE v.version=:" + VersionParameter.VERSION), //
        @NamedQuery(name = VersionQuery.GET_VERSION, //
                    query = "SELECT v FROM Version v"), //
        @NamedQuery(name = VersionQuery.UPDATE_BY_VERSION, //
                    query = "UPDATE Version v SET v.version = :" + VersionParameter.VERSION), //
})
public class Version implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "version")
	private String version;

	public Version() {
	}

	public Version(final String version) {
		this.setVersion(version);
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(final String version) {
		this.version = version;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Version [version=" + this.version + "]";
	}

}