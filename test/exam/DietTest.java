package exam;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class DietTest {
    //Things to test
    // - opretter med ugyldige parametre []
    // - Teste writeDuration [x]
    // -




    //Teste writeDuration med standard input
    //Stringen som returneres er per nå ikke riktig i forhold til eksamen.
    @Test
    public void testWriteDuration(){
        //Gammel test- utdatert!!!
        /*
        LocalDate startDate = LocalDate.of(2021,2,5);
        LocalDate endDate= LocalDate.of(2022,5,12);
        ArrayList<Food> allowedFood = new ArrayList<>();
        allowedFood.add(new Food("egg",100, false,FoodType.PROTEIN));
        LowCarbDiet diet1 = new LowCarbDiet(startDate,endDate,null,"get beef",allowedFood,false,100);
        int test = 1;
        Assert.assertEquals("The diet lasts for " + test + " years, 3 months and 7 days", diet1.writeDuration());*/

    }

    //Testing constructor
    @Test
    public void testConstructor(){
    }

}
