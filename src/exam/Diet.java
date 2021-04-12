package exam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public abstract class Diet {
    private Integer daysDuration;
    private String purpose;
    private ArrayList<Food> allowedFood;
    private boolean isVegan;

    //Constructors

    public Diet(Integer daysDuration, String purpose, ArrayList<Food> allowedFood, boolean isVegan) {
        this.daysDuration = daysDuration;
        this.purpose = purpose;
        this.allowedFood = allowedFood;
        this.isVegan = isVegan;
    }





    /* The Diet class should implement the following methods:a.Write the duration of a diet in terms of years, months and days, e.g., “This VeganDiet lasts for 2 years, 3 months and 5 days”.b.Write the allowed food, e.g., “The following food is allowed in this FlexitarianDiet: Salad, Soup, Apple, Strawberry, Salmon”. */




    //Methods
    public String writeDuration(){

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date()); // Using today's date
        c.add(Calendar.DATE, daysDuration); // Adding days
        String output = sdf.format(c.getTime());
        System.out.println(output);



        // return "The diet lasts for "+ years +" years, " + month + " months" +" and " + days + " days";
        return "";
    }

    public String writeAllowedFood(){
        return "";
    }


    //Getters / Setters


    public int getDaysDuration() {
        return daysDuration;
    }

    public void setDaysDuration(int daysDuration) {
        this.daysDuration = daysDuration;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public ArrayList<Food> getAllowedFood() {
        return allowedFood;
    }

    public void setAllowedFood(ArrayList<Food> allowedFood) {
        this.allowedFood = allowedFood;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public void setVegan(boolean vegan) {
        isVegan = vegan;
    }
}
