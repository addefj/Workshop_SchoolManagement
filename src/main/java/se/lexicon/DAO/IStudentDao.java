package se.lexicon.DAO;

import se.lexicon.model.Student;

import java.util.ArrayList;

public interface IStudentDao {

    Student save(Student student);

    Student findByEmail(String email);

    ArrayList<Student> findByName(String name);

    Student findById(int id);

    ArrayList<Student> findAll();

    boolean deleter(Student student);


}
