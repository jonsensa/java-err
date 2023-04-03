package Main;

import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;

public class Zoo implements Serializable {

    private String name;
    private String manager;
    private List<Animal> animals;

    public Zoo(String name, String manager) {
        this.name = name;
        this.manager = manager;
        this.animals = new ArrayList<>();
    }
    public void addAnimalMenu(Scanner sc) {
        System.out.println("1) Add a hedgehog, 2) Add a cat, 3) Add a lion");
        String input = sc.nextLine();

        switch (input) {
            case "1":
                System.out.println("Give it a name:");
                String hedgehogName = sc.nextLine();
                System.out.println("How old it is:");
                int hedgehogAge = Integer.parseInt(sc.nextLine());
                System.out.println("How many spikes it has:");
                int hedgehogSpikes = Integer.parseInt(sc.nextLine());
                Hedgehog hedgehog = new Hedgehog(hedgehogName, hedgehogAge, hedgehogSpikes);
                animals.add(hedgehog);
                System.out.println("Hi, I am Hedgehog and my name is " + hedgehogName + ".");
                break;

            case "2":
                System.out.println("Give it a name:");
                String catName = sc.nextLine();
                System.out.println("How old it is:");
                int catAge = Integer.parseInt(sc.nextLine());
                System.out.println("Give it a color:");
                String catColor = sc.nextLine();
                Cat cat = new Cat(catName, catAge, catColor);
                animals.add(cat);
                System.out.println("Hi, I am Cat and my name is " + catName + ".");
                break;

            case "3":
                System.out.println("Give it a name:");
                String lionName = sc.nextLine();
                System.out.println("How old it is:");
                int lionAge = Integer.parseInt(sc.nextLine());
                Lion lion = new Lion(lionName, lionAge);
                animals.add(lion);
                System.out.println("Hi, I am Lion and my name is " + lionName + ".");
                break;
        }
    }



    public void listAnimals() {
        System.out.println(name + " is lead by " + manager + " and it has the following animals:");
        for (Animal a : animals) {
            System.out.println(a);
        }
    }

    public void letAnimalsPlay() {

        for (Animal a : animals) {
            if (a instanceof Hedgehog) {
                System.out.println(a.getName() + " is having a lot of fun.");


            } else if (a instanceof Lion) {
                System.out.println(a.getName() + " is having a lot of fun.");

                ((Lion) a).jump();
                ((Lion) a).land();
            }
            else if (a instanceof Cat) {
                System.out.println(((Cat) a).getColor() +" " + a.getName() + " is having fun.");

                ((Cat) a).doNastyThings();
                ((Cat) a).jump();
                ((Cat) a).land();
            }
        }
    }

    public void nextYear() {
        System.out.println("One year has passed.");
        Iterator<Animal> iterator = animals.iterator();
        while (iterator.hasNext()) {
            Animal a = iterator.next();
            a.setAge(a.getAge() + 1);
            if (a.getAge() > 7 && a instanceof Hedgehog) {
                int deadAge = a.getAge() -1;
                System.out.println(a.getSpecies()+" " + a.getName() + " passed away at the age of " + deadAge + ".");
                iterator.remove();
            }
        }
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public void saveData() {
        try {
            FileOutputStream fileOut = new FileOutputStream("zoo.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("Zoo has been saved.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public void loadData() {
        try {
            FileInputStream fileIn = new FileInputStream("zoo.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Zoo zoo = (Zoo) in.readObject();
            this.setName(zoo.getName());
            this.setManager(zoo.getManager());
            this.setAnimals(zoo.getAnimals());
            in.close();
            fileIn.close();
            System.out.println("Zoo has been loaded from a file.");
        } catch (IOException e) {
            System.out.println("File not found.");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}