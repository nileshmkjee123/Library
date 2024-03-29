package org.project.library.config;

import org.project.library.entity.Book;
import org.project.library.entity.Message;
import org.project.library.entity.Review;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    private String theAllowedOrigins ="https://localhost:3000";
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config,
                                                     CorsRegistry cors)
    {
        HttpMethod[] theUnsupportedActions = {HttpMethod.DELETE,
                HttpMethod.POST,HttpMethod.PUT,HttpMethod.PATCH};
        config.exposeIdsFor(Book.class);
        disableHttpMethods(Book.class,config,theUnsupportedActions);
        config.exposeIdsFor(Review.class);
        disableHttpMethods(Review.class,config,theUnsupportedActions);
        config.exposeIdsFor(Message.class);
        disableHttpMethods(Message.class,config,theUnsupportedActions);
        //Configure CORS Mapping
        cors.addMapping(config.getBasePath()+"/**")
                .allowedOrigins(theAllowedOrigins).allowedHeaders("*");
    }

    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
    config.getExposureConfiguration().
            forDomainType(theClass).withItemExposure((metdata, httpMethods) ->
                    httpMethods.disable(theUnsupportedActions)).
            withCollectionExposure((metdata, httpMethods) ->
                    httpMethods.disable(theUnsupportedActions));
    }
}
