package se.lexicon;

import se.lexicon.model.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Student newStudent = new Student(1, "Johan", "johan@xyz.se", "malungsvägen");
        Student newStudent2 = new Student(2, "Karl", "karl@xyz.se", "malungsvägen");

        ArrayList<Student> students = new ArrayList<>();
        students.add(newStudent);
        students.add(newStudent2);


        for (Student student : students) {
            if (student.getEmail().equals("johan@xyz.se")) {
                System.out.println(student);
            }
        }

    }
}




