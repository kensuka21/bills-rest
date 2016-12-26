package com.kensuka.bills.service.impl;

import com.kensuka.bills.repository.MovementRepository;
import com.kensuka.bills.repository.entity.Movement;
import com.kensuka.bills.service.MovementService;
import com.kensuka.bills.type.MovementType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by kmukai on 10/24/2016.
 */
@Service
public class MovementServiceImpl implements MovementService{

    @Autowired
    private MovementRepository movementRepository;

    @Override
    public Movement save(Movement movement) {
        return movementRepository.save(movement);
    }

    @Override
    public List<Movement> findAll(MovementType expense) {
        return movementRepository.findByType(expense.getDescription());
    }

    @Override
    public void delete(String id) {
        movementRepository.delete(id);
    }
}
