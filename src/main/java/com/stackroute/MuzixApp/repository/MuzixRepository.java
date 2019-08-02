package com.stackroute.MuzixApp.repository;

import com.stackroute.MuzixApp.domain.Muzix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//An interface which is marked as repository which means it handles updation, deletion etc. database operations
@Repository
public interface MuzixRepository extends MongoRepository<Muzix,Integer>
{

    //Query annotation will define SQL to execute for a repository method.
    //the value attribute contains SQL or JPQL query to execute
    @Query(value = "SELECT u FROM Muzix u WHERE u.trackName  = :name")
    List<Muzix> findByName(String name);

}
