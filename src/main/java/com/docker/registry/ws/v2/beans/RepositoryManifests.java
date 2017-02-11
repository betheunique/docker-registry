package com.docker.registry.ws.v2.beans;

import com.docker.registry.beans.WSResponse;
import com.docker.registry.beans.DefaultResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

/**
 * @author abhishekrai
 * @since 10/02/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RepositoryManifests extends WSResponse implements DefaultResponse {
    private int schemaVersion;
    private String name;
    private String tag;
    private String architecture;
//    private ManifestsHistory[] history;
    private FsLayers[] fsLayers;
    private ManifestsSignatures[] signatures;

    private static class FsLayers {
        private String blobSum;

        public String getBlobSum() {
            return blobSum;
        }

        public void setBlobSum(String blobSum) {
            this.blobSum = blobSum;
        }

        @Override
        public String toString() {
            return "FsLayers{" +
                    "blobSum='" + blobSum + '\'' +
                    '}';
        }
    }

    public FsLayers[] getFsLayers() {
        return fsLayers;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public int getSchemaVersion() {
        return schemaVersion;
    }

    public void setFsLayers(FsLayers[] fsLayers) {
        this.fsLayers = fsLayers;
    }

//    public ManifestsHistory[] getHistory() {
//        return history;
//    }
//
//    public void setHistory(ManifestsHistory[] history) {
//        this.history = history;
//    }

    public ManifestsSignatures[] getSignatures() {
        return signatures;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setSchemaVersion(int schemaVersion) {
        this.schemaVersion = schemaVersion;
    }

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    public void setSignatures(ManifestsSignatures[] signatures) {
        this.signatures = signatures;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "RepositoryManifests{" +
                "schemaVersion=" + schemaVersion +
                ", name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                ", architecture='" + architecture + '\'' +
//                ", history=" + Arrays.toString(history) +
                ", fsLayers=" + Arrays.toString(fsLayers) +
                ", signatures=" + Arrays.toString(signatures) +
                '}';
    }
}
