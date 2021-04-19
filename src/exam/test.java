package exam;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        ArrayList<Food> allowed = new ArrayList<>();
        allowed.add(new Food("Tomato", 100, true, FoodType.CARB));
        allowed.add(new Food("Potato", 100, true, FoodType.PROTEIN));
        allowed.add(new Food("Beans", 100, true, FoodType.PROTEIN));
        allowed.add(new Food("Peas", 100, true, FoodType.PROTEIN));
        allowed.add(new Food("Beef", 100, false, FoodType.PROTEIN));

        LowCarbDiet diet1 = new LowCarbDiet(100, "dont eat calories",allowed,false,90.4f);

        System.out.println(diet1.isVegan());







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
