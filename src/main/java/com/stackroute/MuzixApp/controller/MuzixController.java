package com.stackroute.MuzixApp.controller;

import com.stackroute.MuzixApp.domain.Muzix;
import com.stackroute.MuzixApp.service.MuzixSrevice;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
@Api(value = "Muzix Management System")
public class MuzixController
{

    //Object creation for MuzixService class
        MuzixSrevice muzixSrevice;

        public MuzixController(MuzixSrevice muzixSrevice)
        {
            this.muzixSrevice=muzixSrevice;
        }


        //Method to save a row in database
        @ApiOperation(value = "Add a Muzix track")
        @PostMapping("/save")
        public ResponseEntity<?> saveTrack(@ApiParam(value = "Muzix object stored in database table", required = true)
                                           @Valid @RequestBody Muzix muzix)
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
        @ApiOperation(value = "View a list of available Muzix objects", response = ResponseEntity.class)
       @ApiResponses(value = {
                @ApiResponse(code = 200, message = "Successfully retrieved list"),
                @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
                @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
                @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
        })
        @GetMapping(value = "/get")
        public ResponseEntity<?> getAllTrack()
        {
            return new ResponseEntity<List<Muzix>>(muzixSrevice.getAllTrack(), HttpStatus.OK);
        }


        //Method to delete a particular row marked by its ID
        @ApiOperation(value = "Delete a Muzix object")
        @DeleteMapping("/delete/{trackId}")
        public ResponseEntity<?> deleteTrack(@ApiParam(value = "trackId for which Muzix object will delete from database table", required = true)
                                                    @PathVariable int trackId)
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
        @ApiOperation(value = "Update a Muzix object")
        @PutMapping("/update/{trackId}")
        public ResponseEntity<?> updateTrack( @ApiParam(value = "Muzix Id to update Muzix object", required = true)
                                                      @PathVariable(value = "id") int trackId,
                                              @ApiParam(value = "Update Muzix object", required = true)
                                              @Valid @RequestBody Muzix muzix)
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
        @GetMapping(value = "/byName/{trackName}")
        public ResponseEntity<List<Muzix>> findByName(@ApiParam(value = "trackName for which Muzix object will display from " +
                                                        "database table", required = true)
                                                    @PathVariable String trackName,Muzix muzix)
        {
            ResponseEntity responseEntity;
          try
            {
                List<Muzix> findName = muzixSrevice.findByName(trackName);
               // return new ResponseEntity<List<Muzix>>(findName,HttpStatus.OK);
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
