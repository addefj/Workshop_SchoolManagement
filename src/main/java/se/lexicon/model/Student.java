package se.lexicon.model;

public class Student {

    //fields
    private static int sequencer;
    private final int id;
    private String name;
    private String email;
    private String address;

    //constructor
    public Student(String name, String email, String address) {
        this.id = getNextId();
        setName(name);
        setEmail(email);
        setAddress(address);
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public int getNextId(){
        return ++sequencer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateInput(name, "Student Name");
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validateInput(email, "Email");
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        validateInput(address, "Address");
        this.address = address;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", name: " + name + ", email: " + email + ", address: " + address + "\n";

    }

    private static void validateInput(String input, String inputName) {
        if(input == null || input.isEmpty()) throw new IllegalArgumentException(inputName + " can't be null or empty");
    }
}
