package com.docker.registry.ws.v2.beans;

import java.util.Arrays;

/**
 * @author abhishekrai
 * @since 10/02/2017
 */
public class ManifestsHistory {
    private V1Compatibility v1Compatibility;

    public V1Compatibility getV1Compatibility() {
        return v1Compatibility;
    }

    public void setV1Compatibility(V1Compatibility v1Compatibility) {
        this.v1Compatibility = v1Compatibility;
    }

    @Override
    public String toString() {
        return "ManifestsHistory{" +
                "v1Compatibility=" + v1Compatibility +
                '}';
    }
}
