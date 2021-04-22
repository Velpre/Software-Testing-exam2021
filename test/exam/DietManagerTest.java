package exam;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static exam.DietManager.areCompatible;
import static exam.DietManager.randomDiet;

public class DietManagerTest {

    // Testing the Diet-Manager
    /********* Req 4a:Given a Person and a Diet, return true if they are compatible, false otherwise.*********/

    // testing a person who is allergic to the allowedFood list
    @Test
    public void testingTooManyAllergies(){

        ArrayList<Food> allowedFood = new ArrayList<>();
        Food egg = new Food("egg", 100, false, FoodType.PROTEIN);
        Food beef = new Food("Beef", 100, false, FoodType.PROTEIN);
        Food Chicken = new Food("Chicken", 100, false, FoodType.PROTEIN);
        Food Milk = new Food("Milk", 100, false, FoodType.PROTEIN);
        Food Soy = new Food("Soy", 100, false, FoodType.PROTEIN);
        Food Beans = new Food("Beans", 100, false, FoodType.PROTEIN);
        Food Flour = new Food("Flour", 100, false, FoodType.PROTEIN);
        Food Shrimp = new Food("Shrimp", 100, false, FoodType.PROTEIN);
        allowedFood.add(egg);
        allowedFood.add(beef);
        allowedFood.add(Chicken);
        allowedFood.add(Milk);
        allowedFood.add(Soy);
        allowedFood.add(Beans);
        allowedFood.add(Flour);
        allowedFood.add(Shrimp);

        ArrayList<Food> allergies = new ArrayList<>();
        allergies.add(Soy);
        allergies.add(Milk);
        allergies.add(Shrimp);
        allergies.add(Flour);


        // creating new diet for the test.
        Person person1 = new Person(beef, allergies, null, 100);
        LowCarbDiet diet2 = new LowCarbDiet(100,"eat less carbs",allowedFood,false,80);

        Assert.assertFalse(areCompatible(person1,diet2));
    }

    //  a none-vegan person cannot follow a vegan diet.
    @Test
    public void testNonVeganPersonWithVeganDiet(){
        ArrayList<Food> allergies = new ArrayList<>();

        // Food and allergies
        Food egg = new Food("egg", 100, false, FoodType.PROTEIN);
        Food Milk = new Food("Milk", 100, false, FoodType.PROTEIN);
        allergies.add(egg);
        allergies.add(Milk);
        Food beef = new Food("Beef",100, false,FoodType.PROTEIN);
        
        Person person1 = new Person(beef,allergies,null,90.0f);

        // --------- new diet to test.
        ArrayList<Food> allowed = new ArrayList<>();
        Food peas = new Food("Peas",100, true,FoodType.PROTEIN);
        Food pasta = new Food("Pasta", 30, true, FoodType.CARB);
        allowed.add(pasta);
        allowed.add(peas);
        VeganDiet diet2 = new VeganDiet(100,"Eat vegan save the world",allowed,true,80.0f);

        Assert.assertFalse(areCompatible(person1,diet2));
    }
    // Testing weight for Vegan Diet
    @Test
    public void testPersonUnderMinWeightForVeganDiet(){
        // allergies person1
        ArrayList<Food> allergies = new ArrayList<>();
        Food egg = new Food("egg", 100, false, FoodType.PROTEIN);
        Food Milk = new Food("Milk", 100, false, FoodType.PROTEIN);
        allergies.add(egg);
        allergies.add(Milk);

        // --------- new diet to test.
        ArrayList<Food> allowed2 = new ArrayList<>();
        Food peas = new Food("Peas",100, true,FoodType.PROTEIN);
        Food pasta = new Food("Pasta", 30, true, FoodType.CARB);
        allowed2.add(pasta);
        allowed2.add(peas);
        VeganDiet diet2 = new VeganDiet(100,"Eat vegan save the world",allowed2,true,80.0f);
        Person person1 = new Person(peas,allergies,null,70.0f);
        Assert.assertFalse(areCompatible(person1,diet2));

    }

