package exam;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class test {
    public static void main(String[] args) {

            ArrayList<Food> allowedFood = new ArrayList<>();
            ArrayList<Food> allergies = new ArrayList<>();

            Food beef = new Food("Beef", 100, false, FoodType.PROTEIN);
            allowedFood.add(beef);
            Person person1 = new Person(beef, allergies, null, 90.0f);


    }
}
