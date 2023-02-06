package com.bug.k8s;

import com.bug.k8s.internal.JobWatcherBuilder;
import com.bug.k8s.model.JobWatcher;
import com.bug.k8s.model.JobWatcherList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.NonNamespaceOperation;
import io.fabric8.kubernetes.client.dsl.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class KubernetesRepository {
  NonNamespaceOperation<JobWatcher, JobWatcherList, Resource<JobWatcher>> jobWatcherClient;
  private final JobWatcherBuilder jobWatcherBuilder;

  @Inject
  KubernetesClient kubernetesClient;


  public KubernetesRepository(JobWatcherBuilder jobWatcherBuilder) {
    this.jobWatcherClient = kubernetesClient
            .resources(JobWatcher.class, JobWatcherList.class)
            .inNamespace("namespace");
    this.jobWatcherBuilder = jobWatcherBuilder;
  }

  public void createCustomResource() {
    JobWatcher jobWatcher = jobWatcherBuilder.buildJobWatcher();
    jobWatcherClient.createOrReplace(jobWatcher);
  }

  public void deleteCustomResource() {
    jobWatcherClient.withName("delete").delete();
  }
}
