package com.docker.registry.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * @author abhishekrai
 * @since 10/02/2017
 */
@Component
public class PropertiesCache {

    private static Logger logger = LoggerFactory.getLogger(PropertiesCache.class);
    private static String DockerProperties = "docker.properties";

    Properties properties = new Properties();

    @PostConstruct
    public void initialize() {
        logger.info("initializing ptoperties file");
        try{
            properties.load(this.getClass().getClassLoader().getResourceAsStream(DockerProperties));
        }catch (Exception e) {
            logger.error("Io exception occurred :" + e);
        }
    }

    public String getDockerProperties(String key) {
        return (String)properties.get(key);
    }

    public void reload() {
        properties.clear();
        initialize();
    }
}
