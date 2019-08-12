package com.stackroute.trackservice.repository;

import com.stackroute.trackservice.domain.Track;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class TrackRespositoryTest {


    @Autowired
    private TrackRespository trackRespository;
    private Track track;

    @Before
    public void setUp() {
        track = new Track();
        track.setName("Rakesh");
        track.setId(262);
        track.setComment("Comment this");

    }

    @After
    public void tearDown() {

        trackRespository.deleteAll();
        track=null;
    }


    @Test
    public void givenTrackInputShouldReturnTrackByName() {
        trackRespository.save(track);
        Track track1 = trackRespository.findByName(track.getName());
        Assert.assertEquals("Rakesh",track1.getName());



    }
    @Test
    public void givenTrackShouldReturnTrackById(){
        trackRespository.save(track);
        Track track1= trackRespository.findById(track.getId()).get();
        Assert.assertEquals(262,track1.getId());

    }
    @Test
    public void givenTrackshouldReturnAllTracks(){
        trackRespository.save(track);
        List<Track> list = trackRespository.findAll();
        Assert.assertEquals("Rakesh",list.get(0).getName());
    }
    @Test
    public void givenTrackShouldDeleteTrackById(){
        trackRespository.save(track);
        trackRespository.deleteById(track.getId());
        assertEquals(true, trackRespository.existsById(track.getId()));

    }
    @Test
    public void gievnTrackShouldUpdateTrackById() {
        Track t1 = new Track(1, "bahubali", "title track");
        Track t2 = new Track(2, "rrr", "intro song");
        trackRespository.save(t1);
        trackRespository.save(t2);


        Track trackList = trackRespository.findById(t1.getId()).get();
        trackList.setName(t2.getName());

        assertEquals(trackList.getName(), t2.getName());

    }


}