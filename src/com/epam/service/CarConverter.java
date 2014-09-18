package com.epam.service;

import java.lang.reflect.Method;

import com.epam.model.Car;

public class CarConverter {

	public static String convertToString(Car car) throws Exception
	{
		Class<?> currentCarClass = car.getClass();
		Method getModel = currentCarClass.getDeclaredMethod("getModel");
		Method getPower = currentCarClass.getDeclaredMethod("getPower");
		Method getDateOfCreation = currentCarClass.getDeclaredMethod("getDateOfCreation");

		return "Car [model=" + getModel.invoke(car) + ", power=" + getPower.invoke(car).toString() 
				+ ", dateOfCreation=" + getDateOfCreation.invoke(car) + "]";

	}

}



