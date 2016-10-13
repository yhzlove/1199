package com.y.test;

import java.lang.reflect.InvocationTargetException;

public class ReflectTest {

	public static void main(String[] args) {
		// TODO java反射测试
		Model model = new Model();
		model.setId(12323);
		model.setName("adsafds");
		model.setPass("asfdsafsa");// 给对象赋值
		ReflectTest fd = new ReflectTest();
		fd.getField(model);
		System.out.println("---------------------");
		fd.getField1(model);
	}

	private void getField(Object model) {
		try {
			java.lang.reflect.Method[] method = model.getClass()
					.getDeclaredMethods();// 获取对象所有方法
			for (java.lang.reflect.Method m : method) {
				System.out.println(m.getName());
				if (m.getName().startsWith("get")) {// 获取get方法
					Object o = m.invoke(model);// 执行
					if (o == null || "".equals(o.toString())) {
						System.out.println("aaa");
					} else {
						System.out.println(o.toString());// 输出相应的属性值
					}
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	private void getField1(Object model) {
		java.lang.reflect.Field[] fields = model.getClass().getDeclaredFields();
		for (java.lang.reflect.Field f : fields) {
			System.out.println(f.getName());
		}
	}
}
