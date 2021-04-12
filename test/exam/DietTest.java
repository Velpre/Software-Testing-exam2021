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


    //Testing writeDuration with 2 days, 0 months and 0 years.
    @Test
    public void testWriteDuration(){
        LowCarbDiet diet1 = new LowCarbDiet(2,"get beef", null,false,100 );
        Assert.assertEquals("This diet lasts for 0 years, 0 months and 2 days", diet1.writeDuration());
    }

    //Testing writeDuration more than a year
    @Test
    public void testWriteDurationOverAYear(){
        LowCarbDiet diet1 = new LowCarbDiet(370,"get beef", null,false,100 );
        Assert.assertEquals("This diet lasts for 1 years, 0 months and 5 days", diet1.writeDuration());
    }

    //Testing writeDuration with more than a month
    @Test
    public void testWriteDurationOverAMonth(){
        LowCarbDiet diet1 = new LowCarbDiet(35,"get beef", null,false,100 );
        Assert.assertEquals("This diet lasts for 0 years, 1 months and 5 days", diet1.writeDuration());
    }


    //Testing method writeAllowedFood
    @Test
    public void testWriteAllowedFood(){
        ArrayList<Food> allowedFoodList = new ArrayList<>();

        allowedFoodList.add(new Food("egg",100, false,FoodType.PROTEIN));
        allowedFoodList.add(new Food("Salmon",100, false,FoodType.PROTEIN));
        allowedFoodList.add(new Food("Chicken",100, false,FoodType.PROTEIN));
        allowedFoodList.add(new Food("Pork",100, false,FoodType.PROTEIN));

        LowCarbDiet diet1 = new LowCarbDiet(35,"get beef", allowedFoodList,false,100 );
        Assert.assertEquals("The following food is allowed in this diet: egg, Salmon, Chicken, Pork, ", diet1.writeAllowedFood());
    }



























    //Teste writeDuration med standard input
    //Stringen som returneres er per nå ikke riktig i forhold til eksamen.
    @Test
    public void testWriteDurationOld(){
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
