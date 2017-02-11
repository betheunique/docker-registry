package com.docker.registry.service;

import com.docker.registry.beans.DefaultResponse;
import com.docker.registry.ws.v2.DockerRegistryWSV2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author abhishekrai
 * @since 10/02/2017
 */
@Service
public class DockerRegistryImpl implements DockerRegistry {

    private static Logger logger = LoggerFactory.getLogger(DockerRegistryImpl.class);

    @Autowired
    private DockerRegistryWSV2 dockerRegistryWSV2;

    public DefaultResponse getRepositoryManifestsV2(String scope, String tag) {
        String prepareScope = "repository:" + scope + ":pull";
        String extendedUrl = scope + "/manifests/" + tag;
        try {
            return dockerRegistryWSV2.getDockerRegistryManifests(prepareScope, extendedUrl);
        } catch (Exception io) {
            logger.error("Exception occurred :" + io);
            return null;
        }
    }

    public DefaultResponse getRepositoryTagsV2(String scope) {
        String prepareScope = "repository:" + scope + ":pull";
        logger.info("Scope formed as :" + prepareScope);
        String extendedUrl = scope + "/tags/list";
        logger.info("Url formed as :" + extendedUrl);
        try {
            return dockerRegistryWSV2.getDockerRegistryToken(prepareScope, extendedUrl);
        } catch (Exception io) {
            logger.error("Exception occurred :" + io);
            return null;
        }
    }

}