    // Testing weight for LowCarb Diet
    @Test
    public void testPersonUnderMinWeightForLowCarbDiet(){
        // allergies person1
        ArrayList<Food> allergies = new ArrayList<>();
        Food egg = new Food("egg", 100, false, FoodType.PROTEIN);
        Food Milk = new Food("Milk", 100, false, FoodType.PROTEIN);
        allergies.add(egg);
        allergies.add(Milk);

        // --------- new diet to test.
        ArrayList<Food> allowed2 = new ArrayList<>();
        Food peas = new Food("Peas",100, true,FoodType.PROTEIN);
        Food pasta = new Food("Pasta", 30, true, FoodType.CARB);
        allowed2.add(pasta);
        allowed2.add(peas);
        LowCarbDiet diet2 = new LowCarbDiet(100,"Eat vegan save the world",allowed2,true,80.0f);
        Person person1 = new Person(peas,allergies,null,70.0f);
        Assert.assertFalse(areCompatible(person1,diet2));
    }
    // Testing weight for Hypercaloric Diet
    @Test
    public void testPersonOverMaxWeightForHypercaloricDiet(){

        // allergies person1
        ArrayList<Food> allergies = new ArrayList<>();
        Food egg = new Food("egg", 100, false, FoodType.PROTEIN);
        Food Milk = new Food("Milk", 100, false, FoodType.PROTEIN);
        allergies.add(egg);
        allergies.add(Milk);

        // --------- new diet to test.
        ArrayList<Food> allowed2 = new ArrayList<>();
        Food peas = new Food("Peas",100, true,FoodType.PROTEIN);
        Food pasta = new Food("Pasta", 30, true, FoodType.CARB);
        allowed2.add(pasta);
        allowed2.add(peas);
        HypercaloricDiet diet2 = new HypercaloricDiet(100,"Eat vegan save the world",allowed2,true,80.0f,2000);
        Person person1 = new Person(peas,allergies,null,90.0f);
        Assert.assertFalse(areCompatible(person1,diet2));

    }
    //Test veganDiet
    @Test
    public void testCompatibleVeganDiet(){
        // allergies and food
        ArrayList<Food> allergies = new ArrayList<>();
        Food peas = new Food("Peas",100, true,FoodType.PROTEIN);
        Food pasta = new Food("Pasta", 30, true, FoodType.CARB);

        // --------- new diet to test.
        Person person1 = new Person(peas,allergies,null,90.0f);
        ArrayList<Food> allowed2 = new ArrayList<>();
        allowed2.add(pasta);
        allowed2.add(peas);
        VeganDiet diet2 = new VeganDiet(100,"Eat vegan save the world",allowed2,true,80.0f);
        Assert.assertTrue(areCompatible(person1,diet2));
    }

    /****************************************** REQ 4b************************************/

    //Testing daysDuration methode (Req 4b (I))

    @Test
    public void testDaysDuration(){

        ArrayList<Food> food = new ArrayList<>();
        Food peas = new Food("Peas",100, true,FoodType.PROTEIN);
        Food pasta = new Food("Pasta", 30, true, FoodType.CARB);
        food.add(peas);
        food.add(pasta);

        ArrayList<Food> allergies = new ArrayList<>();
        Food egg = new Food("egg", 100, false, FoodType.PROTEIN);
        Food Milk = new Food("Milk", 100, false, FoodType.PROTEIN);
        allergies.add(egg);
        allergies.add(Milk);

        Person person1 = new Person(pasta,allergies,null,70.0f);

        HypercaloricDiet randomHcd =  randomDiet(person1,food);

        Assert.assertTrue(randomHcd.getDaysDuration() <=100 && randomHcd.getDaysDuration() >=1);

    }

    //Testing that purpose message is correct. (Req 4b(II))

    @Test
    public void testPurposeMessage(){
        ArrayList<Food> food = new ArrayList<>();
        Food peas = new Food("Peas",100, true,FoodType.PROTEIN);
        Food pasta = new Food("Pasta", 30, true, FoodType.CARB);
        food.add(peas);
        food.add(pasta);


        ArrayList<Food> allergies = new ArrayList<>();
        Food egg = new Food("egg", 100, false, FoodType.PROTEIN);
        Food Milk = new Food("Milk", 100, false, FoodType.PROTEIN);
        allergies.add(egg);
        allergies.add(Milk);

        Person person1 = new Person(pasta,allergies,null,70.0f);
        HypercaloricDiet randomHcd =  randomDiet(person1,food);

        Assert.assertEquals("Random Hypercaloric Diet", randomHcd.getPurpose());
    }


