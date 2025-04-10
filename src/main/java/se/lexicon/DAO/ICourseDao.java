package se.lexicon.DAO;

import se.lexicon.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;

public interface ICourseDao {

    Course save(Course course);

    Course findById(int id);

    ArrayList<Course> findByName(String name);

    ArrayList<Course> findByDate(LocalDate date);

    ArrayList<Course> findAll();

    boolean delete(Course course);

}
