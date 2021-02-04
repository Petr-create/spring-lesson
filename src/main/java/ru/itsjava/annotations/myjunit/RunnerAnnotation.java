package ru.itsjava.annotations.myjunit;

import ru.itsjava.annotations.myjunit.repannotation.After;
import ru.itsjava.annotations.myjunit.repannotation.AfterEach;
import ru.itsjava.annotations.myjunit.repannotation.Before;
import ru.itsjava.annotations.myjunit.repannotation.BeforeEach;

import java.lang.reflect.Method;

public class RunnerAnnotation {

    MyAwfulTest myAwfulTest = new MyAwfulTest();
    Method[] declaredMethods = MyAwfulTest.class.getDeclaredMethods();

    public void run(){
        before();
    }

    public void before() {
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
        test();
    }

    public void test() {
        int passedTests = 0;
        int failedTests = 0;

        MyAwfulTest myAwfulTest = new MyAwfulTest();
        Method[] declaredMethods = MyAwfulTest.class.getDeclaredMethods();

        for (Method method : declaredMethods) {

            if (!method.isAnnotationPresent(Before.class) && !method.isAnnotationPresent(After.class)
                    && !method.isAnnotationPresent(BeforeEach.class) && !method.isAnnotationPresent(AfterEach.class)) {
                beforeEach();
                try {
                    method.invoke(myAwfulTest);
                    System.out.println("Тест " + method.getName() + " успешно прошел");
                    passedTests++;
                } catch (Throwable throwable) {
                    System.out.println("Тест " + method.getName() + " упал");
                    failedTests++;
                    //throwable.printStackTrace();
                }
                afterEach();
            }

            System.out.println();
        }

        System.out.println("Количество прошедших тестов: " + passedTests);
        System.out.println("Количество упавших тестов: " + failedTests);
        System.out.println();
        after();
    }

    public void after() {
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

    public void beforeEach() {
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

    public void afterEach() {
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
