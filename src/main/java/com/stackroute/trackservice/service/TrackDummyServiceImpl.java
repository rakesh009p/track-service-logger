//package com.stackroute.trackservice.service;
//
//import com.stackroute.trackservice.domain.Track;
//import com.stackroute.trackservice.exception.TrackAlreadyExistException;
//import com.stackroute.trackservice.exception.TrackNotFoundException;
//import com.stackroute.trackservice.repository.TrackRespository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Primary;
//import org.springframework.context.annotation.Profile;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//
//@Profile("product")
//public class TrackDummyServiceImpl implements TrackService {
//
//    TrackRespository trackRespository;
//
//    public TrackDummyServiceImpl() {
//    }
//
//
//    @Autowired
//    public TrackDummyServiceImpl(TrackRespository trackRespository) {
//        this.trackRespository = trackRespository;
//    }
//
//
//    @Override
//    public Track saveTrack(Track user) throws TrackAlreadyExistException {
//        return null;
//    }
//
//    @Override
//    public Optional<Track> getTrackById(int id) throws TrackNotFoundException {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Track> getAllTracks() throws TrackNotFoundException {
//        return null;
//    }
//
//    @Override
//    public Optional<Track> deleteTrackById(int id) throws TrackNotFoundException {
//        return Optional.empty();
//    }
//
//    @Override
//    public Track updateTrack(int id, Track track) {
//        return null;
//    }
//
////    @Override
////    public Track getTrackByName(String name) throws TrackNotFoundException {
////        return null;
////    }
//}
