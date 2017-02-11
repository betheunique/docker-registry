package com.docker.registry.controller;

import com.docker.registry.beans.DefaultResponse;
import com.docker.registry.cache.PropertiesCache;
import com.docker.registry.service.DockerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author abhishekrai
 * @since 10/02/2017
 */
@Component
@Controller
@Path("/v1")
public class DockerRepositoryController {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private DockerRegistry dockerRegistryImpl;

    @Autowired
    private PropertiesCache propertiesCache;

    @Path("/manifests")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public DefaultResponse getRepositoryManifest(@QueryParam("repo") String repo, @QueryParam("tagName") String tagName) {
        long startTime = System.currentTimeMillis();
        DefaultResponse repositoryManifests = (DefaultResponse) dockerRegistryImpl.getRepositoryManifestsV2(repo, tagName);
        logger.info("Total Time taken to execute manifests api :" + (System.currentTimeMillis() - startTime));
        return repositoryManifests;
    }

    @Path("/tags/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public DefaultResponse getRepositoryTagsList(@QueryParam("repo") String repo) {
        logger.info("Repo received for query :" + repo);
        long startTime = System.currentTimeMillis();
        DefaultResponse repositoryTagsList = (DefaultResponse) dockerRegistryImpl.getRepositoryTagsV2(repo);
        logger.info("Total Time taken to execute manifests api :" + (System.currentTimeMillis() - startTime));
        return repositoryTagsList;
    }

    @Path("/refresh/property")
    @GET
    public int refreshDockerProperty() {
        propertiesCache.reload();
        return 1;
    }
}
