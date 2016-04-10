package com.cdisample.adaptor;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class VersionStub {

    @JsonCreator
    public static VersionStub create(final String version) {
        return new AutoValue_VersionStub(version);
    }

    @JsonProperty("version")
    public abstract String getVersion();

}
