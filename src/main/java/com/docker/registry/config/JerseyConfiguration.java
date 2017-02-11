package com.docker.registry.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * @author abhishekrai
 * @since 10/02/2017
 */
@ApplicationPath("/")
public class JerseyConfiguration extends ResourceConfig {
    public JerseyConfiguration() {
        register( JacksonFeature.class );
        packages("com.docker.registry");
    }
}
