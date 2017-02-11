package com.docker.registry.ws.v2.beans;

import com.docker.registry.beans.DefaultResponse;
import com.docker.registry.beans.WSResponse;

import java.util.Arrays;

/**
 * @author abhishekrai
 * @since 10/02/2017
 */
public class RepositoryTagsList extends WSResponse implements DefaultResponse {
    private String name;
    private String[] tags;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "RepositoryTagsList{" +
                "name='" + name + '\'' +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }
}
