package exam;

import java.time.LocalDate;
import java.util.ArrayList;

public class LowCarbDiet extends Diet {
    private float minWeightKg;

    public LowCarbDiet(Integer daysDuration, String purpose, ArrayList<Food> allowedFood, boolean isVegan, float minWeightKg) {
        super(daysDuration, purpose, allowedFood, isVegan);
        if(minWeightKg < 0){
            throw new IllegalArgumentException("The diet must have a higher minWeight");
        }
        this.minWeightKg = minWeightKg;
    }

    public float getMinWeightKg() {
        return minWeightKg;
    }

    public void setMinWeightKg(float minWeightKg) {
        this.minWeightKg = minWeightKg;
    }
}
