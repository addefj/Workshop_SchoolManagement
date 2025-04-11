package se.lexicon.data;

import se.lexicon.model.Student;

import java.util.ArrayList;


public class StudentDaoImpl implements IStudentDao{

    //fields
    private ArrayList<Student> students = new ArrayList<>();

    //methods
    @Override
    public Student save(Student student) {
        validateInput(student, "Save student input");
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
            if (student.getName().toLowerCase().contains(name.toLowerCase())){
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

    private static void validateInput(Student input, String inputName) {
        if(input == null) throw new IllegalArgumentException(inputName + " can't be null");
    }

}
