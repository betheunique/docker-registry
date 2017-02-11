# Docker-Registry
Docker-Registry Implementation to get repository tags, manifests details etc. Using Spring without xml.

## Configuration
- Spring 4, Jersey 2
- Spring Annotation based configuration
- No xml require.

## Functionality
- Its a REST API. Can be converted to public jar if required.
- Two end points (Getting Repository Tags list and Manifests details regards to particular tag)
- /v1/tags/list?repo={repoName} like library/nginx, library/mysql, etc
- /v1/manifests?repo={repoName}&tagName={anytagName} like version 2.0.0, like stable, etc

## Package & Deploy
- mvn clean package
- Whole project will be packaged as war, deploy in your favourite container (Tomcat, jetty, JBoss, etc).

## Testing
- Sample Request: http://localhost:8080/v1/tags/list?repo=distribution/registry
- Response: {
              "name": "distribution/registry",
              "tags": [
                "2.0.0-rc.3",
                "2.0.0-rc.4",
                "2.0.0",
                "2.0.1-validation-stopgap",
                "2.0.1",
                "2.0",
                "2.1.0",
                "2.1.1",
                "2.1",
                "2.2.0",
                "2.2.1",
                "2.2",
                "2.3.0",
                "2.3",
                "2.4.0-acd5b2",
                "2.4.0-rc.0",
                "2.4.0-rc.1",
                "2.4.0-rc",
                "2.4.0",
                "2.4.1-rc.1",
                "2.4.1-rc.2",
                "2.5.1-rc.1",
                "2.6.0-rc.1",
                "2.6.0-rc.2",
                "2.6.0",
                "2.6.1-rc.1",
                "2",
                "dmp42-test",
                "latest",
                "master",
                "v2.0.0-rc.4"
              ]
            }

## Query or Suggestion
- reach out to me at abhisheksavitarai at gmail dot com.