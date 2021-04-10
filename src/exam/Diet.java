package exam;

import java.text.DateFormat;
import java.util.ArrayList;

public abstract class Diet {
    private int daysDuration;
    private String purpose;
    private ArrayList<Food> allowedFood;
    private boolean isVegan;

    //Constructors

    public Diet(int daysDuration, String purpose, ArrayList<Food> allowedFood, boolean isVegan) {
        this.daysDuration = daysDuration;
        this.purpose = purpose;
        this.allowedFood = allowedFood;
        this.isVegan = isVegan;
    }

    //Methods
    public String writeDuration(){
        return "This diet lasts for " + this.getDaysDuration() + " days";
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
