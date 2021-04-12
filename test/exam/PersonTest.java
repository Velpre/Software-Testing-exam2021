package exam;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PersonTest {
    //Testing constructor
    @Test
    public void testPerson(){
        ArrayList<Food> allergies = new ArrayList<>();
        Food beef = new Food("Beef",100, false,FoodType.PROTEIN);

        allergies.add(new Food("egg",100, false,FoodType.PROTEIN));
        allergies.add(new Food("Salmon",100, false,FoodType.PROTEIN));
        allergies.add(new Food("Chicken",100, false,FoodType.PROTEIN));
        allergies.add(new Food("Pork",100, false,FoodType.PROTEIN));

        VeganDiet diet1 = new VeganDiet(35,"get beef", null,true,100 );
        Person person1 = new Person(beef,allergies,diet1,90);
        Assert.assertEquals(beef,person1.getFavoriteFood());
        Assert.assertEquals(allergies, person1.getAllergies());
        Assert.assertEquals(diet1, person1.getDiet());
        Assert.assertTrue(person1.getWeight() == 90);
    }

    // If their favorite food is non-vegan, they cannot follow a VeganDiet.
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
    @Test(expected = IllegalArgumentException.class)
    public void testVeganWeight(){
        ArrayList<Food> allowedVeganFood = new ArrayList<>();

        allowedVeganFood.add(new Food("Peas",50,true,FoodType.PROTEIN));

        ArrayList<Food> allergies = new ArrayList<>();
        VeganDiet diet1 = new VeganDiet(100,"eat vegan ffs",allowedVeganFood,true,80);
        allergies.add(new Food("egg",100, false,FoodType.PROTEIN));
        Food beef = new Food("Beef",100, false,FoodType.PROTEIN);
        Person person1 = new Person(beef,allergies,diet1,70);

    }

}
