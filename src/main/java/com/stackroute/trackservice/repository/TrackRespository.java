package com.stackroute.trackservice.repository;

import com.stackroute.trackservice.domain.Track;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRespository extends MongoRepository<Track, Integer> {
    Track findByName(String name);


}