    //Testing where some food are allergies (Req 4b (III))
    @Test
    public void testCreateAllowedFoodForAllergies(){

        ArrayList<Food> food = new ArrayList<>();
        Food egg = new Food("egg", 100, false, FoodType.PROTEIN);
        Food beef = new Food("Beef", 100, false, FoodType.PROTEIN);
        Food Chicken = new Food("Chicken", 100, false, FoodType.PROTEIN);
        Food Milk = new Food("Milk", 100, false, FoodType.PROTEIN);
        Food Soy = new Food("Soy", 100, false, FoodType.PROTEIN);
        Food Beans = new Food("Beans", 100, false, FoodType.PROTEIN);
        Food Flour = new Food("Flour", 100, false, FoodType.PROTEIN);
        Food Shrimp = new Food("Shrimp", 100, false, FoodType.PROTEIN);
        food.add(egg);
        food.add(beef);
        food.add(Chicken);
        food.add(Milk);
        food.add(Soy);
        food.add(Beans);
        food.add(Flour);
        food.add(Shrimp);

        ArrayList<Food> allergies = new ArrayList<>();
        allergies.add(Soy);
        allergies.add(Milk);
        allergies.add(Flour);

        Person person1 = new Person(egg,allergies,null,70.0f);

        HypercaloricDiet randomHcd =  randomDiet(person1,food);

        Assert.assertEquals(5,randomHcd.getAllowedFood().size() );
    }
    //Testing without allergies
    @Test
    public void testCreateAllowedFoodForAllergiesWithNullAllergies(){

        ArrayList<Food> food = new ArrayList<>();
        Food egg = new Food("egg", 100, false, FoodType.PROTEIN);
        Food beef = new Food("Beef", 100, false, FoodType.PROTEIN);
        Food Chicken = new Food("Chicken", 100, false, FoodType.PROTEIN);
        Food Milk = new Food("Milk", 100, false, FoodType.PROTEIN);
        Food Soy = new Food("Soy", 100, false, FoodType.PROTEIN);
        Food Beans = new Food("Beans", 100, false, FoodType.PROTEIN);
        Food Flour = new Food("Flour", 100, false, FoodType.PROTEIN);
        Food Shrimp = new Food("Shrimp", 100, false, FoodType.PROTEIN);
        food.add(egg);
        food.add(beef);
        food.add(Chicken);
        food.add(Milk);
        food.add(Soy);
        food.add(Beans);
        food.add(Flour);
        food.add(Shrimp);

        ArrayList<Food> allergies = new ArrayList<>();

        Person person1 = new Person(egg,allergies,null,70.0f);
        HypercaloricDiet randomHcd =  randomDiet(person1,food);
        Assert.assertEquals(8,randomHcd.getAllowedFood().size() );
    }

    //Testing with only allergies
    @Test
    public void testCreateAllowedFoodOnlyAllergies(){
        try{
            ArrayList<Food> food = new ArrayList<>();
            Food egg = new Food("egg", 100, false, FoodType.PROTEIN);
            Food beef = new Food("Beef", 100, false, FoodType.PROTEIN);
            Food Chicken = new Food("Chicken", 100, false, FoodType.PROTEIN);
            Food Milk = new Food("Milk", 100, false, FoodType.PROTEIN);
            Food Soy = new Food("Soy", 100, false, FoodType.PROTEIN);
            Food Beans = new Food("Beans", 100, false, FoodType.PROTEIN);
            Food Flour = new Food("Flour", 100, false, FoodType.PROTEIN);
            Food Shrimp = new Food("Shrimp", 100, false, FoodType.PROTEIN);
            food.add(egg);
            food.add(beef);
            food.add(Chicken);
            food.add(Milk);
            food.add(Soy);
            food.add(Beans);
            food.add(Flour);
            food.add(Shrimp);

            ArrayList<Food> allergies = new ArrayList<>();
            allergies.add(egg);
            allergies.add(beef);
            allergies.add(Chicken);
            allergies.add(Milk);
            allergies.add(Soy);
            allergies.add(Beans);
            allergies.add(Flour);
            allergies.add(Shrimp);

            Person person1 = new Person(egg,allergies,null,70.0f);
            HypercaloricDiet randomHcd =  randomDiet(person1,food);
            Assert.assertEquals(0,randomHcd.getAllowedFood().size() );
        }catch(IllegalArgumentException e){
            Assert.assertEquals("Need something in allowed food", e.getMessage());
        }
    }

