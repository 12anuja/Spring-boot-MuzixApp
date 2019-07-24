package com.stackroute.MuzixApp.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "All details about the Muzix tracks")
public class Muzix
{

    //Marked as the primary key in database table
    @Id
    @ApiModelProperty(notes = "The database generated ID")
    private int trackId;
    @ApiModelProperty(notes = "The Muzix track name")
    private String trackName;
    @ApiModelProperty(notes = "The Muzix track comment")
    private String comment;


}
