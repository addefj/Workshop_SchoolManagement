package se.lexicon.data;

import se.lexicon.model.Student;

import java.util.ArrayList;


public class StudentDaoImpl implements IStudentDao{

    //fields
    private ArrayList<Student> students = new ArrayList<>();

    //methods
    @Override
    public Student save(Student student) {
        this.students.add(student);
        return student;
    }

    @Override
    public Student findByEmail(String email) {
        for (Student student : students) {
            if (student.getEmail().equals(email)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Student> findByName(String name) {
        ArrayList<Student> matchingStudents = new ArrayList<>();
        for (Student student: students){
            if (student.getName().equals(name)){
                matchingStudents.add(student);
            }
        }
        return matchingStudents;
    }

    @Override
    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Student> findAll() {
        return students;
    }

    @Override
    public boolean delete(Student student) {
        return this.students.remove(student);
    }
}
