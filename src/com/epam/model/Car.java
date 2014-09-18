package com.epam.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Car {


		String model;
		Integer power;
		Date dateOfCreation;
		
		public final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
		
		public Car()
		{
			
		}
		
		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			
			this.model = model;
		}

		public Integer getPower() {
			return power;
		}

		public void setPower(Integer power) {
			this.power = power;
		}
		
		public void setPower(String power) {
			this.power = Integer.valueOf(power);			
		}

		public Date getDateOfCreation() {
			return dateOfCreation;
		}

		public void setDateOfCreation(Date dateOfCreation) {
			this.dateOfCreation = dateOfCreation;
		}

		public Car(String model, Integer power)
		{
			this.model = model;
			this.power = power;
		}
		
		public void setDateOfCreation (String dateOfCreation)
		{
			

			try {
				this.dateOfCreation = DATE_FORMAT.parse(dateOfCreation);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		@Override
		public String toString() {
			return "Car [model=" + model + ", power=" + power
					+ ", dateOfCreation=" + dateOfCreation + "]";
		}
		
	}


