package com.Capgemini.Project.userandadminoperations.Repository;

import com.Capgemini.Project.userandadminoperations.model.Flights;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightsRepository extends MongoRepository<Flights, String> {

     List<Flights> findByFlightLandingStation(String flightLandingStation);

     List<Flights> findByFlightTakeOffStation(String flightTakeOffStation);

    List<Flights> findByFlightTakeOffStationAndFlightLandingStationAndDepartureDate(String flightTakeOffStation,
                                                                   String flightLandingStation,
                                                                                    String departureDate);

    Flights findByFlightId(String flightId);
}
