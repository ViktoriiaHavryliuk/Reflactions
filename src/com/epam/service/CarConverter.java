package com.epam.service;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.epam.model.Car;

public class CarConverter {

	public static String convertToString(Car car) throws Exception
	{
		Class<?> currentCarClass = car.getClass();
		Method getModel = null;
		Method getPower = null;
		Method getDateOfCreation = null;
		try{
			getModel = currentCarClass.getDeclaredMethod("getModel");
		}catch (NoSuchMethodException e){
			System.out.println("Model of "+currentCarClass.getSimpleName()+" is not filled!");
		}
		try{
			getPower = currentCarClass.getDeclaredMethod("getPower");
		}catch (NoSuchMethodException e){
			System.out.println("Power of "+currentCarClass.getSimpleName()+" is not filled!");
		}
		try{
			getDateOfCreation = currentCarClass.getDeclaredMethod("getDateOfCreation");
		}catch (NoSuchMethodException e){
			System.out.println("Date of creations of "+currentCarClass.getSimpleName()+" is not filled!");
		}
		if (getModel ==null || getPower == null || getDateOfCreation==null)
			{
			return "Can't give you formated line, some or all fields are empty!";
			}
		else
		{
		return "Car [model=" + getModel.invoke(car) + ", power=" + getPower.invoke(car)
				+ ", dateOfCreation=" + getDateOfCreation.invoke(car) + "]";
		}

	}
	
	public static String convertToJSON(Car car) throws Exception {
		Class<?> currentCarClass = car.getClass();
		Method getModel = null;
		Method getPower = null;
		Method getDateOfCreation = null;
		try{
			getModel = currentCarClass.getDeclaredMethod("getModel");
		}catch (NoSuchMethodException e){
			System.out.println("Model of "+currentCarClass.getSimpleName()+" is not filled!");
		}
		try{
			getPower = currentCarClass.getDeclaredMethod("getPower");
		}catch (NoSuchMethodException e){
			System.out.println("Power of "+currentCarClass.getSimpleName()+" is not filled!");
		}
		try{
			getDateOfCreation = currentCarClass.getDeclaredMethod("getDateOfCreation");
		}catch (NoSuchMethodException e){
			System.out.println("Date of creations of "+currentCarClass.getSimpleName()+" is not filled!");
		}
		if (getModel ==null || getPower == null || getDateOfCreation==null)
			{
			return "Can't give you formatted JSON, some or all fields are empty!";
			}
		else
		{
		return "Car [model=" + getModel.invoke(car) + ", power=" + getPower.invoke(car)
				+ ", dateOfCreation=" + getDateOfCreation.invoke(car) + "]";
		}

	}

}







