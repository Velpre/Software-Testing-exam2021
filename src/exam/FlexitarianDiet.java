package exam;

import java.util.ArrayList;

public class FlexitarianDiet extends Diet {
    private float maxMeatGramsPerWeek;
    private Food preferredMeat;

    public FlexitarianDiet(int daysDuration, String purpose, ArrayList<Food> allowedFood, boolean isVegan, float maxMeatGramsPerWeek, Food preferredMeat) {
        super(daysDuration, purpose, allowedFood, isVegan);
        this.maxMeatGramsPerWeek = maxMeatGramsPerWeek;
        this.preferredMeat = preferredMeat;
    }

    public float getMaxMeatGramsPerWeek() {
        return maxMeatGramsPerWeek;
    }

    public void setMaxMeatGramsPerWeek(float maxMeatGramsPerWeek) {
        this.maxMeatGramsPerWeek = maxMeatGramsPerWeek;
    }

    public Food getPreferredMeat() {
        return preferredMeat;
    }

    public void setPreferredMeat(Food preferredMeat) {
        this.preferredMeat = preferredMeat;
    }
}
