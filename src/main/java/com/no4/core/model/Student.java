package com.no4.core.model;

import java.io.Serializable;

public class Student implements Serializable {
  private String name;
  private int age;
  private String likes;
  
public Student(String name, int age, String likes) {
	super();
	this.name = name;
	this.age = age;
	this.likes = likes;
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the age
 */
public int getAge() {
	return age;
}
/**
 * @param age the age to set
 */
public void setAge(int age) {
	this.age = age;
}
/**
 * @return the likes
 */
public String getLikes() {
	return likes;
}
/**
 * @param likes the likes to set
 */
public void setLikes(String likes) {
	this.likes = likes;
}
/* (non-Javadoc)
 * @see java.lang.Object#toString()
 */
@Override
public String toString() {
	return "Student [name=" + name + ", age=" + age + ", likes=" + likes + "]";
}
  
}
