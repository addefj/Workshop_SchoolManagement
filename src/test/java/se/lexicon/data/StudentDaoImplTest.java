package se.lexicon.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.lexicon.model.Student;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentDaoImplTest {

    //save method
    @Test
    void saveStudent() {
        StudentDaoImpl students = new StudentDaoImpl();
        Student student = new Student();
        students.save(student);
        assertEquals(student, students.findById(1));
    }

    @Test
    void saveNull() {
        StudentDaoImpl students = new StudentDaoImpl();
        Student student = new Student();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    students.save(null);
                });
    }

    //findByEmail method
    @Test
    void findByEmail() {
        StudentDaoImpl students = new StudentDaoImpl();
        Student testStudent = new Student();
        testStudent.setEmail("test@test.se");
        students.save(testStudent);
        assertEquals(testStudent, students.findByEmail("test@test.se") );
    }

    //find by name method
    @Test
    void findByNameFirstNameLowerCase() {
        StudentDaoImpl students = new StudentDaoImpl();
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        s1.setName("Markus Nilsson");
        s2.setName("Markus Olsson");
        s3.setName("Alice Hult");

        students.save(s1);
        students.save(s2);
        students.save(s3);

        ArrayList<Student> result = students.findByName("markus");
        assertEquals(2, result.size());
        assertTrue(result.contains(s1));
        assertTrue(result.contains(s2));
        assertFalse(result.contains(s3));
    }

    @Test
    void findByNameLastNameUpperCase() {
        StudentDaoImpl students = new StudentDaoImpl();
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        s1.setName("Ola Salo");
        s2.setName("Morgan Alling");
        s3.setName("Alice Hult");

        students.save(s1);
        students.save(s2);
        students.save(s3);

        ArrayList<Student> result = students.findByName("ALLING");
        assertEquals(1, result.size());
        assertTrue(result.contains(s2));
        assertFalse(result.contains(s1));
        assertFalse(result.contains(s3));
    }

    @Test
    void findByNameWronglySpelled() {
        StudentDaoImpl students = new StudentDaoImpl();
        Student s1 = new Student();
        s1.setName("Ola Salo");
        students.save(s1);

        ArrayList<Student> result = students.findByName("Sallo");
        assertEquals(0, result.size());
    }

    @Test
    void findById() {
        StudentDaoImpl students = new StudentDaoImpl();
        Student s1 = new Student();
        Student s2 = new Student();
        students.save(s1);
        students.save(s2);
        assertEquals(s2, students.findById(2));
    }

    @Test
    void findAll() {
        StudentDaoImpl students = new StudentDaoImpl();
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        students.save(s1);
        students.save(s2);
        students.save(s3);

        ArrayList<Student> result = students.findAll();
        assertEquals(3, result.size());
        assertTrue(result.contains(s1));
        assertTrue(result.contains(s2));
        assertTrue(result.contains(s3));
    }

    @Test
    void deleteStudentFromStudentList() {
        StudentDaoImpl students = new StudentDaoImpl();
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        Student s4 = new Student();
        students.save(s1);
        students.save(s2);
        students.save(s3);

        assertFalse(students.delete(s4));
        assertTrue(students.delete(s1));
        assertTrue(students.delete(s2));
        assertTrue(students.delete(s3));
        ArrayList<Student> result = students.findAll();
        assertEquals(0, result.size());
    }
}