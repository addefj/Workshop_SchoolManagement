package se.lexicon.data;

import org.junit.jupiter.api.Test;
import se.lexicon.model.Course;
import se.lexicon.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CourseDaoImplTest {

    //save method
    @Test
    void saveCourse() {
        CourseDaoImpl courses = new CourseDaoImpl();
        Course c1 = new Course();
        courses.save(c1);
        assertEquals(c1, courses.findById(1));
    }

    @Test
    void saveNull() {
        CourseDaoImpl courses = new CourseDaoImpl();
        Course c1 = new Course();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    courses.save(null);
                });
    }


    @Test
    void findById() {
        CourseDaoImpl courses = new CourseDaoImpl();
        Course c1 = new Course();
        Course c2 = new Course();
        courses.save(c1);
        courses.save(c2);
        assertEquals(c2, courses.findById(2));
    }

    //find by name method
    @Test
    void findByNameLowerCase() {
        CourseDaoImpl courses = new CourseDaoImpl();
        Course c1 = new Course();
        Course c2 = new Course();
        Course c3 = new Course();
        c1.setCourseName("Math A");
        c2.setCourseName("Math B");
        c3.setCourseName("Physics C");

        courses.save(c1);
        courses.save(c2);
        courses.save(c3);

        ArrayList<Course> result = courses.findByName("math");
        assertEquals(2, result.size());
        assertTrue(result.contains(c1));
        assertTrue(result.contains(c2));
        assertFalse(result.contains(c3));
    }

    @Test
    void findByNameUpperCase() {
        CourseDaoImpl courses = new CourseDaoImpl();
        Course c1 = new Course();
        Course c2 = new Course();
        Course c3 = new Course();
        c1.setCourseName("Math A");
        c2.setCourseName("Math B");
        c3.setCourseName("Physics C");

        courses.save(c1);
        courses.save(c2);
        courses.save(c3);

        ArrayList<Course> result = courses.findByName("MATH");
        assertEquals(2, result.size());
        assertTrue(result.contains(c1));
        assertTrue(result.contains(c2));
        assertFalse(result.contains(c3));
    }

    @Test
    void findByNameWronglySpelled() {
        CourseDaoImpl courses = new CourseDaoImpl();
        Course c1 = new Course();
        c1.setCourseName("Physics A");
        courses.save(c1);

        ArrayList<Course> result = courses.findByName("Pyhsics A");
        assertEquals(0, result.size());
    }

    @Test
    void findByDate() {
        CourseDaoImpl courses = new CourseDaoImpl();
        Course c1 = new Course();
        Course c2 = new Course();
        Course c3 = new Course();

        c1.setStartDate(LocalDate.now());
        c2.setStartDate(LocalDate.now().plusDays(2));
        c3.setStartDate(LocalDate.now());

        courses.save(c1);
        courses.save(c2);
        courses.save(c3);

        ArrayList<Course> result = courses.findByDate(LocalDate.now());
        assertEquals(2, result.size());
        assertTrue(result.contains(c1));
        assertTrue(result.contains(c3));
        assertFalse(result.contains(c2));
    }

    @Test
    void findAll() {
        CourseDaoImpl courses = new CourseDaoImpl();
        Course c1 = new Course();
        Course c2 = new Course();
        Course c3 = new Course();

        courses.save(c1);
        courses.save(c2);

        ArrayList<Course> result = courses.findAll();
        assertEquals(2, result.size());
        assertTrue(result.contains(c1));
        assertTrue(result.contains(c2));
    }


    @Test
    void deleteCourseFromCourseList() {
        CourseDaoImpl courses = new CourseDaoImpl();
        Course c1 = new Course();
        Course c2 = new Course();
        Course c3 = new Course();
        Course c4 = new Course();

        courses.save(c1);
        courses.save(c2);
        courses.save(c3);

        assertFalse(courses.delete(c4));
        assertTrue(courses.delete(c1));
        assertTrue(courses.delete(c2));;

        ArrayList<Course> result = courses.findAll();
        assertEquals(1, result.size());
    }
}