package se.lexicon.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CourseTest {

    //setCourseName method
    @Test
    @DisplayName("set correct course name")
    public void TestSetCourseName(){

        Course course = new Course();
        course.setCourseName("Physics A");

        assertEquals("Physics A", course.getCourseName());
    }

    @Test
    @DisplayName("set course name to null")
    public void testSetCourseNameNull(){

        Course course = new Course();

        assertThrows(IllegalArgumentException.class,
                () -> {
                    course.setCourseName(null);
                });
    }

    @Test
    @DisplayName("set course name empty")
    public void testSetCourseNameEmpty(){

        Course course = new Course();

        assertThrows(IllegalArgumentException.class,
                () -> {
                    course.setCourseName("");
                });
    }

    //setWeekDuration method
    @Test
    @DisplayName("set a correct week duration")
    public void TestSetWeekDurationCorrect(){

        Course course = new Course();
        course.setWeekDuration(10);

        assertEquals(10, course.getWeekDuration());
    }

    @Test
    @DisplayName("set week duration to 0")
    public void TestSetWeekDurationToZero(){

        Course course = new Course();
        course.setWeekDuration(0);

        assertEquals(0, course.getWeekDuration());
    }

    @Test
    @DisplayName("set week duration to a negative number")
    public void TestSetWeekDurationToNegative(){

        Course course = new Course();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    course.setWeekDuration(-1);
                });
    }

    //setStartDate method
    @Test
    @DisplayName("set a correct course start date")
    public void TestSetStartDateCorrect(){

        Course course = new Course();
        course.setStartDate(LocalDate.parse("2025-09-20"));

        assertEquals(LocalDate.parse("2025-09-20"), course.getStartDate());
    }

    @Test
    @DisplayName("set start date today")
    public void TestSetStartDateToday(){

        Course course = new Course();
        course.setStartDate(LocalDate.now());

        assertEquals(LocalDate.now(), course.getStartDate());
    }

    @Test
    @DisplayName("set start date yesterday")
    public void TestSetStartDateYesterday(){

        Course course = new Course();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    course.setStartDate(LocalDate.now().minusDays(1));
                });
    }

    @Test
    @DisplayName("set start date to null")
    public void TestSetStartDateNull(){

        Course course = new Course();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    course.setStartDate(null);
                });
    }

    //register method
    @Test
    @DisplayName("register null")
    public void TestRegisterNull(){

        Course course = new Course();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    course.register(null);
                });
    }

    //unregister method
    @Test
    @DisplayName("unregister null")
    public void TestUnRegisterNull(){

        Course course = new Course();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    course.unregister(null);
                });
    }
}
