package se.lexicon.data;

import se.lexicon.model.Course;
import se.lexicon.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;


public class CourseDaoImpl implements ICourseDao{

    //fields
    private ArrayList<Course> courses = new ArrayList<>();

   //methods
    @Override
    public Course save(Course course) {
        validateInput(course, "Save course input");
        this.courses.add(course);
        return course;
    }

    @Override
    public Course findById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Course> findByName(String name) {
        ArrayList<Course> matchingCourses = new ArrayList<>();
        for(Course course: courses){
            if (course.getCourseName().toLowerCase().contains(name.toLowerCase())){
                matchingCourses.add(course);
            }
        }
        return matchingCourses;
    }

    @Override
    public ArrayList<Course> findByDate(LocalDate date) {
        ArrayList<Course> matchingCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.getStartDate().isEqual(date)) {
                matchingCourses.add(course);
            }
        }
        return matchingCourses;
    }

    @Override
    public ArrayList<Course> findAll() {
        return courses;
    }

    @Override
    public boolean delete(Course course) {
        return this.courses.remove(course);
    }

    private static void validateInput(Course input, String inputName) {
        if(input == null) throw new IllegalArgumentException(inputName + " can't be null");
    }
}
