package com.docker.registry.service;

import com.docker.registry.beans.DefaultResponse;

/**
 * @author abhishekrai
 * @since 10/02/2017
 */
public interface DockerRegistry {

     DefaultResponse getRepositoryManifestsV2(String scope, String tag);
     DefaultResponse getRepositoryTagsV2(String scope);
}
