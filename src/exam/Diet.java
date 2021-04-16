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
        if(allowedFood.size() <= 0){
            throw new IllegalArgumentException("Need something in allowed food");
        }
        for (Food f :
                allowedFood) {
            if (!f.isVegan()) {
                throw new IllegalArgumentException("Expected only non-vegan food");
            }
        }
        //Converting non-diet to diet
        for (Food f :
                allowedFood) {
            
        }
        this.daysDuration = daysDuration;
        this.purpose = purpose;
        this.allowedFood = allowedFood;
        this.isVegan = isVegan;
    }





    /* The Diet class should implement the following methods:a.Write the duration of a diet in terms of years, months and days, e.g., “This VeganDiet lasts for 2 years, 3 months and 5 days”.b.Write the allowed food, e.g., “The following food is allowed in this FlexitarianDiet: Salad, Soup, Apple, Strawberry, Salmon”. */




    //Methods

    //Method works, we need to find a way to write "This VeganDiet" instead of "This diet"
    public String writeDuration(){
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(this.daysDuration);

        int outputYears = Period.between(startDate, endDate).getYears();
        int outputMonths = Period.between(startDate , endDate).getMonths();
        int outputDays = Period.between(startDate, endDate).getDays();

        return "This diet lasts for "+ outputYears  +" years, " + outputMonths + " months" +" and " + outputDays + " days";

    }

    //Fikse comma på slutten med en IF
    //Fikse DietName istedefor diet.

    public String writeAllowedFood(){

        String output = "";
        //System.out.print("The following food is allowed in this diet: ");
        for (int i =0; i< allowedFood.size(); i++) {
            output += allowedFood.get(i).getName() + ", ";
        }
        return "The following food is allowed in this diet: " + output;

        /*String basicOutput = "The following food is allowed in this diet: ";
        for (int i =0; i< allowedFood.size(); i++) {
            String temp+i = allowedFood.get(i).getName()
        }*/




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
