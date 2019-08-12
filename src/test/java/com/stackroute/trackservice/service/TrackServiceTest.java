package com.stackroute.trackservice.service;

import com.stackroute.trackservice.domain.Track;
import com.stackroute.trackservice.exception.TrackAlreadyExistException;
import com.stackroute.trackservice.exception.TrackNotFoundException;
import com.stackroute.trackservice.repository.TrackRespository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TrackServiceTest {
    private Track track;

    //Create a mock for UserRepository
    @Mock
    private TrackRespository trackRespository;

    //Inject the mocks as dependencies into UserServiceImpl
    @InjectMocks
    private TrackServiceImp trackServiceImp;


    private List<Track> list;


    @Before
    public void setUp() {
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        track = new Track();
        track.setId(19);
        track.setName("rakesh");
        track.setComment("i am rakesh");
        list = new ArrayList<>();
        list.add(track);


    }

    @After
    public void tearDown() {
        track = null;
        list = null;


    }


    @Test
    public void givenTrackShouldSaveTrackAndTestSuccess() throws TrackAlreadyExistException {
        when(trackRespository.save((Track) any())).thenReturn(track);
        Track savedTrack = trackServiceImp.saveTrack(track);
        Assert.assertEquals(track, savedTrack);
        //verify here verifies that userRepository save method is only called once
        verify(trackRespository, times(1)).save(track);
    }


    @Test
    public void givenTrackShouldGetTrackById() throws TrackNotFoundException {
        when(trackRespository.findById(track.getId())).thenReturn(Optional.of(track));
        Track savedTrack = trackServiceImp.getTrackById(track.getId()).get();
        Assert.assertEquals(track, savedTrack);
        //verify here verifies that userRepository save method is only called once
        verify(trackRespository, times(2)).findById(track.getId());
    }

    @Test(expected = TrackAlreadyExistException.class)
    public void givenTrackShouldSaveTrackAndTestFailure() throws TrackAlreadyExistException {
        when(trackRespository.save((Track) any())).thenReturn(null);
        Track savedUser = trackServiceImp.saveTrack(track);
        System.out.println("savedUser" + savedUser);
        verify(trackRespository, times(1)).findById(19);


    }


    @Test
    public void givenTrackShouldGetAllTracks() throws TrackNotFoundException {

        trackRespository.save(track);
        //stubbing the mock to return specific data
        when(trackRespository.findAll()).thenReturn(list);
        List<Track> userlist = trackServiceImp.getAllTracks();
        Assert.assertEquals(list, userlist);
        verify(trackRespository, times(2)).save(track);
    }

    @Test
    public void givenTrackShouldGetTrackByName() throws TrackNotFoundException {
        trackRespository.save(track);
        when(trackRespository.findByName("rakesh")).thenReturn(track);
        Track trackName = trackServiceImp.getByName(track.getName());
        Assert.assertEquals(track, trackName);
        verify(trackRespository, times(2)).save(track);

    }


    @Test
    public void givenTrackShouldDeleteTrackById() throws TrackNotFoundException {
        when(trackRespository.existsById(track.getId())).thenReturn(true);
        when(trackRespository.findById(19)).thenReturn(Optional.of(track));
        Optional<Track> trackDelete = trackServiceImp.deleteTrackById(19);
        Assert.assertEquals(track, trackDelete.get());
        verify(trackRespository, times(2)).findById(19);
    }

    @Test
    public void givenTrackShouldUpdateTrackAndTestSuccess() {
        trackRespository.save(track);
        Track track1 = new Track();
        track1.setName("rock n roll");
        track1.setComment("Best Track");
        when(trackRespository.findById(track.getId())).thenReturn(Optional.of(track));
        Track updateTrack = trackServiceImp.updateTrack(19, track1);
        when(trackRespository.save(updateTrack)).thenReturn(updateTrack);
        Assert.assertNotEquals(updateTrack, track);
        verify(trackRespository, times(1)).save(track);
    }
}


