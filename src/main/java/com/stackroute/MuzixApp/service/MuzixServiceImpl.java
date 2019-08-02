package com.stackroute.MuzixApp.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.stackroute.MuzixApp.domain.Muzix;
import com.stackroute.MuzixApp.error.TrackAlreadyExistsException;
import com.stackroute.MuzixApp.error.TrackNotFoundException;
import com.stackroute.MuzixApp.repository.MuzixRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
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

    //RestTemplate object to retrive database objects of last.fm and use method
    //saveTopTracks() to save it locally



    @Override
    public Muzix getTopTracks()
    {
        ObjectMapper mapper = new ObjectMapper();
        RestTemplate template=new RestTemplate();
        final String REST_URL= "http://ws.audioscrobbler.com/2.0/?method=geo.gettoptracks&country=spain&api_key=" +
                "0c2de416d741d77e1101be7afaac206e&format=json";



//        get a json object as a String
        String json = template.getForObject(REST_URL, String.class);
        Muzix topTrack = new Muzix();

        try {
//            converting string as a json node
            JsonNode rootNode = mapper.readTree(json);
            ArrayNode arrayNode =  (ArrayNode)rootNode.path("tracks").path("track");
            //iterate the JSON array
            for (int i = 0; i < arrayNode.size(); i++) {
                //get a new Track object and fill it with data using setters
                Muzix track = new Muzix();
                track.setTrackName(arrayNode.get(i).path("name").asText());
                track.setComment(arrayNode.get(i).path("artist").path("name").asText());
                //save the track to database
               track= muzixRepository.save(track);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  topTrack;
    }




    @Override
    public Muzix saveTrack(Muzix muzix)throws TrackAlreadyExistsException {
        if(muzixRepository.existsById(muzix.getTrackId()))
        {
            throw new TrackAlreadyExistsException();
        }

        Muzix savedUser = muzixRepository.save(muzix);
        if(savedUser == null)
        {
            throw new TrackAlreadyExistsException();
        }
        return savedUser;
    }

    @Override
    public List<Muzix> getAllTrack() {

        return muzixRepository.findAll();
    }

    @Override
    public boolean deleteTrack(int trackId)throws TrackNotFoundException
    {
        if(muzixRepository.existsById(trackId)) {
            muzixRepository.deleteById(trackId);
            return true;
        }
        else
        {
            throw new TrackNotFoundException();
        }
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
    public List<Muzix> findByName(String trackName)throws TrackNotFoundException
    {
        List<Muzix> muzix = muzixRepository.findByName(trackName);
        if(muzix.isEmpty())
        {
            throw new TrackNotFoundException();
        }

       return muzix;

    }

}