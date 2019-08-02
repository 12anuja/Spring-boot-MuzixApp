package com.stackroute.MuzixApp.repository;

import com.stackroute.MuzixApp.domain.Muzix;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MuzixRepositoryTest
{

    @Autowired
    MuzixRepository muzixRepository;
    Muzix muzix;

    @Before
    public void setUp()
    {
        muzix = new Muzix();
       muzix.setTrackId(45);
       muzix.setTrackName("How Long");
       muzix.setComment("Charlie Puth");

    }

    @After
    public void tearDown(){

        muzixRepository.deleteAll();
    }


    @Test
    public void testSavetrack(){
        muzixRepository.save(muzix);
        Muzix fetchUser = muzixRepository.findById(muzix.getTrackId()).get();
        Assert.assertEquals(101,fetchUser.getTrackId());

    }

    @Test
    public void testSaveUserFailure(){

        Muzix testmuzix = new Muzix(34,"Capital Letters","Hailee");
        muzixRepository.save(muzix);
        Muzix fetchMuzix = muzixRepository.findById(muzix.getTrackId()).get();
        Assert.assertNotSame(testmuzix,muzix);

    }

    @Test
    public void testGetAllUser(){


        Muzix m1 = new Muzix(67,"Treat You Better","Shawn Mendes");
        Muzix m2 = new Muzix(45,"Love Story","Taylor Swift");
        muzixRepository.save(m1);
        muzixRepository.save(m2);

        List<Muzix> list = muzixRepository.findAll();
        Assert.assertEquals(67,list.get(0).getTrackName());

    }

}
