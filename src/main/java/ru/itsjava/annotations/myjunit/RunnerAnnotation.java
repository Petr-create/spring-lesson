package ru.itsjava.annotations.myjunit;

import ru.itsjava.annotations.myjunit.repannotation.*;

import java.lang.reflect.Method;

public class RunnerAnnotation {
    private Object iGeneral;

    public RunnerAnnotation(Object iGeneral) {
        this.iGeneral = iGeneral;
    }

    public Method[] methodsCount(){
        Method[] declaredMethods = iGeneral.getClass().getDeclaredMethods();
        return declaredMethods;
    }

    public void run(){
        beforeRun();
    }

    public void beforeRun(){
        Method[] declaredMethods = methodsCount();
        for (Method method : declaredMethods) {
            try {
                if (method.isAnnotationPresent(Before.class)) {
                    method.invoke(iGeneral);
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

        Method[] declaredMethods = methodsCount();

        for (Method method : declaredMethods) {

            if (method.isAnnotationPresent(Test.class)) {
                beforeEach();
                try {
                    method.invoke(iGeneral);
                    System.out.println("Тест " + method.getName() + " успешно прошел");
                    passedTests++;
                } catch (Throwable throwable) {
                    System.out.println("Тест " + method.getName() + " упал");
                    failedTests++;
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
        Method[] declaredMethods = methodsCount();
        for (Method method : declaredMethods) {
            try {
                if (method.isAnnotationPresent(After.class)) {
                    method.invoke(iGeneral);
                    System.out.println("Тест " + method.getName() + " успешно прошел");
                    System.out.println();
                }
            } catch (Throwable throwable) {
                System.err.println("Тест " + method.getName() + " упал");
            }
        }
    }

    public void beforeEach() {
        Method[] declaredMethods = methodsCount();
        for (Method method : declaredMethods) {
            try {
                if (method.isAnnotationPresent(BeforeEach.class)) {
                    method.invoke(iGeneral);
                    //System.out.println("Тест " + method.getName() + " успешно прошел");
                }
            } catch (Throwable throwable) {
                System.err.println("Тест " + method.getName() + " упал");
            }
        }
    }

    public void afterEach() {
        Method[] declaredMethods = methodsCount();
        for (Method method : declaredMethods) {
            try {
                if (method.isAnnotationPresent(AfterEach.class)) {
                    method.invoke(iGeneral);
                    //System.out.println("Тест " + method.getName() + " успешно прошел");
                }
            } catch (Throwable throwable) {
                System.err.println("Тест " + method.getName() + " упал");
            }
        }
    }

}
