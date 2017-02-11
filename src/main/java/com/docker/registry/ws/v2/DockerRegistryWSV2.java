package com.docker.registry.ws.v2;

import com.docker.registry.beans.WSResponse;
import com.docker.registry.beans.DefaultResponse;
import com.docker.registry.cache.PropertiesCache;
import com.docker.registry.constants.DockerConstants;
import com.docker.registry.factory.ClientFactory;
import com.docker.registry.ws.v2.beans.RepositoryManifests;
import com.docker.registry.ws.v2.beans.RepositoryTagsList;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * @author abhishekrai
 * @since 05/02/2017
 */
@Component
public class DockerRegistryWSV2 {

    private static Logger logger = LoggerFactory.getLogger(DockerRegistryWSV2.class);

    @Autowired
    private PropertiesCache propertiesCache;
    private ObjectMapper mapper = new ObjectMapper();

    public DefaultResponse getDockerRegistryToken(String scope, String extendedUrl) {
        WSResponse wsResponse = new WSResponse();
        logger.info("Scope coming as :" + scope);
        logger.info("Extended url received as : " + extendedUrl);
        Client client = ClientFactory.getClient();
        try {
            String url = "https://auth.docker.io/token?service=registry.docker.io&scope=" + scope;
            logger.info("url formed as : "+ url);
            WebTarget target = client.target(propertiesCache.getDockerProperties(DockerConstants.DOCKER_TOKEN_URL));
            Response response = target.queryParam("service", propertiesCache.getDockerProperties(DockerConstants.DOCKER_SERVICE_URL))
                                .queryParam("scope", scope).request().get(Response.class);
            if(response.getStatus() != 200) {
                logger.info("Something went wrong while hitting auth url :" + response.getStatus());
                wsResponse.setMessage("Something went wrong while hitting auth url");
                wsResponse.setStatus(response.getStatus());
                return wsResponse;
            } else {
                String result = response.readEntity(String.class);
                logger.info("Response came in as :" + result);
                JsonNode m = mapper.readTree(result);
                String token = m.path("token").asText();
                return getDockerRegistryTagList(token, extendedUrl);
            }
        } catch (Exception e) {
            logger.error("Exception occurred while hitting docker token url :" + e);
            wsResponse.setStatus(DockerConstants.DOCKER_EXCEPTION_ERROR_CODE);
            wsResponse.setMessage(e.getMessage());
            return wsResponse;
        }
    }

    private DefaultResponse getDockerRegistryTagList(String token, String extendedUrl) {
        WSResponse wsResponse = new WSResponse();
        String url = propertiesCache.getDockerProperties(DockerConstants.DOCKER_REGISTRY_V2_URL) + extendedUrl;
        logger.info("url formed as :" + url);
        logger.info("token coming as :" + token);
        logger.info("Extended url received as : " + extendedUrl);
        String bearer = "Bearer " + token;
        try {
            WebTarget target = ClientFactory.getClient().target(url);
            Response response = target.request().header("Authorization", bearer).get(Response.class);
            if(response.getStatus() != 200) {
                logger.info("Something went wrong on docker side :" + response.getStatus());
                wsResponse.setMessage("Something went wrong while hitting auth url");
                wsResponse.setStatus(response.getStatus());
                return wsResponse;
            } else {
                //logger.info("Response came in as :" + response.readEntity(String.class));
                String jsonResult = response.readEntity(String.class);
                RepositoryTagsList repositoryTagsList = mapper.readValue(jsonResult, RepositoryTagsList.class);
                repositoryTagsList.setStatus(response.getStatus());
                repositoryTagsList.setMessage("Success");
                return repositoryTagsList;
            }
        } catch (Exception e) {
            logger.error("Error occurred while hitting :" + e);
            wsResponse.setMessage(e.getMessage());
            wsResponse.setStatus(DockerConstants.DOCKER_EXCEPTION_ERROR_CODE);
            return wsResponse;
        }
    }

    public DefaultResponse getDockerRegistryManifests(String token, String extendedUrl) {
        WSResponse wsResponse = new WSResponse();
        String url = propertiesCache.getDockerProperties(DockerConstants.DOCKER_REGISTRY_V2_URL) + extendedUrl;
        logger.info("url formed as :" + url);
        logger.info("token coming as :" + token);
        logger.info("Extended url received as : " + extendedUrl);
        String bearer = "Bearer " + token;
        try {
            WebTarget target = ClientFactory.getClient().target(url);
            Response response = target.request().header("Authorization", bearer).get(Response.class);
            if(response.getStatus() != 200) {
                logger.info("Something went wrong on docker side :" + response.getStatus());
                wsResponse.setMessage("Something went wrong while hitting auth url");
                wsResponse.setStatus(response.getStatus());
                return wsResponse;
            } else {
                //logger.info("Response came in as :" + response.readEntity(String.class));
                String jsonResult = response.readEntity(String.class);
//                jsonResult.replaceAll("\\\"/{", "/{")
//                jsonResult.replaceAll("\\\\", "");
                RepositoryManifests repositoryManifests = mapper.readValue(jsonResult, RepositoryManifests.class);
                repositoryManifests.setStatus(response.getStatus());
                repositoryManifests.setMessage("Success");
                return repositoryManifests;
            }
        } catch (Exception e) {
            logger.error("Error occurred while hitting :" + e);
            wsResponse.setMessage(e.getMessage());
            wsResponse.setStatus(DockerConstants.DOCKER_EXCEPTION_ERROR_CODE);
            return wsResponse;
        }
    }

}
