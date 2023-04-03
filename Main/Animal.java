package Main;

import java.io.Serializable;

public abstract class Animal implements Serializable {

    private static int numberOfCreatedAnimals = 0;

    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        numberOfCreatedAnimals++;
    }

    public abstract String getSpecies();

    public void play() {
        System.out.println(this + " is having fun.");
    }

    public void jump() {
        System.out.println(this.getSpecies() + " is jumping!");
    }

    public void land() {
        System.out.println(this.getSpecies() + " is landing!");
    }

    public String toString() {
        return "The " + this.getSpecies() + " " + name + " is " + age + " years old (" + this.getHumanAge() + " in human years).";
    }

    public int getHumanAge() {
        return age * 2;
    }

    public static int getNumberOfCreatedAnimals() {
        return numberOfCreatedAnimals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
