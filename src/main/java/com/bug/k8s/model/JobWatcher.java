package com.bug.k8s.model;

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;
import lombok.Getter;
import lombok.Setter;

@Version("v1beta1")
@Group("bug.com.targetjob")
public class JobWatcher extends CustomResource<JobWatcherSpec, JobWatcherStatus>
    implements Namespaced {
  @Getter @Setter private JobWatcherSpec spec;
  @Getter @Setter private JobWatcherStatus status;

  @Override
  protected JobWatcherStatus initStatus() {
    return new JobWatcherStatus();
  }

  @Override
  public ObjectMeta getMetadata() {
    return super.getMetadata();
  }

  @Override
  public String toString() {
    return "JobWatcher{"
        + "apiVersion='"
        + getApiVersion()
        + "'"
        + ", metadata="
        + getMetadata()
        + ", spec="
        + spec
        + ", status="
        + status
        + "}";
  }
}
