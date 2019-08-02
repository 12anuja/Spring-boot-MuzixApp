package com.stackroute.MuzixApp.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.lang.annotation.Documented;


//Marked as a table in database with name same as class name
@Entity
//Marked to create getter/setter as per requirements
@Data
//Marked to create a no argumented constructor for the class
//@NoArgsConstructor
//Marked to create a parameterized constructor for the class
//@AllArgsConstructor
@ApiModel(description = "All details about the Muzix tracks")


//For using MONGODB
@Document(value = "Muzix")
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

    public Muzix(int i,String s1,String s2)
    {
        this.trackId=i;
        this.trackName=s1;
        this.comment=s2;
    }

    public Muzix() {
    }

    public int getTrackId() {
        return trackId;
    }

    public void setTrackId(int trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
