package com.ifmo.lesson19.injector;

import com.ifmo.lesson17.builder.Pizza;

import java.lang.reflect.Field;

public class ReflectionUtils {

    static String toString(Object obj) throws IllegalAccessException {

        Class<?> aClass = obj.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();


        String s = aClass.getSimpleName() + " = ";

        for (Field d:declaredFields) {
            d.setAccessible(true);
            if (!d.isAnnotationPresent(Exclude.class)) {
                s = s + " {" + d.getName() + " = " + d.get(obj).toString() + "} ";
            }
        }

        return s;
    };

    public static void main(String[] args) throws IllegalAccessException {
        Pizza pizza = new Pizza.Builder("thin","parmezan").ketchup(8).pepperoni(2).build();

        System.out.println(toString(new TestClass(3,4,"test",pizza)));
    }
}
