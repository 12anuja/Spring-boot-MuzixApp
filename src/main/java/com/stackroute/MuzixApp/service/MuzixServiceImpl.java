package com.stackroute.MuzixApp.service;


import com.stackroute.MuzixApp.domain.Muzix;
import com.stackroute.MuzixApp.repository.MuzixRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

// Marked as a specialization of @Component annotation
// It is used to mark the class as a service provide
@Service
public class MuzixServiceImpl implements MuzixSrevice
{

    MuzixRepository muzixRepository;

    //@Autowired
    public MuzixServiceImpl(MuzixRepository muzixRepository)
    {
        this.muzixRepository=muzixRepository;

    }

    @Override
    public void saveTrack(Muzix muzix) {

        Muzix savedUser = muzixRepository.save(muzix);
    }

    @Override
    public List<Muzix> getAllTrack() {

        return muzixRepository.findAll();
    }

    @Override
    public void deleteTrack(int trackId)
    {
            muzixRepository.deleteById(trackId);
    }

    @Override
    public Muzix updateTrack(Muzix muzix, int trackId)
    {
        boolean updateTrack = muzixRepository.existsById(trackId);
        if(updateTrack)
        {
            return muzixRepository.save(muzix);
        }
        return null;
    }

    @Override
    public List<Muzix> findByName(String trackName)
    {
       List<Muzix> trackbyname= muzixRepository.findByName(trackName);
       return trackbyname;

    }

}