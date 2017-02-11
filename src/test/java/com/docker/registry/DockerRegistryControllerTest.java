package com.docker.registry;

import com.docker.registry.cache.PropertiesCache;
import com.docker.registry.controller.DockerRepositoryController;
import com.docker.registry.service.DockerRegistry;
import com.docker.registry.service.DockerRegistryImpl;
import com.docker.registry.ws.v2.DockerRegistryWSV2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author abhishekrai
 * @since 11/02/2017
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class DockerRegistryControllerTest {

    @Configuration
    public static class ControllerConfiguration {

        @Bean
        public DockerRepositoryController dockerRepositoryController() {
            return new DockerRepositoryController();
        }

        @Bean
        public DockerRegistry dockerRegistry() {
            return new DockerRegistryImpl();
        }

        @Bean
        public DockerRegistryWSV2 dockerRegistryWSV2() {
            return new DockerRegistryWSV2();
        }

        @Bean
        public PropertiesCache propertiesCache() {
            return new PropertiesCache();
        }
    }

    @Autowired
    private DockerRepositoryController dockerRepositoryController;

    @Test
    public void test() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.dockerRepositoryController).build();
        mockMvc.perform(get("/v1/tags/list?repo=library/nginx")).andDo(print())
                .andExpect(status().isNotFound());
    }
}
