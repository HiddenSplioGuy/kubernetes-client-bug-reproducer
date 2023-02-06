package com.bug.k8s.model;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.fabric8.kubernetes.api.model.KubernetesResource;
import lombok.Getter;
import lombok.Setter;

@JsonDeserialize(using = JsonDeserializer.None.class)
@Getter
@Setter
public class JobWatcherSpec implements KubernetesResource {
  private String jobWatcherSpec;
  private String param;

  @Override
  public String toString() {
    return "JobWatcherSpec{"
        + "universe="
        + param
        + "}";
  }
}
