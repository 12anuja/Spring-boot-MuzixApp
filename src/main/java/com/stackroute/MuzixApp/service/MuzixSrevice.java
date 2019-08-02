package com.stackroute.MuzixApp.service;

import com.stackroute.MuzixApp.domain.Muzix;
import com.stackroute.MuzixApp.error.TrackAlreadyExistsException;
import com.stackroute.MuzixApp.error.TrackNotFoundException;

import java.util.List;


//Interface for MuzixServiceImpl class
public interface MuzixSrevice
{
    public Muzix getTopTracks();

    public Muzix saveTrack(Muzix muzix)throws TrackAlreadyExistsException;

    public List<Muzix> getAllTrack();

    public boolean deleteTrack(int trackId)throws TrackNotFoundException;

    public Muzix updateTrack(Muzix muzix,int trackId);

    public List<Muzix> findByName(String trackName)throws TrackNotFoundException;


}
