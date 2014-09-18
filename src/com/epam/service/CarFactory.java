package com.epam.service;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.crypto.Data;

import com.epam.model.Car;

public class CarFactory {

	public static Car create(String className, Map<String, Object> content)
			throws Exception {

		Class<?> inputClass = Class.forName(className);
		Class<? extends Car> currentCarClass = inputClass.asSubclass(Car.class);
		Car car = currentCarClass.newInstance();

		for (Entry<String, Object> entry : content.entrySet()) {
			
			String nameOfmethod = "set"
					+ Character.toString(entry.getKey().charAt(0))
							.toUpperCase() + entry.getKey().substring(1);
			
			if (entry.getValue() instanceof String) {
				Method setter = inputClass.getDeclaredMethod(nameOfmethod,String.class);
				setter.setAccessible(true);
				setter.invoke(car, entry.getValue());
			} else if (entry.getValue() instanceof Data){
				Method setter = inputClass.getDeclaredMethod(nameOfmethod,Data.class);
				setter.setAccessible(true);
				setter.invoke(car, entry.getValue());
			} else {
				Method setter = inputClass.getDeclaredMethod(nameOfmethod,Integer.class);
				setter.setAccessible(true);
				setter.invoke(car, entry.getValue());
			}
		}
		return car;

	}

}
