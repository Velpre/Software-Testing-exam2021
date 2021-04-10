package exam;

import java.util.ArrayList;

public class HypercaloricDiet extends Diet {
    private float maxWeightKg;
    private float minWeightKg;

    public HypercaloricDiet(int daysDuration, String purpose, ArrayList<Food> allowedFood, boolean isVegan, float maxWeightKg, float minWeightKg) {
        super(daysDuration, purpose, allowedFood, isVegan);
        this.maxWeightKg = maxWeightKg;
        this.minWeightKg = minWeightKg;
    }

    public float getMaxWeightKg() {
        return maxWeightKg;
    }

    public void setMaxWeightKg(float maxWeightKg) {
        this.maxWeightKg = maxWeightKg;
    }

    public float getMinWeightKg() {
        return minWeightKg;
    }

    public void setMinWeightKg(float minWeightKg) {
        this.minWeightKg = minWeightKg;
    }
}
