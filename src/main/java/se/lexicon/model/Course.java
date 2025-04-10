package se.lexicon.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Course {

    //fields
    private static int sequencer;
    private final int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private ArrayList<Student> students = new ArrayList<>();

    //constructor
    public Course(String courseName, LocalDate startDate, int weekDuration) {
        this.id = getNextId();
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public int getNextId(){
        return ++sequencer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        this.weekDuration = weekDuration;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    //other methods
    public void register(Student student){
        this.students.add(student);
    }

    public void unregister(Student student){
        this.students.remove(student);
    }

    @Override
    public String toString() {
        return "id: " + id + ", courseName: " + courseName +
                ", startDate: " + startDate +
                ", weekDuration: " + weekDuration +
                ", students: " + students + "\n";
    }
}
