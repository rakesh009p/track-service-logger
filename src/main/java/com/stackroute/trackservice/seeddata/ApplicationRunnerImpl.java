//package com.stackroute.trackservice.seeddata;
//
//
//import com.stackroute.trackservice.domain.Track;
//import com.stackroute.trackservice.repository.TrackRespository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ApplicationRunnerImpl implements ApplicationListener {
//    private TrackRespository trackRepository;
//
//    @Autowired
//    public ApplicationRunnerImpl(TrackRespository trackRepository) {
//        this.trackRepository = trackRepository;
//    }
//
//    @Override
//    public void onApplicationEvent(ApplicationEvent applicationEvent) {
//        Track track1 = new Track(62, "rakesh", "good");
//        trackRepository.save(track1);
//        Track track2 = new Track(63, "rakhi", "great");
//        trackRepository.save(track2);
//        Track track3 = new Track(64, "rak", "best");
//        trackRepository.save(track3);
//    }
//}