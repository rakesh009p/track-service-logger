package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exception.TrackAlreadyExistException;
import com.stackroute.trackservice.exception.TrackNotFoundException;

import java.util.List;
import java.util.Optional;

//declaring methods with parameters and respective exceptions
public interface TrackService {


    public Track saveTrack(Track user) throws TrackAlreadyExistException;

    public Optional<Track> getTrackById(int id) throws TrackNotFoundException;

    public List<Track> getAllTracks() throws TrackNotFoundException;

    public Optional<Track> deleteTrackById(int id) throws TrackNotFoundException;

    public Track updateTrack(int id, Track track);

    //declaring method name with parameter
    public Track getByName(String name) throws TrackNotFoundException;


}
