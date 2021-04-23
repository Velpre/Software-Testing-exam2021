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


    /***********************************************  Requirement 1A ********************************************/

    //Testing if a diet has any non-vegan foods. If it does the diet cannot be vegan -> isVegan = false.
    @Test
    public void testIfAnyNonVeganFoodsLowCarb(){

            ArrayList<Food> allowed = new ArrayList<>();
            allowed.add(new Food("Beef", 100, false, FoodType.PROTEIN));
            allowed.add(new Food("Potato", 100, true, FoodType.PROTEIN));
            allowed.add(new Food("Beans", 100, true, FoodType.PROTEIN));
            allowed.add(new Food("Chicken", 100, false, FoodType.PROTEIN));
            allowed.add(new Food("Milk", 100, false, FoodType.PROTEIN));

            // isVegan = true
            LowCarbDiet diet1 = new LowCarbDiet(100, "reduce the ingestion of carbs", allowed, true, 90.5f);
            Assert.assertFalse(diet1.isVegan());

    }
    @Test
    public void testIfAnyNonVeganFoodsFlex(){

            ArrayList<Food> allowed = new ArrayList<>();
            allowed.add(new Food("Beef", 100, false, FoodType.PROTEIN));
            allowed.add(new Food("Potato", 100, true, FoodType.PROTEIN));
            allowed.add(new Food("Beans", 100, true, FoodType.PROTEIN));
            allowed.add(new Food("Chicken", 100, false, FoodType.PROTEIN));
            allowed.add(new Food("Milk", 100, false, FoodType.PROTEIN));

            // isVegan = true
            HypercaloricDiet diet1 = new HypercaloricDiet(100, "reduce the ingestion of carbs", allowed, true, 90.0f,60.0f );
            Assert.assertFalse(diet1.isVegan());
    }

    //Testing with a empty allowedFood-array. This should not be allowed
    @Test
    public void testIfOnlyNonVeganFoods() {
        try {
            ArrayList<Food> allowed = new ArrayList<>();
            VeganDiet diet1 = new VeganDiet(100, "Eat vegan", allowed, true, 90.5f);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Need something in allowed food", e.getMessage());
            System.out.println(e.getMessage());
        }
    }
    /***********************************************  Requirement 1B ********************************************/


    //Testing if allowedFood is only vegan, the diet becomes vegan.
    @Test
    public void testOnlyVeganFood(){
        ArrayList<Food> allowed = new ArrayList<>();
        allowed.add(new Food("Tomato", 100, true, FoodType.CARB));
        allowed.add(new Food("Potato", 100, true, FoodType.PROTEIN));
        allowed.add(new Food("Beans", 100, true, FoodType.PROTEIN));
        allowed.add(new Food("Peas", 100, true, FoodType.PROTEIN));
        allowed.add(new Food("Tofu", 100, true, FoodType.PROTEIN));

        LowCarbDiet diet1 = new LowCarbDiet(100, "dont eat calories",allowed,false,90.4f);

        Assert.assertTrue(diet1.isVegan());
    }

    /***********************************************  Requirement 1C ********************************************/
    /*
    This test is done in VeganDietTest.java
     */

    /***********************************************  Requirement 1D ********************************************/
    /*
    This test is done in FlexitarianDietTest.java
     */

    /***********************************************  Requirement 1E ********************************************/
    /*
    This test is done in LowCarbDietTest.java
     */


    /***********************************************  Requirement 3A ********************************************/

    //Testing writeDuration with 2 days, 0 months and 0 years.
    @Test
    public void testWriteDuration(){
        ArrayList<Food> allowLowCarbFood = new ArrayList<>();
        allowLowCarbFood.add( new Food("Beaf",20,false,FoodType.PROTEIN));
        LowCarbDiet diet1 = new LowCarbDiet(2,"get beef", allowLowCarbFood,false,100 );
        Assert.assertEquals("This diet lasts for 0 years, 0 months and 2 days", diet1.writeDuration());
    }

    //Testing writeDuration more than a year
    @Test
    public void testWriteDurationOverAYear(){
        ArrayList<Food> allowLowCarbFood = new ArrayList<>();
        allowLowCarbFood.add( new Food("Beaf",20,false,FoodType.PROTEIN));
        LowCarbDiet diet1 = new LowCarbDiet(370,"get beef", allowLowCarbFood,false,100 );

        Assert.assertEquals("This diet lasts for 1 years, 0 months and 5 days", diet1.writeDuration());
    }

    //Testing writeDuration with more than a month
    @Test
    public void testWriteDurationOverAMonth(){
        ArrayList<Food> allowLowCarbFood = new ArrayList<>();
        allowLowCarbFood.add( new Food("Beaf",20,false,FoodType.PROTEIN));
        LowCarbDiet diet1 = new LowCarbDiet(35,"get beef", allowLowCarbFood,false,100 );
        Assert.assertEquals("This diet lasts for 0 years, 1 months and 5 days", diet1.writeDuration());
    }

    /***********************************************  Requirement 3B ********************************************/
    //Testing method writeAllowedFood
    @Test
    public void testWriteAllowedFood(){
        ArrayList<Food> allowedFoodList = new ArrayList<>();

        allowedFoodList.add(new Food("egg",100, false,FoodType.PROTEIN));
        allowedFoodList.add(new Food("Salmon",100, false,FoodType.PROTEIN));
        allowedFoodList.add(new Food("Chicken",100, false,FoodType.PROTEIN));
        allowedFoodList.add(new Food("Pork",100, false,FoodType.PROTEIN));

        LowCarbDiet diet1 = new LowCarbDiet(35,"get beef", allowedFoodList,false,100 );
        Assert.assertEquals("The following food is allowed in this diet: egg, Salmon, Chicken, Pork. ", diet1.writeAllowedFood());
    }


}
