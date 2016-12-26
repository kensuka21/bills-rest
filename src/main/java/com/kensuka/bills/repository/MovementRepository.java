package com.kensuka.bills.repository;

import com.kensuka.bills.repository.entity.Movement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by kmukai on 10/7/2016.
 */
@Repository
public interface MovementRepository extends MongoRepository<Movement, String>{

    List<Movement> findByType(String type);
}
