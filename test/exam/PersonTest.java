package exam;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;

import java.util.ArrayList;

public class PersonTest {
    //Testing the object is created, by using all the getter-methods
    @Test
    public void testPerson(){
        ArrayList<Food> allergies = new ArrayList<>();
        Food beef = new Food("Beef",100, false,FoodType.PROTEIN);
        Food egg = new Food("egg", 100, false, FoodType.PROTEIN);
        Food beefStw = new Food("Beef", 100, false, FoodType.PROTEIN);
        Food Chicken = new Food("Chicken", 100, false, FoodType.PROTEIN);
        Food Milk = new Food("Milk", 100, false, FoodType.PROTEIN);

        allergies.add(new Food("egg",100, false,FoodType.PROTEIN));
        ArrayList<Food> allowed = new ArrayList<>();
        allowed.add(Chicken);
        allowed.add(Milk);

        LowCarbDiet diet1 = new LowCarbDiet(35,"get beef", allowed,true,70 );
        Person person1 = new Person(beef,allergies,diet1,90);
        Assert.assertEquals(beef,person1.getFavoriteFood());
        Assert.assertEquals(allergies, person1.getAllergies());
        Assert.assertEquals(diet1, person1.getDiet());
        Assert.assertTrue(person1.getWeight() == 90);
    }

    //Testing person-constructor with negative number for weight. Should not be allowed.

    @Test
    public void testWithNegativeWeight(){
        ArrayList<Food> allergies = new ArrayList<>();
        Food beef = new Food("Beef",100, false,FoodType.PROTEIN);
        Food egg = new Food("egg", 100, false, FoodType.PROTEIN);
        Food beef2 = new Food("Beef", 100, false, FoodType.PROTEIN);
        Food Chicken = new Food("Chicken", 100, false, FoodType.PROTEIN);
        Food Milk = new Food("Milk", 100, false, FoodType.PROTEIN);

        allergies.add(new Food("egg",100, false,FoodType.PROTEIN));
        ArrayList<Food> allowed = new ArrayList<>();
        allowed.add(egg);
        allowed.add(Chicken);
        allowed.add(beef2);

        LowCarbDiet diet1 = new LowCarbDiet(35,"get beef", allowed,true,70 );
        Person person1 = new Person(beef,allergies,diet1,90);

    }

    /***********************************************Testing constructor for requirement 2A*******************************************/



    // If their favorite food is non-vegan, they cannot follow a VeganDiet.
    //Expecting constructor to throw Exception using
    @Test(expected = IllegalArgumentException.class)
    public void testNotVegan(){
        ArrayList<Food> allowedVeganFood = new ArrayList<>();
        allowedVeganFood.add(new Food("Peas",50,true,FoodType.PROTEIN));
        ArrayList<Food> allergies = new ArrayList<>();
        VeganDiet diet1 = new VeganDiet(100,"eat vegan ffs",allowedVeganFood,true,80);
        allergies.add(new Food("egg",100, false,FoodType.PROTEIN));
        Food beef = new Food("Beef",100, false,FoodType.PROTEIN);
        Person person1 = new Person(beef,allergies,diet1,90);

    }
    //Testing to see if a person with no favorites is allowed to follow a VeganDiet


/***********************************************Testing constructor for requirement 2B*******************************************/
//50% or more
    //Testing with 50% of allowed foods as allergies, should throw exception
    @Test
    public void testToManyAllergies() {
        try {
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

            LowCarbDiet diet1 = new LowCarbDiet(100, "eat food", allowedFood, false, 80);
            Person person1 = new Person(beef, allergies, diet1, 100);
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("To many allergies", e.getMessage());
        }
    }

    //Testing below 50% allergies, should create Person
    @Test
    public void testAllowedAllergies() {
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
            LowCarbDiet diet1 = new LowCarbDiet(100, "eat food", allowedFood, false, 80);
            Person person1 = new Person(beef, allergies, diet1, 100.5f);

            Assert.assertEquals(100.5f, person1.getWeight(),0);
    }
    //Testing with zero allergies (empty arraylist), should create Person
    @Test
    public void testNoAllergies() {
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
        LowCarbDiet diet1 = new LowCarbDiet(100, "eat food", allowedFood, false, 80);
        Person person1 = new Person(beef, allergies, diet1, 100.5f);

        Assert.assertEquals(100.5f, person1.getWeight(),0);
    }







/***********************************************Testing constructor for requirement 2C*******************************************/


//If they weigh less than the minimum requirement for a Vegan Diet, they cannot follow a Vegan Diet
//Testing with input of weight less than the allowed weight. Expecting a thrown Exception
    @Test(expected = IllegalArgumentException.class)
    public void testVeganWeightOverAllowed(){
        ArrayList<Food> allowedVeganFood = new ArrayList<>();
        allowedVeganFood.add(new Food("Peas",50,true,FoodType.PROTEIN));
        ArrayList<Food> allergies = new ArrayList<>();
        VeganDiet diet1 = new VeganDiet(100,"eat vegan ffs",allowedVeganFood,true,80);
        allergies.add(new Food("egg",100, false,FoodType.PROTEIN));
        Food Beans = new Food("Beans",100, true,FoodType.PROTEIN);
        Person person1 = new Person(Beans,allergies,diet1,70);
    }

        //Testing VeganDiet with the exact same weight as weight allowed, just to be sure
        @Test
        public void testVeganWeightExactlyAllowed(){
            ArrayList<Food> allowedVeganFood = new ArrayList<>();
            allowedVeganFood.add(new Food("Peas",50,true,FoodType.PROTEIN));
            ArrayList<Food> allergies = new ArrayList<>();
            VeganDiet diet1 = new VeganDiet(100,"eat vegan ffs",allowedVeganFood,true,80);
            allergies.add(new Food("egg",100, false,FoodType.PROTEIN));
            Food Beans = new Food("Beans",100, true,FoodType.PROTEIN);
            Person person1 = new Person(Beans,allergies,diet1,80);

            Assert.assertTrue(person1.getWeight() == 80);
        }

    //Testing LowCarbDiet with weight less than allowedMinWeight.
    @Test(expected = IllegalArgumentException.class)
    public void testLowCarbDietWeightUnderAllowed(){
        ArrayList<Food> allowedVeganFood = new ArrayList<>();
        allowedVeganFood.add(new Food("Peas",50,true,FoodType.PROTEIN));
        ArrayList<Food> allergies = new ArrayList<>();
        LowCarbDiet diet1 = new LowCarbDiet(100,"eat lowcarb",allowedVeganFood,true,80);
        allergies.add(new Food("egg",100, false,FoodType.PROTEIN));
        Food Beans = new Food("Beans",100, true,FoodType.PROTEIN);
        Person person1 = new Person(Beans,allergies,diet1,60);

    }
    //Testing LowCarbDiet with the exact weight requirement
    @Test
    public void testLowCarbDietWeightExactAllowed(){
        ArrayList<Food> allowedVeganFood = new ArrayList<>();
        allowedVeganFood.add(new Food("Peas",50,true,FoodType.PROTEIN));
        ArrayList<Food> allergies = new ArrayList<>();
        LowCarbDiet diet1 = new LowCarbDiet(100,"eat lowcarb",allowedVeganFood,true,80);
        allergies.add(new Food("egg",100, false,FoodType.PROTEIN));
        Food Beans = new Food("Beans",100, true,FoodType.PROTEIN);
        Person person1 = new Person(Beans,allergies,diet1,80);

        Assert.assertEquals(80,person1.getWeight(),0);

    }



/***********************************************Testing constructor for requirement 2D*******************************************/




}
