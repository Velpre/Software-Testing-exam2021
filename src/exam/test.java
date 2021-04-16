package exam;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        ArrayList<Food> allowedVeganFood = new ArrayList<>();
        allowedVeganFood.add(new Food("Peas",50,true,FoodType.PROTEIN));
        ArrayList<Food> allergies = new ArrayList<>();
        VeganDiet diet1 = new VeganDiet(100,"eat vegan ffs",allowedVeganFood,true,100);
        allergies.add(new Food("egg",100, false,FoodType.PROTEIN));
        Food Beans = new Food("Beans",100, true,FoodType.PROTEIN);
        Person person1 = new Person(Beans,allergies,diet1,80);







        /*int daysDuration = 1;

        SimpleDateFormat days = new SimpleDateFormat("dd");
        SimpleDateFormat months = new SimpleDateFormat("MM");
        SimpleDateFormat years = new SimpleDateFormat("yyyy");

        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Using today's date
        c.add(Calendar.DATE, daysDuration); // Adding days
        String output = days.format(c.getTime());
        String output2 = months.format(c.getTime());
        String output3 = years.format(c.getTime());

        Integer outputInt = Integer.parseInt(output);

        System.out.println(output);
        System.out.println(output2);
        System.out.println(output3);





*/
    }
}
