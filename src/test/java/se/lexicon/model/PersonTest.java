package se.lexicon.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    //setName method
    @Test
    @DisplayName("test with correct name")
    public void TestSetName(){

        Student student = new Student();
        student.setName("Alice");

        assertEquals("Alice", student.getName());
    }

    @Test
    @DisplayName("set student name to null")
    public void testSetNameNull(){

        Student student = new Student();

        assertThrows(IllegalArgumentException.class,
                () -> {
                    student.setName(null);
                });
    }

    @Test
    @DisplayName("set student name empty")
    public void testSetNameEmpty(){

        Student student = new Student();

        assertThrows(IllegalArgumentException.class,
                () -> {
                    student.setName("");
                });
    }

    //setEmail method
    @Test
    @DisplayName("test with correct email")
    public void TestSetEmail(){

        Student student = new Student();
        student.setEmail("ola@test.se");

        assertEquals("ola@test.se", student.getEmail());
    }

    @Test
    @DisplayName("set student email to null")
    public void testSetEmailNull(){

        Student student = new Student();

        assertThrows(IllegalArgumentException.class,
                () -> {
                    student.setEmail(null);
                });
    }

    @Test
    @DisplayName("set email to empty")
    public void testSetEmailEmpty(){

        Student student = new Student();

        assertThrows(IllegalArgumentException.class,
                () -> {
                    student.setEmail("");
                });
    }

    //setAddress method
    @Test
    @DisplayName("test with correct address")
    public void TestSetAddress(){

        Student student = new Student();
        student.setAddress("Testgatan 7");

        assertEquals("Testgatan 7", student.getAddress());
    }

    @Test
    @DisplayName("set student address to null")
    public void testSetAddressNull(){

        Student student = new Student();

        assertThrows(IllegalArgumentException.class,
                () -> {
                    student.setAddress(null);
                });
    }

    @Test
    @DisplayName("set address to empty")
    public void testSetAddressEmpty(){

        Student student = new Student();

        assertThrows(IllegalArgumentException.class,
                () -> {
                    student.setAddress("");
                });
    }

    //test getNextId()
    @Test
    @DisplayName("test getNextId()")
    public void testGetNextId(){

        Student student = new Student(); //id 1

        assertEquals(2, student.getNextId());
    }
}
