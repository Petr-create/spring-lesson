package ru.itsjava.annotations;

import lombok.RequiredArgsConstructor;

@MyAnnotation(message = "Я персона номер один")
@RequiredArgsConstructor
public class Person {
    private final String name;
    private boolean isGood = false;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", isGood=" + isGood +
                '}';
    }
}
