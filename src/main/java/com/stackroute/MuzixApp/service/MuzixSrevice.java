package com.stackroute.MuzixApp.service;

import com.stackroute.MuzixApp.domain.Muzix;
import com.stackroute.MuzixApp.error.TrackAlreadyExistsException;
import com.stackroute.MuzixApp.error.TrackNotFoundException;
import org.springframework.data.repository.query.Param;

import java.util.List;


//Interface for MuzixServiceImpl class
public interface MuzixSrevice
{
    public void saveTrack(Muzix muzix)throws TrackAlreadyExistsException;

    public List<Muzix> getAllTrack();

    public void deleteTrack(int trackId)throws TrackNotFoundException;

    public Muzix updateTrack(Muzix muzix,int trackId);

    List<Muzix> findByName(String trackName)throws TrackNotFoundException;


}
