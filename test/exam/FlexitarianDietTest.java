package exam;

import org.junit.Assert;
import org.junit.Test;

import java.beans.Beans;
import java.util.ArrayList;

public class FlexitarianDietTest {

    //Testing constructor

    /******************Testing FlexitarianDiet's prefferedMeat is non-vegan. Requirement 1D****************/
    @Test
    public void testFlexitarianWithVeganPreffered(){
        try {
            ArrayList<Food> allowed = new ArrayList<>();
            allowed.add(new Food("Beef", 100, false, FoodType.PROTEIN));
            allowed.add(new Food("Potato", 100, true, FoodType.PROTEIN));
            allowed.add(new Food("Beans", 100, true, FoodType.PROTEIN));
            allowed.add(new Food("Chicken", 100, false, FoodType.PROTEIN));
            allowed.add(new Food("Milk", 100, false, FoodType.PROTEIN));

            FlexitarianDiet diet1 = new FlexitarianDiet(100, "eat mixed", allowed, false, 456.5f, allowed.get(2));
        } catch (IllegalArgumentException e){
            Assert.assertEquals("The preferred meat in a flexitarian diet must be a non-vegan food of protein-type",e.getMessage());
            System.out.println(e.getMessage());
        }
    }
    //Testing with a preferredMeat that has other type than PROTEIN.
    @Test
    public void testFlexitarianWithOtherThanProtein(){
        try {
            ArrayList<Food> allowed = new ArrayList<>();
            allowed.add(new Food("Beef", 100, false, FoodType.PROTEIN));
            allowed.add(new Food("Potato", 100, true, FoodType.PROTEIN));
            allowed.add(new Food("Beans", 100, true, FoodType.PROTEIN));
            allowed.add(new Food("Chicken", 100, false, FoodType.PROTEIN));
            allowed.add(new Food("Milk", 100, false, FoodType.PROTEIN));
            allowed.add(new Food("Ribs",100,false, FoodType.FAT));

            FlexitarianDiet diet1 = new FlexitarianDiet(100, "eat mixed", allowed, false, 456.5f, allowed.get(5));
        } catch (IllegalArgumentException e){
            Assert.assertEquals("The preferred meat in a flexitarian diet must be a non-vegan food of protein-type",e.getMessage());
        }
    }
    //Testing with non-vegan preffered meat that is PROTEIN. Should create Diet.
    @Test
    public void testFlexitarianWithNonVeganProtein(){
            ArrayList<Food> allowed = new ArrayList<>();
            allowed.add(new Food("Beef", 100, false, FoodType.PROTEIN));
            allowed.add(new Food("Potato", 100, true, FoodType.PROTEIN));
            allowed.add(new Food("Beans", 100, true, FoodType.PROTEIN));
            allowed.add(new Food("Chicken", 100, false, FoodType.PROTEIN));
            allowed.add(new Food("Milk", 100, false, FoodType.PROTEIN));

            FlexitarianDiet diet1 = new FlexitarianDiet(100, "eat mixed", allowed, false, 456.5f, allowed.get(0));

            Assert.assertEquals("eat mixed",diet1.getPurpose());
        }

    }
