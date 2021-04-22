package exam;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class test {
    public static void main(String[] args) {

        // her tester vi ting... kan slettes.

                ArrayList<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "f"));

                ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

                //remove all elements from second list
                listTwo.removeAll(listOne);

                System.out.println(listTwo);


                // bruker det på foods og allergies:

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
        allergies.add(pasta);

        food.removeAll(allergies);
        System.out.println(food);
    }
}
