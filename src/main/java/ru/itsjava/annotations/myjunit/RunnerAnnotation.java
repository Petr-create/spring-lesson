package ru.itsjava.annotations.myjunit;

import ru.itsjava.annotations.myjunit.repannotation.After;
import ru.itsjava.annotations.myjunit.repannotation.AfterEach;
import ru.itsjava.annotations.myjunit.repannotation.Before;
import ru.itsjava.annotations.myjunit.repannotation.BeforeEach;

import java.lang.reflect.Method;

public class RunnerAnnotation {

    MyAwfulTest myAwfulTest = new MyAwfulTest();
    Method[] declaredMethods = MyAwfulTest.class.getDeclaredMethods();

    public void Before() {
        //Method[] decl = MyAwfulTest.class.getDeclaredMethod("testBefore");
        for (Method method : declaredMethods) {
            try {
                if (method.isAnnotationPresent(Before.class)) {
                    method.invoke(myAwfulTest);
                    System.out.println("Тест " + method.getName() + " успешно прошел");
                }
            } catch (Throwable throwable) {
                System.err.println("Тест " + method.getName() + " упал");
            }
        }
        System.out.println();
        Test();
    }

    public void Test() {
        int passedTests = 0;
        int failedTests = 0;

        MyAwfulTest myAwfulTest = new MyAwfulTest();
        Method[] declaredMethods = MyAwfulTest.class.getDeclaredMethods();

        for (Method method : declaredMethods) {

            if (!method.isAnnotationPresent(Before.class) && !method.isAnnotationPresent(After.class)
                    && !method.isAnnotationPresent(BeforeEach.class) && !method.isAnnotationPresent(AfterEach.class)) {
                BeforeEach();
                try {
                    method.invoke(myAwfulTest);
                    System.out.println("Тест " + method.getName() + " успешно прошел");
                    passedTests++;
                } catch (Throwable throwable) {
                    System.out.println("Тест " + method.getName() + " упал");
                    failedTests++;
                    //throwable.printStackTrace();
                }
                AfterEach();
            }

            System.out.println();
        }

        System.out.println("Количество прошедших тестов: " + passedTests);
        System.out.println("Количество упавших тестов: " + failedTests);
        System.out.println();
        After();
    }

    public void After() {
        for (Method method : declaredMethods) {
            try {
                if (method.isAnnotationPresent(After.class)) {
                    method.invoke(myAwfulTest);
                    System.out.println("Тест " + method.getName() + " успешно прошел");
                    System.out.println();
                }
            } catch (Throwable throwable) {
                System.err.println("Тест " + method.getName() + " упал");
            }
        }
    }

    public void BeforeEach() {
        for (Method method : declaredMethods) {
            try {
                if (method.isAnnotationPresent(BeforeEach.class)) {
                    method.invoke(myAwfulTest);
                    //System.out.println("Тест " + method.getName() + " успешно прошел");
                }
            } catch (Throwable throwable) {
                System.err.println("Тест " + method.getName() + " упал");
            }
        }
    }

    public void AfterEach() {
        for (Method method : declaredMethods) {
            try {
                if (method.isAnnotationPresent(AfterEach.class)) {
                    method.invoke(myAwfulTest);
                    //System.out.println("Тест " + method.getName() + " успешно прошел");
                }
            } catch (Throwable throwable) {
                System.err.println("Тест " + method.getName() + " упал");
            }
        }
    }
}
