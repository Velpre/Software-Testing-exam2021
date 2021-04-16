package exam;

import java.time.LocalDate;
import java.util.ArrayList;

public class HypercaloricDiet extends Diet {
    private float maxWeightKg;
    private float minCaloriesPerDay;

    public HypercaloricDiet(Integer daysDuration, String purpose, ArrayList<Food> allowedFood, boolean isVegan, float maxWeightKg, float minCaloriesPerDay) {
        super(daysDuration, purpose, allowedFood, isVegan);
        this.maxWeightKg = maxWeightKg;
        this.minCaloriesPerDay = minCaloriesPerDay;
    }

    public float getMaxWeightKg() {
        return maxWeightKg;
    }

    public void setMaxWeightKg(float maxWeightKg) {
        this.maxWeightKg = maxWeightKg;
    }

    public float getMinWeightKg() {
        return minCaloriesPerDay;
    }

    public void setMinWeightKg(float minWeightKg) {
        this.minCaloriesPerDay = minWeightKg;
    }
}
