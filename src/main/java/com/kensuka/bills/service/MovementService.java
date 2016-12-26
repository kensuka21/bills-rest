package com.kensuka.bills.service;

import com.kensuka.bills.repository.entity.Movement;
import com.kensuka.bills.type.MovementType;

import java.util.List;

/**
 * Created by kmukai on 10/24/2016.
 */
public interface MovementService {


    Movement save(Movement movement);

    List<Movement> findAll(MovementType expense);

    void delete(String id);
}
