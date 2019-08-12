package com.stackroute.trackservice.controller;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exception.TrackAlreadyExistException;
import com.stackroute.trackservice.exception.TrackNotFoundException;
import com.stackroute.trackservice.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
//maps web request
public class TrackController {
    private TrackService trackService;

    public TrackController() {
    }

    @Autowired
    public TrackController( TrackService trackService) {

        this.trackService = trackService;
    }
    //save track
    //returns user object

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistException , HttpServerErrorException.InternalServerError {
        ResponseEntity responseEntity;

        trackService.saveTrack(track);
        responseEntity = new ResponseEntity<String>("sucessfully ceated", HttpStatus.RESET_CONTENT);

        return responseEntity;
    }

    //get Track by id
    @GetMapping("track/{id}")
    public ResponseEntity<?> getTrackById(@PathVariable int id) throws TrackNotFoundException, HttpServerErrorException.InternalServerError {
        ResponseEntity responseEntity;

        trackService.getTrackById(id);
        responseEntity = new ResponseEntity<String>("retrived by id", HttpStatus.CREATED);

        return responseEntity;

    }
    //get all tasks

    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks() throws TrackNotFoundException, HttpServerErrorException.InternalServerError {
        ResponseEntity responseEntity;

        trackService.getAllTracks();
        responseEntity = new ResponseEntity("Retreived All Tracks", HttpStatus.OK);

        return responseEntity;
    }

    //getting data using getByName using getMapping
    //stores the name and return the selected name list
    @GetMapping("track/{name}")
    public ResponseEntity<?> getTrackByName(@PathVariable String name) throws TrackNotFoundException, HttpServerErrorException.InternalServerError {
        ResponseEntity responseEntity;

        trackService.getByName(name);
        responseEntity = new ResponseEntity<String>("retrived by name", HttpStatus.PARTIAL_CONTENT);

        return responseEntity;

    }

    //delete track
    //returns responseEntity with object or message
    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrackbyId(@PathVariable int id) throws TrackNotFoundException, HttpServerErrorException.InternalServerError {
        ResponseEntity responseEntity;

        trackService.deleteTrackById(id);
        responseEntity = new ResponseEntity<String>("deleted by id", HttpStatus.MULTI_STATUS);

        return responseEntity;
    }

    //update track
    @PutMapping("trackupdate/{id}")
    public ResponseEntity<?> updateTrack(@PathVariable int id, @RequestBody Track track) throws HttpServerErrorException.InternalServerError {
        Track updatedTrack = trackService.updateTrack(id, track);
        return new ResponseEntity<>(updatedTrack, HttpStatus.ACCEPTED);
    }
}

