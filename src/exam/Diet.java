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
        //If allowedFood array is empty, you are not allowed to create the diet.
        if (allowedFood.size() <= 0) {
            throw new IllegalArgumentException("Need something in allowed food");
        }
        // REQ 1A and 1B:

            //Converting non-vegan diet to vegan diet, and vice versa.

            boolean allFoodIsVegan = false;
            for (Food f :
                    allowedFood) {
                if (f.isVegan()) {
                    allFoodIsVegan = true;
                } else if (!f.isVegan()) {
                    allFoodIsVegan = false;
                    break;
                }
            }
            if (allFoodIsVegan) {
                this.daysDuration = daysDuration;
                this.purpose = purpose;
                this.allowedFood = allowedFood;
                this.isVegan = true;
            } else {
                this.daysDuration = daysDuration;
                this.purpose = purpose;
                this.allowedFood = allowedFood;
                this.isVegan = false;
            }
        }//End of constructor


    /* The Diet class should implement the following methods:a.Write the duration of a diet in terms of years, months and days, e.g., “This VeganDiet lasts for 2 years, 3 months and 5 days”.b.Write the allowed food, e.g., “The following food is allowed in this FlexitarianDiet: Salad, Soup, Apple, Strawberry, Salmon”. */

    //Methods

    //Req 3a
    public String writeDuration(){
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(this.daysDuration);

        int outputYears = Period.between(startDate, endDate).getYears();
        int outputMonths = Period.between(startDate , endDate).getMonths();
        int outputDays = Period.between(startDate, endDate).getDays();

        return "This diet lasts for "+ outputYears  +" years, " + outputMonths + " months" +" and " + outputDays + " days";

    }

    //Req 3b
    public String writeAllowedFood() {
        String output = "";
        for (int i = 0; i < allowedFood.size(); i++) {
            if (i == allowedFood.size() - 1) {
                output += allowedFood.get(i).getName() + ". ";
            } else {
                output += allowedFood.get(i).getName() + ", ";
            }
        }
        return "The following food is allowed in this diet: " + output;
    }

    //Getters / Setters

    public int getDaysDuration() {
        return daysDuration;
    }

    public String getPurpose() {
        return purpose;
    }

    public ArrayList<Food> getAllowedFood() {
        return allowedFood;
    }

    public boolean isVegan() {
        return isVegan;
    }

}
