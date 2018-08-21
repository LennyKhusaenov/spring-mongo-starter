package com.example.khusaenov.fluxstarter.routers;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;
import static org.springframework.web.reactive.function.server.RequestPredicates.queryParam;

import com.example.khusaenov.fluxstarter.service.ContactService;
import java.util.Objects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
        MediaType applicationStreamJson = MediaType.APPLICATION_STREAM_JSON;
        return RouterFunctions.route(GET(CONTACTS).and(accept(applicationStreamJson))
                .and(queryParam("id", Objects::nonNull)), contactService::getContactById)
                .andRoute(GET(CONTACTS).and(accept(applicationStreamJson)),
                        contactService::getAllContacts)
                .andRoute(POST(CONTACTS).and(accept(MediaType.APPLICATION_JSON)).
                                and(contentType(MediaType.APPLICATION_JSON)),
                        contactService::createNewContact);
    }

}
