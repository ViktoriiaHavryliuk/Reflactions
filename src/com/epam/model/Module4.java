package com.epam.model;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Module4 {

	public static void main(String[] args) throws Exception {



		Class<?> personClass = Class.forName("reflecrion.Person");
		p(personClass.getName());
		p(personClass.getSimpleName());
		p(personClass.getPackage());
		p(personClass.getSuperclass());

		p("-------------------------------------");

		p(personClass.isEnum());

		p(personClass.isInterface());
		p(personClass.isAssignableFrom(Student.class));
		p("-------------------------------------");

		Object person = personClass.newInstance();
		p(person);
		p("-------------------------------------");
		Constructor <?> personConstructor = personClass.getConstructor(String.class, Integer.class);
		person = personConstructor.newInstance("Vasya",123);
		p("-------------------------------------");
		Method getter = personClass.getDeclaredMethod("getName", String.class);
		p(getter.invoke(person));
		p("-------------------------------------");
		Method setter = personClass.getDeclaredMethod("setAge", Integer.class);
		setter.invoke(person, 5);
		setter = personClass.getDeclaredMethod("setAge", String.class);
		setter.invoke(person, "7");
		p("-------------------------------------");
		Person original = (Person) person;
		Person clone = (Person)original.clone();
		original.setName("Katya");
		original.setAge(178);
		p(clone);

		//		System.out.println(personClass==personClass2);

	}

	static void p(Object o) {
		System.out.println(o);
	}

}


class Person {
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setAge(String age) {
		this.age = Integer.valueOf(age);
	}
	Integer age;
	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}


	public Object clone (){
		Person clone = new Person(this.getName(), this.getAge());
		Class<?> personClass = this.getClass();
		Field [] fields = personClass.getDeclaredFields();
		for (Field field: fields){
			try {
				Object temp = field.get(this);
				field.setAccessible(true);
				field.set(clone, temp);
			} catch (Exception e) {	
				e.printStackTrace();
				throw new RuntimeException("Error during cloning!");
			}
		}
			return clone;
		}
		public Person() {

		}
		@Override 
		public String toString(){
			return "Person [ name = "+name+" age = "+age+"]";
		}

	}

	class Student extends Person {

		public Student(String name, Integer age) {
			super(name, age);
		}

	}

