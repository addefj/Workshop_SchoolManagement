package se.lexicon;

import se.lexicon.data.CourseDaoImpl;
import se.lexicon.data.StudentDaoImpl;
import se.lexicon.model.Course;
import se.lexicon.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Johan Larsson", "johan@xyz.se", "malungsvägen");
        Student student2 = new Student( "Karl Bolton", "karl@xyz.se", "uddavägen");
        Student student3 = new Student( "Karl Kula", "karl@xyz.se", "uddavägen");
        Student student4 = new Student( "Johan Magnusson", "johan@xyz.se", "uddavägen");

        Course course1 = new Course("Math A", LocalDate.parse("2025-05-10"), 5 );
        Course course2 = new Course("Physics A", LocalDate.parse("2025-06-20"), 15 );
        Course course3 = new Course("English A", LocalDate.parse("2025-09-25"), 11 );
        Course course4 = new Course("Chemistry A", LocalDate.parse("2025-09-25"), 10 );

        StudentDaoImpl studentList = new StudentDaoImpl();
        CourseDaoImpl courseList = new CourseDaoImpl();

        course2.register(student1);
        course2.register(student2);
        course3.register(student1);
        course3.register(student4);

        studentList.save(student1);
        studentList.save(student2);
        studentList.save(student3);
        studentList.save(student4);

        courseList.save(course1);
        courseList.save(course2);
        courseList.save(course3);
        courseList.save(course4);

        System.out.println(courseList.findAll());
        System.out.println("------------");
        System.out.println(courseList.findByName("chemistry"));
        System.out.println("------------");
        System.out.println(courseList.findById(2));
        System.out.println("------------");
        System.out.println(courseList.findByDate(LocalDate.parse("2025-06-20")));
        System.out.println("------------");
        System.out.println(courseList.delete(course4));
        System.out.println("------------");
        System.out.println(courseList.findAll());







    }
}




