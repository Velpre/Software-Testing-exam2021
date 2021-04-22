package exam;

import java.time.LocalDate;
import java.util.ArrayList;

public class LowCarbDiet extends Diet {
    private float minWeightKg;

    public LowCarbDiet(Integer daysDuration, String purpose, ArrayList<Food> allowedFood, boolean isVegan, float minWeightKg) {
        super(daysDuration, purpose, allowedFood, isVegan);
        // eliminating negative values.
        if(minWeightKg < 0){
            throw new IllegalArgumentException("The diet must have a higher minWeight");
        }
        this.minWeightKg = minWeightKg;
        // req 1e
        int counter = 0;
        for(int i =0; i<allowedFood.size(); i++){
            if(allowedFood.get(i).getType() == FoodType.CARB){
                counter++;
            }
        }
        if(counter >2){
            throw new IllegalArgumentException("This lowcarb-diet contains to many carb-type food");
        }
    }

    public float getMinWeightKg() {
        return minWeightKg;
    }

}
