package com.example.khuasenov.fluxstarter.model;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Khusaenov on 17.07.2018
 */
@Document
@Getter
@Setter
@EqualsAndHashCode
//@NoArgsConstructor
//@AllArgsConstructor
public class Persons {

    @Id
    private String id;

    private String name;

    private String surname;

    private Integer age;

    private List<String> options;


}
