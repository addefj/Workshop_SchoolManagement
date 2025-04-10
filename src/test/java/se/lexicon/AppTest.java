package se.lexicon;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AppTest {


    @Test
    @DisplayName("Array with 3 names")
    public void getSizeThreeNames(){

        //scenario 2
        //3 names in the array
        String[] newNames = {"Kalle Kula","Ola Conny","Morgan Alling"};
        NameRepository.setNames(newNames);

        //Expected
        int expected = 3;

        //actual
        int actual = NameRepository.getSize();

        //verify the result
        Assertions.assertEquals(expected, actual);
    }


}
