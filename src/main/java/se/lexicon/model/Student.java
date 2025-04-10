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
        this.name = name;
        this.email = email;
        this.address = address;
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
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", name: " + name + ", email: " + email + ", address: " + address + "\n";
    }
}