    //Testing that diet is not Vegan (Req 4b(IV))
    @Test
    public void testIfDietIsNotVegeterian (){
        ArrayList<Food> food = new ArrayList<>();
        Food egg = new Food("egg", 100, false, FoodType.PROTEIN);
        Food beef = new Food("Beef", 100, false, FoodType.PROTEIN);
        Food Chicken = new Food("Chicken", 100, false, FoodType.PROTEIN);
        Food Milk = new Food("Milk", 100, false, FoodType.PROTEIN);
        Food Soy = new Food("Soy", 100, true, FoodType.PROTEIN);
        Food Beans = new Food("Beans", 100, false, FoodType.PROTEIN);
        Food Flour = new Food("Flour", 100, true, FoodType.PROTEIN);
        Food Shrimp = new Food("Shrimp", 100, true, FoodType.PROTEIN);
        food.add(egg);
        food.add(beef);
        food.add(Chicken);
        food.add(Milk);
        food.add(Soy);
        food.add(Beans);
        food.add(Flour);
        food.add(Shrimp);

        ArrayList<Food> allergies = new ArrayList<>();
        allergies.add(egg);
        allergies.add(beef);

        Person person1 = new Person(egg,allergies,null,70.0f);
        HypercaloricDiet randomHcd =  randomDiet(person1,food);
        Assert.assertEquals(false, randomHcd.isVegan());
    }

    //Testing that diet is Vegan
    @Test
    public void testIfDietIsVegeterian (){
        ArrayList<Food> food = new ArrayList<>();
        Food egg = new Food("egg", 100, true, FoodType.PROTEIN);
        Food beef = new Food("Beef", 100, true, FoodType.PROTEIN);
        Food Chicken = new Food("Chicken", 100, true, FoodType.PROTEIN);
        Food Milk = new Food("Milk", 100, true, FoodType.PROTEIN);
        Food Soy = new Food("Soy", 100, true, FoodType.PROTEIN);
        Food Beans = new Food("Beans", 100, true, FoodType.PROTEIN);
        Food Flour = new Food("Flour", 100, true, FoodType.PROTEIN);
        Food Shrimp = new Food("Shrimp", 100, true, FoodType.PROTEIN);
        food.add(egg);
        food.add(beef);
        food.add(Chicken);
        food.add(Milk);
        food.add(Soy);
        food.add(Beans);
        food.add(Flour);
        food.add(Shrimp);

        ArrayList<Food> allergies = new ArrayList<>();
        allergies.add(egg);
        allergies.add(beef);

        Person person1 = new Person(egg,allergies,null,70.0f);
        HypercaloricDiet randomHcd =  randomDiet(person1,food);
        Assert.assertEquals(true, randomHcd.isVegan());
    }

    // Testing persons max weight (Req 4b(V))
    @Test
    public void testMaxWeight(){
        ArrayList<Food> food = new ArrayList<>();
        Food peas = new Food("Peas",100, true,FoodType.PROTEIN);
        Food pasta = new Food("Pasta", 30, true, FoodType.CARB);
        food.add(peas);
        food.add(pasta);

        ArrayList<Food> allergies = new ArrayList<>();
        Food egg = new Food("egg", 100, false, FoodType.PROTEIN);
        Food Milk = new Food("Milk", 100, false, FoodType.PROTEIN);
        allergies.add(egg);
        allergies.add(Milk);

        Person person1 = new Person(pasta,allergies,null,70.0f);

        HypercaloricDiet randomHcd =  randomDiet(person1,food);

        Assert.assertTrue(randomHcd.getMaxWeightKg() < person1.getWeight()+20 && randomHcd.getMaxWeightKg() > person1.getWeight());
    }

    // Testing min calories (Req 4b(VI))
    @Test
    public void testMinCalories(){
        ArrayList<Food> food = new ArrayList<>();
        Food peas = new Food("Peas",100, true,FoodType.PROTEIN);
        Food pasta = new Food("Pasta", 30, true, FoodType.CARB);
        food.add(peas);
        food.add(pasta);

        ArrayList<Food> allergies = new ArrayList<>();
        Food egg = new Food("egg", 100, false, FoodType.PROTEIN);
        Food Milk = new Food("Milk", 100, false, FoodType.PROTEIN);
        allergies.add(egg);
        allergies.add(Milk);

        Person person1 = new Person(pasta,allergies,null,70.0f);

        HypercaloricDiet randomHcd =  randomDiet(person1,food);

        Assert.assertTrue(randomHcd.getMinCaloriesPerDay() < 4000  && randomHcd.getMinCaloriesPerDay() > 2000);
    }

}
