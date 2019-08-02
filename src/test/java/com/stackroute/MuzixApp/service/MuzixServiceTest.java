package com.stackroute.MuzixApp.service;

import com.stackroute.MuzixApp.domain.Muzix;
import com.stackroute.MuzixApp.error.TrackAlreadyExistsException;
import com.stackroute.MuzixApp.repository.MuzixRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class MuzixServiceTest
{

    Muzix muzix;

    //Create a mock for UserRepository
    @Mock
    MuzixRepository muzixRepository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    MuzixServiceImpl muzixService;
    List<Muzix> list= null;


    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        muzix = new Muzix();
        muzix.setTrackId(45);
        muzix.setTrackName("Closer");
        muzix.setComment("Chainsmokers");
        list = new ArrayList<>();
        list.add(muzix);


    }

    @Test
    public void saveUserTestSuccess() throws TrackAlreadyExistsException {

        when(muzixRepository.save((Muzix)any())).thenReturn(muzix);
        Muzix savedUser = muzixService.saveTrack(muzix);
        Assert.assertEquals(muzix,savedUser);

        //verify here verifies that userRepository save method is only called once
        verify(muzixRepository,times(1)).save(muzix);

    }

//    @Test(expected = TrackAlreadyExistsException.class)
//    public void saveUserTestFailure() throws TrackAlreadyExistsException {
//        when(muzixRepository.save((Muzix)any()).thenReturn(null));
//        Muzix savedUser = muzixService.saveTrack(muzix);
//        System.out.println("savedUser" + savedUser);
//        //Assert.assertEquals(user,savedUser);
//
//       /*doThrow(new UserAlreadyExistException()).when(userRepository).findById(eq(101));
//       userService.saveUser(user);*/
//
//    }

    @Test
    public void getAllUser(){

        muzixRepository.save(muzix);
        //stubbing the mock to return specific data
        when(muzixRepository.findAll()).thenReturn(list);
        List<Muzix> userlist = muzixService.getAllTrack();
        Assert.assertEquals(list,userlist);
    }

}
