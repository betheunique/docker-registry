package com.docker.registry.ws.v2.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author abhishekrai
 * @since 10/02/2017
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class V1Compatibility {

    private String id;
    private String parent;
    private String os;
    private String created;
    private String architecture;
    private String author;
    private boolean throwaway;
    private String docker_version;
    private ContainerConfig container_config;
    private String container;

//    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ContainerConfig {
        private String Hostname;
        private String Domainname;
        private String User;
        private boolean AttachStdin;
        private boolean AttachStdout;
        private boolean AttachStderr;
        private boolean Tty;
        private boolean OpenStdin;
        private boolean StdinOnce;
        private String[] Env;
        private String[] Cmd;
        private String Image;
        private String Volumes;
        private String WorkingDir;
        private String Entrypoint;
        private String[] OnBuild;
        private Label Labels;

        public static class Label {
            Label() {}
        }

        public String getDomainname() {
            return Domainname;
        }

        public void setDomainname(String domainname) {
            Domainname = domainname;
        }

        public String getEntrypoint() {
            return Entrypoint;
        }

        public void setAttachStderr(boolean attachStderr) {
            AttachStderr = attachStderr;
        }

        public String getHostname() {
            return Hostname;
        }

        public void setAttachStdin(boolean attachStdin) {
            AttachStdin = attachStdin;
        }

        public String getImage() {
            return Image;
        }

        public Label getLabels() {
            return Labels;
        }

        public String[] getOnBuild() {
                return OnBuild;
            }

        public String getUser() {
            return User;
        }

        public String getVolumes() {
            return Volumes;
        }

        public String[] getCmd() {
            return Cmd;
        }

        public String getWorkingDir() {
            return WorkingDir;
        }

        public boolean isAttachStderr() {
            return AttachStderr;
        }

        public boolean isAttachStdin() {
            return AttachStdin;
        }

        public boolean isAttachStdout() {
            return AttachStdout;
        }

        public boolean isOpenStdin() {
            return OpenStdin;
        }

        public boolean isStdinOnce() {
            return StdinOnce;
        }

        public boolean isTty() {
            return Tty;
        }

        public String[] getEnv() {
            return Env;
        }

        public void setAttachStdout(boolean attachStdout) {
            AttachStdout = attachStdout;
        }

        public void setCmd(String[] cmd) {
            Cmd = cmd;
        }

        public void setEnv(String[] env) {
            Env = env;
        }

        public void setHostname(String hostname) {
            Hostname = hostname;
        }

        public void setEntrypoint(String entrypoint) {
            Entrypoint = entrypoint;
        }

        public void setImage(String image) {
            Image = image;
        }

        public void setLabels(Label labels) {
            Labels = labels;
        }

        public void setOnBuild(String[] onBuild) {
                OnBuild = onBuild;
            }

        public void setOpenStdin(boolean openStdin) {
            OpenStdin = openStdin;
        }

        public void setStdinOnce(boolean stdinOnce) {
            StdinOnce = stdinOnce;
        }

        public void setTty(boolean tty) {
            Tty = tty;
        }

        public void setUser(String user) {
            User = user;
        }

        public void setVolumes(String volumes) {
            Volumes = volumes;
        }

        public void setWorkingDir(String workingDir) {
            WorkingDir = workingDir;
        }
    }

    public ContainerConfig getContainer_config() {
        return container_config;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setContainer_config(ContainerConfig container_config) {
        this.container_config = container_config;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setDocker_version(String docker_version) {
        this.docker_version = docker_version;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public void setThrowaway(boolean throwaway) {
        this.throwaway = throwaway;
    }

    public String getArchitecture() {
        return architecture;
    }

    public String getAuthor() {
        return author;
    }

    public String getCreated() {
        return created;
    }

    public String getDocker_version() {
        return docker_version;
    }

    public String getId() {
        return id;
    }

    public String getOs() {
        return os;
    }

    public String getParent() {
        return parent;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(String container) {
        this.container = container;
    }

    @Override
    public String toString() {
        return "V1Compatibility{" +
                "id='" + id + '\'' +
                ", parent='" + parent + '\'' +
                ", os='" + os + '\'' +
                ", created='" + created + '\'' +
                ", architecture='" + architecture + '\'' +
                ", author='" + author + '\'' +
                ", throwaway=" + throwaway +
                ", docker_version='" + docker_version + '\'' +
                ", container_config=" + container_config +
                ", container='" + container + '\'' +
                '}';
    }
}
