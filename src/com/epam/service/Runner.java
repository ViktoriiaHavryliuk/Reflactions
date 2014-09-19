package com.epam.service;

import java.util.HashMap;
import java.util.Map;

import com.epam.model.Car;
import com.epam.model.ElectricCar;

public class Runner {

	public static void main(String[] args) throws Exception {
		Map<String, Object> data = new HashMap<>();
		data.put("model", "BMW");
		data.put("power", 42);
		data.put("dateOfCreation", "18.09.2014");
		Car car = CarFactory.create("com.epam.model.Car", data);
		System.out.println(car);
		CarValidator.validate(car);
		System.out.println(CarConverter.convertToString(car));
		Map<String, Object> dataForBond = new HashMap<>();
		dataForBond.put("timeOfCharge", 42);
		ElectricCar bondsCar = (ElectricCar) CarFactory.create("com.epam.model.ElectricCar", dataForBond);
		CarValidator.validate(bondsCar);
		System.out.println(CarConverter.convertToString(bondsCar));
	}

}
