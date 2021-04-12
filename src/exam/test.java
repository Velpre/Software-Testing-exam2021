package exam;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class test {
    public static void main(String[] args) {

        ArrayList<Food> allowedFood = new ArrayList<>();
        allowedFood.add(new Food("egg",100, false,FoodType.PROTEIN));
        LowCarbDiet diet1 = new LowCarbDiet(100,"get beef", allowedFood,false,100 );


        System.out.println(diet1.writeAllowedFood());







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
