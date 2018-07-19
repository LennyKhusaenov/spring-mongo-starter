package com.example.khuasenov.fluxstarter.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Khusaenov on 18.07.2018
 */
@Document( collection = "contacts")

@Getter
@Setter
public class Contact {

    @Id
    private String id;
    private String name;
    private String address;
    private String city;
    private String phone;
    private String email;

}
