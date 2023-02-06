package com.bug.k8s.model;

import java.util.Arrays;
import java.util.Optional;

public enum JobStatus {
  SUCCEED("succeed"),
  FAILED("failed"),
  CREATED("created"),
  ADDED("added"),
  RUNNING("running"),
  NOT_FOUND("not_found"),
  ERROR("error");

  private final String status;

  JobStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return this.status;
  }

  public boolean isJobOver() {
    return this == JobStatus.FAILED || this == JobStatus.SUCCEED;
  }

  public static Optional<JobStatus> fromString(String status) {
    return Arrays.stream(JobStatus.values())
        .filter(j -> j.status.equalsIgnoreCase(status))
        .findFirst();
  }
}
