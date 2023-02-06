package com.bug.k8s.model;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.javaoperatorsdk.operator.api.ObservedGenerationAwareStatus;
import lombok.Getter;
import lombok.Setter;

@JsonDeserialize(using = JsonDeserializer.None.class)
@Getter
@Setter
public class JobWatcherStatus extends ObservedGenerationAwareStatus {
  private String jobStatus;

  @Override
  public String toString() {
    return "JobWatcherStatus{" + " jobStatus=" + jobStatus + "}";
  }
}
