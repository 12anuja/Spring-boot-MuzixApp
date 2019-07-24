package com.stackroute.MuzixApp.repository;

import com.stackroute.MuzixApp.domain.Muzix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//An interface which is marked as repository which means it handles updation, deletion etc. database operations
@Repository
public interface MuzixRepository extends JpaRepository<Muzix,Integer>
{



}
