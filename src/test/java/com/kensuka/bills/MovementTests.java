package com.kensuka.bills;

import com.kensuka.bills.repository.MovementRepository;
import com.kensuka.bills.repository.entity.Movement;
import com.kensuka.bills.service.MovementService;
import com.kensuka.bills.type.MovementType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MovementTests {

	@Autowired
	private MovementRepository movementRepository;

	@Autowired
	private MovementService movementService;


	@Test
	public void insert_movement_as_income() {
		Movement movement = new Movement();
		movement.setDescription("Wendy's");
		movement.setAmount(BigDecimal.valueOf(360));
		movement.setDate(LocalDate.now());
		movement.setType(MovementType.INCOME.getDescription());

		movement = movementRepository.save(movement);

		Assert.assertNotNull(movement.getId());
		Assert.assertEquals(movement.getType(), MovementType.INCOME.getDescription());
	}

	@Test
	public void insert_movement_as_expense() {
		Movement movement = new Movement();
		movement.setDescription("Wendy's");
		movement.setAmount(BigDecimal.valueOf(200));
		movement.setDate(LocalDate.now());
		movement.setType(MovementType.EXPENSE.getDescription());

		movement = movementRepository.save(movement);

		Assert.assertNotNull(movement.getId());
		Assert.assertEquals(movement.getType(), MovementType.EXPENSE.getDescription());
	}
}
