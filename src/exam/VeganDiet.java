package exam;

import java.time.LocalDate;
import java.util.ArrayList;

public class VeganDiet extends Diet {
    private float minWeightKg;


    //Constructor


    public VeganDiet(Integer daysDuration, String purpose, ArrayList<Food> allowedFood, boolean isVegan, float minWeightKg) {
        super(daysDuration, purpose, allowedFood, isVegan);
        this.minWeightKg = minWeightKg;
    }

    public float getMinWeightKg() {
        return minWeightKg;
    }

    public void setMinWeightKg(float minWeightKg) {
        this.minWeightKg = minWeightKg;
    }
}
