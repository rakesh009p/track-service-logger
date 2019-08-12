package com.stackroute.trackservice.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.lang.annotation.Documented;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Document(collection = "track")
public class Track {

    @Id
    private int id;
    private String name;
    private String comment;



}
