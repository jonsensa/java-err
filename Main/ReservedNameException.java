package Main;

public class ReservedNameException extends Exception {

    private String name;

    public ReservedNameException(String name) {
        this.name = name;
    }

    public String getMessage() {
        return "The name " + name + " is reserved.";
    }

}
