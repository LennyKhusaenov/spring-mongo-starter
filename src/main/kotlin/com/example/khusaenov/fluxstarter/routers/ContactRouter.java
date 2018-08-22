package com.example.khusaenov.fluxstarter.routers;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;
import static org.springframework.web.reactive.function.server.RequestPredicates.method;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RequestPredicates.queryParam;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import com.example.khusaenov.fluxstarter.service.ContactService;
import java.util.Objects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @author Khusaenov on 17.08.2018
 */
@Configuration
public class ContactRouter {


    private static final String CONTACTS = "/contacts";

    @Bean
    public RouterFunction<ServerResponse> contactRoutes(ContactService contactService) {
        MediaType applicationJson = MediaType.APPLICATION_JSON;
        return RouterFunctions
                .nest(path(CONTACTS).and(accept(applicationJson)).and(contentType(applicationJson)),
                        route(method(HttpMethod.GET).and(queryParam("id", Objects::nonNull)),
                                contactService::getContactById)
                                .andRoute(method(HttpMethod.GET), contactService::getAllContacts)
                                .andRoute(method(HttpMethod.POST),
                                        contactService::createNewContact)
                                .andRoute(method(HttpMethod.DELETE)
                                                .and(queryParam("id", Objects::nonNull)),
                                        contactService::deleteContact)
                                .andRoute(method(HttpMethod.PUT),
                                        contactService::updateContactData));
    }

}
