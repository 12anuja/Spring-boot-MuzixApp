package com.stackroute.MuzixApp.service;

import com.stackroute.MuzixApp.domain.Muzix;

import java.util.List;


//Interface for MuzixServiceImpl class
public interface MuzixSrevice
{
    public void saveTrack(Muzix muzix);

    public List<Muzix> getAllTrack();

    public void deleteTrack(int trackId);

    public Muzix updateTrack(Muzix muzix,int trackId);


}
