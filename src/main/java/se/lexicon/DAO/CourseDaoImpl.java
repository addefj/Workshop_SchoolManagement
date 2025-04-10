package se.lexicon.DAO;

import se.lexicon.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;

public class CourseDaoImpl implements ICourseDao{
    @Override
    public Course save(Course course) {
        return null;
    }

    @Override
    public Course findById(int id) {
        return null;
    }

    @Override
    public ArrayList<Course> findByName(String name) {
        return null;
    }

    @Override
    public ArrayList<Course> findByDate(LocalDate date) {
        return null;
    }

    @Override
    public ArrayList<Course> findAll() {
        return null;
    }

    @Override
    public boolean delete(Course course) {
        return false;
    }
}
