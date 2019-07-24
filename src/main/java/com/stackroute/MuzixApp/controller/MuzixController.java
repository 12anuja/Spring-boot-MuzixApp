package com.stackroute.MuzixApp.controller;

import com.stackroute.MuzixApp.domain.Muzix;
import com.stackroute.MuzixApp.service.MuzixSrevice;
import org.aspectj.weaver.patterns.HasMemberTypePatternForPerThisMatching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
public class MuzixController
{

    //Object creation for MuzixService class
        MuzixSrevice muzixSrevice;

        public MuzixController(MuzixSrevice muzixSrevice)
        {
            this.muzixSrevice=muzixSrevice;
        }


        //Method to save a row in database
        @PostMapping("/save")
        public ResponseEntity<?> saveTrack(@RequestBody Muzix muzix)
        {
            ResponseEntity responseEntity;
            try
            {
                muzixSrevice.saveTrack(muzix);
                responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);
            }
            catch (Exception ex)
            {
                responseEntity=new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);

            }
            return responseEntity;

        }

        //Method to display all records in table
        @GetMapping("/get")
        public ResponseEntity<?> getAllTrack()
        {
            return new ResponseEntity<List<Muzix>>(muzixSrevice.getAllTrack(), HttpStatus.OK);
        }


        //Method to delete a particular row marked by its ID
        @DeleteMapping("/delete/{trackId}")
        public ResponseEntity<?> deleteTrack(@PathVariable int trackId)
        {
            try {
                muzixSrevice.deleteTrack(trackId);
                return new ResponseEntity<String>("Successfully deleted", HttpStatus.NO_CONTENT);
            }
            catch (Exception e)
            {
                return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
            }
        }


        //Method to update a row identified by its ID
        @PutMapping("/update/{trackId}")
        public ResponseEntity<?> updateTrack(@PathVariable int trackId, Muzix muzix)
        {
            ResponseEntity responseEntity;
            try
            {
                Muzix update = muzixSrevice.updateTrack(muzix,trackId);
                responseEntity=new ResponseEntity<String>("Successfully updated", HttpStatus.CREATED);
            }
            catch (Exception ex)
            {
                responseEntity=new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);

            }
            return responseEntity;

        }

        //Method to display a row based on its trackName
        @GetMapping("/byName/{trackName}")
        public ResponseEntity<?> findByName(@PathVariable String trackName, Muzix muzix)
        {
            ResponseEntity responseEntity;
            try
            {
                List<Muzix> findName = muzixSrevice.findByName(trackName);
                muzixSrevice.saveTrack(muzix);
                if(findName != null) {
                    responseEntity = new ResponseEntity<String>("Found track", HttpStatus.FOUND);
                }else
                {
                    responseEntity = new ResponseEntity<String>("No such track exists", HttpStatus.NOT_FOUND);
                }

            }
            catch (Exception ex)
            {
                responseEntity=new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
            }
            return responseEntity;
        }
}
