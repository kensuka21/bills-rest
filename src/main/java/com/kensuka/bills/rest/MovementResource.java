package com.kensuka.bills.rest;

import com.kensuka.bills.repository.entity.Movement;
import com.kensuka.bills.service.MovementService;
import com.kensuka.bills.type.MovementType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by kmukai on 10/24/2016.
 */
@RestController()
@RequestMapping(value = "/api/movement")
public class MovementResource {

    @Autowired
    private MovementService movementService;

    @GetMapping(value = "/expenses")
    public ResponseEntity<?> findAllExpenses() {
        List<Movement> expenses = movementService.findAll(MovementType.EXPENSE);
        return ResponseEntity.ok(expenses);
    }

    @GetMapping(value = "/incomes")
    public ResponseEntity<?> findAllIncomes() {
        List<Movement> incomes = movementService.findAll(MovementType.INCOME);
        return ResponseEntity.ok(incomes);
    }

    @PostMapping(value = "/expenses")
    public ResponseEntity<?> addExpense(@RequestBody @Valid Movement movement, BindingResult result) {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldError().getDefaultMessage() + " " + result.getFieldError().getField());
        }
        movement.setType(MovementType.EXPENSE.getDescription());

        movement = movementService.save(movement);

        return ResponseEntity.ok(movement);
    }

    @PostMapping(value = "/incomes")
    public ResponseEntity<?> addIncome(@RequestBody @Valid Movement movement, BindingResult result) {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getFieldError().getDefaultMessage() + " " + result.getFieldError().getField());
        }
        movement.setType(MovementType.INCOME.getDescription());

        movement = movementService.save(movement);

        return ResponseEntity.ok(movement);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteIncome(@PathVariable String id) {
        movementService.delete(id);
        return ResponseEntity.ok(true);
    }


    @GetMapping(value = "/income/amount")
    public ResponseEntity<?> incomeAmount(){
        List<Movement> incomes = movementService.findAll(MovementType.INCOME);
        BigDecimal amount = BigDecimal.ZERO;

        if(incomes != null){
            for(Movement i : incomes ){
                amount = amount.add(i.getAmount());
            }
        }

        return ResponseEntity.ok(amount);
    }

    @GetMapping(value = "/expense/amount")
    public ResponseEntity<?> expenseAmount(){
        List<Movement> expenses = movementService.findAll(MovementType.EXPENSE);
        BigDecimal amount = BigDecimal.ZERO;

        if(expenses != null){
            for(Movement i : expenses ){
                amount = amount.add(i.getAmount());
            }
        }

        return ResponseEntity.ok(amount);
    }

}
