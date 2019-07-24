package com.stackroute.MuzixApp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


//Marked as a table in database with name same as class name
@Entity
//Marked to create getter/setter as per requirements
@Data
//Marked to create a no argumented constructor for the class
@NoArgsConstructor
//Marked to create a parameterized constructor for the class
@AllArgsConstructor
public class Muzix
{

    //Marked as the primary key in database table
    @Id
    private int trackId;
    private String trackName;
    private String comment;

}
