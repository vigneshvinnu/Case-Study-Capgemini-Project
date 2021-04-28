package com.capgemini.project.farecalculator.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.capgemini.project.farecalculator.model.Fare;
import org.springframework.stereotype.Repository;

@Repository
public interface Farerepository extends MongoRepository<Fare, Integer>{
    /*default double FareEstimator(Fare fare) {

    }*/


}
