package exam;

import org.junit.Assert;
import org.junit.Test;

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

        LowCarbDiet diet1 = new LowCarbDiet(35,"get beef", allowed,false,70.0f );
        Person person1 = new Person(beef,allergies,diet1,90.0f);
        Assert.assertEquals(beef,person1.getFavoriteFood());
        Assert.assertEquals(allergies, person1.getAllergies());
        Assert.assertEquals(diet1, person1.getDiet());
        Assert.assertTrue(person1.getWeight() == 90.0f);
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

        LowCarbDiet diet1 = new LowCarbDiet(35,"get beef", allowed,false,70.0f );
        Person person1 = new Person(beef,allergies,diet1,90);

    }

    /***********************************************Testing constructor for requirement 2A*******************************************/
    // If their favorite food is non-vegan, they cannot follow a VeganDiet.
    //Expecting constructor to throw Exception using
    @Test
    public void testNotVegan(){
        try{
            ArrayList<Food> allowedVeganFood = new ArrayList<>();
            allowedVeganFood.add(new Food("Peas",50,true,FoodType.PROTEIN));
            ArrayList<Food> allergies = new ArrayList<>();
            VeganDiet diet1 = new VeganDiet(100,"eat vegan ffs",allowedVeganFood,true,80);
            allergies.add(new Food("egg",100, false,FoodType.PROTEIN));
            Food beef = new Food("Beef",100, false,FoodType.PROTEIN);
            Person person1 = new Person(beef,allergies,diet1,90);

        }catch (IllegalArgumentException e){
            Assert.assertEquals("Vegan mismatch",e.getMessage());
            System.out.println(e.getMessage());
        }
    }

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
            System.out.println(e.getMessage());
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
    @Test
    public void testVeganWeightUnderAllowed(){
        try{
            ArrayList<Food> allowedVeganFood = new ArrayList<>();
            allowedVeganFood.add(new Food("Peas",50,true,FoodType.PROTEIN));
            ArrayList<Food> allergies = new ArrayList<>();
            VeganDiet diet1 = new VeganDiet(100,"eat vegan ffs",allowedVeganFood,true,80);
            allergies.add(new Food("egg",100, false,FoodType.PROTEIN));
            Food Beans = new Food("Beans",100, true,FoodType.PROTEIN);
            Person person1 = new Person(Beans,allergies,diet1,70);
        }catch (IllegalArgumentException e){
            Assert.assertEquals("Vegan Weight mismatch",e.getMessage());
            System.out.println(e.getMessage());
        }

    }
    //Testing to see if everything works with weight over minimum requirement.
    @Test
    public void testVeganWeightOverAllowed(){
        ArrayList<Food> allowedVeganFood = new ArrayList<>();
        allowedVeganFood.add(new Food("Peas",50,true,FoodType.PROTEIN));
        ArrayList<Food> allergies = new ArrayList<>();
        VeganDiet diet1 = new VeganDiet(100,"eat vegan",allowedVeganFood,true,80f);
        allergies.add(new Food("egg",100, false,FoodType.PROTEIN));
        Food Beans = new Food("Beans",100, true,FoodType.PROTEIN);
        Person person1 = new Person(Beans,allergies,diet1,199.5f);

        Assert.assertTrue(person1.getWeight() == 199.5f);
        Assert.assertEquals("eat vegan", diet1.getPurpose());
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
    //Testing to see if everything works with weight over minimum requirement.
    @Test
    public void testLowCarbWeightOverAllowed(){
        ArrayList<Food> allowedVeganFood = new ArrayList<>();
        allowedVeganFood.add(new Food("Peas",50,true,FoodType.PROTEIN));
        ArrayList<Food> allergies = new ArrayList<>();
        LowCarbDiet diet1 = new LowCarbDiet(100,"eat vegan",allowedVeganFood,true,80f);
        allergies.add(new Food("egg",100, false,FoodType.PROTEIN));
        Food Beans = new Food("Beans",100, true,FoodType.PROTEIN);
        Person person1 = new Person(Beans,allergies,diet1,199.5f);

        Assert.assertTrue(person1.getWeight() == 199.5f);
        Assert.assertEquals("eat vegan", diet1.getPurpose());
    }

    //Testing LowCarbDiet with weight less than allowedMinWeight.
    @Test
    public void testLowCarbDietWeightUnderAllowed(){
        try{
            ArrayList<Food> allowedVeganFood = new ArrayList<>();
            allowedVeganFood.add(new Food("Peas",50,true,FoodType.PROTEIN));
            ArrayList<Food> allergies = new ArrayList<>();
            LowCarbDiet diet1 = new LowCarbDiet(100,"eat lowcarb",allowedVeganFood,true,80);
            allergies.add(new Food("egg",100, false,FoodType.PROTEIN));
            Food Beans = new Food("Beans",100, true,FoodType.PROTEIN);
            Person person1 = new Person(Beans,allergies,diet1,60);
        }catch (IllegalArgumentException e){
            Assert.assertEquals("LowCarbDiet Weight mismatch",e.getMessage());
            System.out.println(e.getMessage());
        }


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
//If they weigh more than the requirement for the hypercaloric diet they cannot be following this diet

    //Testing to create hypercaloricdiet with a personWeight over maxAllowedWeight. Should throw exception
    @Test
    public void testHyperCaloricOverMaxWeight(){
        try{
            ArrayList<Food> allowedVeganFood = new ArrayList<>();
            allowedVeganFood.add(new Food("Peas",50,true,FoodType.PROTEIN));
            ArrayList<Food> allergies = new ArrayList<>();
            HypercaloricDiet diet1 = new HypercaloricDiet(100,"eat lots of calories",allowedVeganFood,true,80.0f, 60.0f);
            allergies.add(new Food("egg",100, false,FoodType.PROTEIN));
            Food Beans = new Food("Beans",100, true,FoodType.PROTEIN);
            Person person1 = new Person(Beans,allergies,diet1,85.0f);
        }catch (IllegalArgumentException e){
            Assert.assertEquals("You weigh too much",e.getMessage());
        }


    }
    //Testing to create hypercaloricdiet with a personWeight under maxAllowedWeight. Should work as intended
    @Test
    public void testHyperCaloricAllowedMaxWeight(){
        ArrayList<Food> allowedVeganFood = new ArrayList<>();
        allowedVeganFood.add(new Food("Peas",50,true,FoodType.PROTEIN));
        ArrayList<Food> allergies = new ArrayList<>();
        HypercaloricDiet diet1 = new HypercaloricDiet(100,"eat lots of calories", allowedVeganFood,true,80.0f, 60.0f);
        allergies.add(new Food("egg",100, false,FoodType.PROTEIN));
        Food Beans = new Food("Beans",100, true,FoodType.PROTEIN);
        Person person1 = new Person(Beans,allergies,diet1,77.0f);

        Assert.assertEquals(77.0f, person1.getWeight(),0);
        Assert.assertEquals("eat lots of calories",diet1.getPurpose());
    }

    //Testing to create hypercaloricdiet with a personWeight the same as maxAllowedWeight. Should work as intended.
    @Test
    public void testHyperCaloricExactMaxWeight(){
        ArrayList<Food> allowedVeganFood = new ArrayList<>();
        allowedVeganFood.add(new Food("Peas",50,true,FoodType.PROTEIN));
        ArrayList<Food> allergies = new ArrayList<>();
        HypercaloricDiet diet1 = new HypercaloricDiet(100,"eat lots of calories", allowedVeganFood,true,80.0f, 60.0f);
        allergies.add(new Food("egg",100, false,FoodType.PROTEIN));
        Food Beans = new Food("Beans",100, true,FoodType.PROTEIN);
        Person person1 = new Person(Beans,allergies,diet1,80.0f);

        Assert.assertEquals(80.0f, person1.getWeight(),0);
        Assert.assertEquals("eat lots of calories",diet1.getPurpose());
    }
}
