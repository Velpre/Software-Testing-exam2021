package exam;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PersonTest {
    /***********************************************Testing constructor for requirement 2A*******************************************/


    //Testing the object is created, by using all the getter-methods
    @Test
    public void testPerson(){
        ArrayList<Food> allergies = new ArrayList<>();
        Food beef = new Food("Beef",100, false,FoodType.PROTEIN);

        allergies.add(new Food("egg",100, false,FoodType.PROTEIN));


        LowCarbDiet diet1 = new LowCarbDiet(35,"get beef", null,true,70 );
        Person person1 = new Person(beef,allergies,diet1,90);
        Assert.assertEquals(beef,person1.getFavoriteFood());
        Assert.assertEquals(allergies, person1.getAllergies());
        Assert.assertEquals(diet1, person1.getDiet());
        Assert.assertTrue(person1.getWeight() == 90);
    }

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

/***********************************************Testing constructor for requirement 2B*******************************************/






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
    public void testLowCarbDietWeightOverAllowed(){
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
