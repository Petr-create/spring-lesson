package ru.itsjava.annotations.myjunit;

public class Main {
    public static void main(String[] args) {
        MyAwfulTest iGeneralAwful = new MyAwfulTest();
        MyGoodTest iGeneralGood = new MyGoodTest();
        RunnerAnnotation runnerAnnotation = new RunnerAnnotation(iGeneralAwful);
        runnerAnnotation.run();

    }
}
