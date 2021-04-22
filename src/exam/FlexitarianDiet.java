package exam;

import java.time.LocalDate;
import java.util.ArrayList;

public class FlexitarianDiet extends Diet {
    private float maxMeatGramsPerWeek;
    private Food preferredMeat;

    public FlexitarianDiet(Integer daysDuration, String purpose, ArrayList<Food> allowedFood, boolean isVegan, float maxMeatGramsPerWeek, Food preferredMeat) {
        super(daysDuration, purpose, allowedFood, isVegan);
        if (preferredMeat.isVegan() || preferredMeat.getType() != FoodType.PROTEIN) {
            throw new IllegalArgumentException("The preferred meat in a flexitarian diet must be a non-vegan food of protein-type");
        } else {
            this.maxMeatGramsPerWeek = maxMeatGramsPerWeek;
            this.preferredMeat = preferredMeat;
        }
    }

}
