package com.bug.k8s.internal;

import com.bug.k8s.model.JobStatus;
import com.bug.k8s.model.JobWatcherSpec;
import com.bug.k8s.model.JobWatcherStatus;
import com.bug.k8s.model.JobWatcher;
import io.fabric8.kubernetes.api.model.ObjectMeta;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class JobWatcherBuilder {

  public JobWatcher buildJobWatcher() {
    ObjectMeta objectMeta = buildObjectMeta();
    JobWatcherSpec jobWatcherSpec = buildJobWatcherSpec();
    JobWatcherStatus jobWatcherStatus = buildJobWatcherStatus();
    return jobWatcher(objectMeta, jobWatcherSpec, jobWatcherStatus);
  }

  private ObjectMeta buildObjectMeta() {
    ObjectMeta objectMeta = new ObjectMeta();
    objectMeta.setNamespace("namespace");
    objectMeta.setName("name");
    return objectMeta;
  }

  private JobWatcherSpec buildJobWatcherSpec() {
    JobWatcherSpec spec = new JobWatcherSpec();
    spec.setParam("param");
    return spec;
  }

  private JobWatcherStatus buildJobWatcherStatus() {
    JobWatcherStatus jobWatcherStatus = new JobWatcherStatus();
    jobWatcherStatus.setJobStatus(JobStatus.CREATED.getStatus());
    return jobWatcherStatus;
  }

  private JobWatcher jobWatcher(
      ObjectMeta objectMeta, JobWatcherSpec jobWatcherSpec, JobWatcherStatus jobWatcherStatus) {
    JobWatcher jobWatcher = new JobWatcher();
    jobWatcher.setMetadata(objectMeta);
    jobWatcher.setSpec(jobWatcherSpec);
    jobWatcher.setStatus(jobWatcherStatus);
    return jobWatcher;
  }
}
