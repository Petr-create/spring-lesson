package ru.itsjava.annotations.myjunit;

public class Main {
    public static void main(String[] args) {
        IGeneral iGeneralAwful = new MyAwfulTest();
        IGeneral iGeneralGood = new MyGoodTest();
        RunnerAnnotation runnerAnnotation = new RunnerAnnotation(iGeneralAwful);
        runnerAnnotation.run();
    }
}
