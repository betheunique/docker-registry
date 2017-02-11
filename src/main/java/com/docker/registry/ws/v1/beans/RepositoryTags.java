package com.docker.registry.ws.v1.beans;

import com.docker.registry.beans.DefaultResponse;
import com.docker.registry.beans.WSResponse;

/**
 * @author abhishekrai
 * @since 10/02/2017
 */
public class RepositoryTags extends WSResponse implements DefaultResponse {
    private String layer;
    private String name;

    public String getLayer() {
        return layer;
    }

    public void setLayer(String layer) {
        this.layer = layer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "RepositoryTags{" +
                "layer='" + layer + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
