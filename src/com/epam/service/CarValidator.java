package com.epam.service;

import java.lang.reflect.Field;

import com.epam.model.Car;

public class CarValidator {

	public static void validate (Car car) throws IllegalArgumentException, IllegalAccessException
	{
		Class<?> currentCarClass = Car.class;
		Field [] field = currentCarClass.getDeclaredFields();
		for (Field f : field)
		{
			f.setAccessible(true);

			if (f.get(car) == null)
			{
				System.out.println("Field "+ f.getName()+ " is empty");
			}
		}
	}
}