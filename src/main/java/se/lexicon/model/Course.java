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
        setCourseName(courseName);
        setStartDate(startDate);
        setWeekDuration(weekDuration);
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
        validateInput(startDate, "Course start");
        this.startDate = startDate;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        validateInput(courseName, "Course Name");
        this.courseName = courseName;
    }

    public int getWeekDuration() {
        return weekDuration;
    }

    public void setWeekDuration(int weekDuration) {
        validateInput(weekDuration, "Week duration");
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

    private static void validateInput(String input, String inputName) {
        if(input == null || input.trim().isEmpty()) throw new IllegalArgumentException(inputName + " can't be null or empty");
    }

    private static void validateInput(LocalDate input, String inputName) {
        if(input == null) throw new IllegalArgumentException(inputName + " can't be null");
        if(input.isBefore(LocalDate.now())) throw new IllegalArgumentException(inputName + " can't be before today");
    }

    private static void validateInput(int input, String inputName) {
        if(input < 0) throw new IllegalArgumentException(inputName + " can't be less than zero");
    }


}
