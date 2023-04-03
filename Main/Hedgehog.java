package Main;

public class Hedgehog extends Animal {

    private int spikes;

    public Hedgehog(String name, int age, int spikes) {
        super(name, age);
        this.spikes = spikes;
    }

    public void jump() {
        System.out.println("Hedgehog is jumping!");
    }

    public void land() {
        System.out.println("Hedgehog is landing!");
    }
    public String getSpecies() {
        return "Hedgehog";
    }
    @Override
    public String toString() {
        int ageHumanYears = super.getAge() * 20;
        return "The Hedgehog " + super.getName() + " is " + super.getAge() + " years old (" + ageHumanYears + " in human years) and has " + spikes + " spikes.";
    }

}
