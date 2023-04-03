package Main;

public class Lion extends Animal {

    public Lion(String name, int age) {
        super(name, age);
    }

    public void jump() {
        System.out.println("Lion is jumping!");
    }

    public void land() {
        System.out.println("Lion is landing!");
    }

    @Override
    public String getSpecies() {
        return "Lion";
    }

    @Override
    public String toString() {
        int ageHumanYears = super.getAge() * 2;
        return super.toString();
    }
}
