package com.docker.registry.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * @author abhishekrai
 * @since 10/02/2017
 */
public class ClientFactory {

    private static Logger logger = LoggerFactory.getLogger(ClientFactory.class);
    private static Client client = ClientBuilder.newClient();

    public static Client getClient() {
        return client;
    }

    public static Client getClient(long timeout) {
        try {
            //client.wait(timeout);
            return client;
        }catch (Exception e) {
            logger.error("Exception occured while connection time out:" + e);
            return null;
        }
    }
}
