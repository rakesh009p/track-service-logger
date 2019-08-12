//package com.stackroute.trackservice.seeddata;
//
//
//import com.stackroute.trackservice.domain.Track;
//import com.stackroute.trackservice.repository.TrackRespository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.stereotype.Component;
//
//@Component
//@PropertySource("classpath:application.properties")
//public class CommandLineRunnerImpl implements CommandLineRunner {
//    private TrackRespository trackRepository;
//
//    @Autowired
//    public CommandLineRunnerImpl(TrackRespository trackRepository) {
//        this.trackRepository = trackRepository;
//    }
//
//    @Autowired
//    private Environment environment;
//
//    @Value("${id}")
//    int id;
//    @Value("${name1}")
//    String name;
//    @Value("${comment}")
//    String comment;
//
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        Track track1 = new Track(id, name,comment);
//        trackRepository.save(track1);
//        Track track2 = new Track(3, environment.getProperty(name), "nice");
//        trackRepository.save(track2);
//    }
//}