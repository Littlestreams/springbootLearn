package com.no4.core.customizeAnnotation;

import java.lang.reflect.Field;

/**
 * 注解处理类
 * @author MR.Q
 * @date 2019年10月25日 下午5:02:19
 */
public class AnnotationUtils {
  public static void getDogInfo(Class<?> clazz) {
	  //获取类中的所有字段
	  Field [] fields=clazz.getDeclaredFields();
	  for (Field field : fields) {
		  //B类型的注解是否在A类上
		if(field.isAnnotationPresent(AnimalName.class)) {
			//获得注解的对象
			AnimalName animalName =field.getAnnotation(AnimalName.class);
			System.out.println("所属物种："+animalName.name());
		}else if(field.isAnnotationPresent(DogShow.class)){
			DogShow dogShow = field.getAnnotation(DogShow.class);
			System.out.println("名称："+dogShow.name());
			System.out.println("颜色："+dogShow.color());
			System.out.println("年龄："+dogShow.age());
			System.out.println("爱好："+dogShow.likes());
		}
	} 
 }
}
