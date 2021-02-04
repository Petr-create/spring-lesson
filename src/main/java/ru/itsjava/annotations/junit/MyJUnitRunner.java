package ru.itsjava.annotations.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyJUnitRunner {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        //1.Создать два счетчика упавших и прошедших тестов
        //2.Создать объект класса MyAmazingTest и запустить методы над которыми стоит аннотоция @Test
        //3.Подсчитать сколько тестов упало и сколько прошло
        //4.Вывести количество упавших и пройденных тестов

        int passedTests = 0;
        int failedTests = 0;

        MyAmazingTest myAmazingTest = new MyAmazingTest();
        Method[] declaredMethods = MyAmazingTest.class.getDeclaredMethods();
        for(Method method : declaredMethods){
            try {
                method.invoke(myAmazingTest);
                System.out.println("Тест " + method.getName() + " успешно прошел");
                passedTests++;
            }catch (Throwable throwable){
                System.err.println("Тест " + method.getName() + " упал");
                failedTests++;
                throwable.printStackTrace();
            }
        }

        System.out.println("Количество прошедших тестов: " + passedTests);
        System.out.println("Количество упавших тестов: " + failedTests);
    }
}
