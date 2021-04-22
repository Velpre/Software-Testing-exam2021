package exam;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static exam.DietManager.areCompatible;
import static exam.DietManager.randomDiet;

public class DietManagerTest {

    // Testing the Diet-Manager
    // ------------------ Req 4a:Given a Person and a Diet, return true if they are compatible, false otherwise.-----------------

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





    //****************************************** REQ 4b**************

/* Testing the RandomDiet(Person, ArrayList Food ) - Return a HyperCaloric diet

  b. Given a Person and a list of Food, create a random HypercaloricDiet with the following attributes:
    i. daysDuration: random number between 1 and 100.
    ii. purpose: “Random diet”.
    iii. allowedFood: all the Food from the list that the person is not allergic
    to.
    iv. isVegan: false if there is some non-vegan Food, true otherwise.
    v. maxWeightKg: random number between Person.weight and Person.weight + 20.
    vi. minCaloriesPerDay: random number between 2000 and 4000.
*/

    @Test
    public void testDaysDuration(){
        int randomDays = 0;
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

    @Test
    public void testCreateAllowedFoodForAllergies(){

        ArrayList<Food> food = new ArrayList<>();
        Food peas = new Food("Peas",100, true,FoodType.PROTEIN);
        Food pasta = new Food("Pasta", 30, true, FoodType.CARB);
        Food egg = new Food("egg", 100, false, FoodType.PROTEIN);
        food.add(peas);
        food.add(pasta);
        food.add(egg);


        ArrayList<Food> allergies = new ArrayList<>();
        Food Milk = new Food("Milk", 100, false, FoodType.PROTEIN);
        allergies.add(egg);
        allergies.add(Milk);
        allergies.add(peas);

        Person person1 = new Person(pasta,allergies,null,70.0f);

        HypercaloricDiet randomHcd =  randomDiet(person1,food);

        Assert.assertEquals(1,randomHcd.getAllowedFood().size() );

    }






}
