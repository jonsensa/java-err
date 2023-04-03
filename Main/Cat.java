package Main;

public class Cat extends Animal {

    private String color;

    public Cat(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }

    public void jump() {
        System.out.println("Cat is jumping!");
    }

    public void land() {
        System.out.println("Cat is landing!");
    }

    public void doNastyThings() {
        System.out.println("...and doing nasty things...");
    }

    public String getSpecies() {
        return "Lion";
    }
    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        int ageHumanYears = super.getAge() * 6;
        return "The " + getColor() + " Cat " + getName() + " is " + getAge() + " years old (" + ageHumanYears + " in human years).";
    }
}
