package ntou.cs.java2021;

import java.util.ArrayList;
import java.util.List;

public class FoodDataHandler {
    private List<FoodData> foodList;

    public List<FoodData> getFoodList() {
        return foodList;
    }

    public FoodDataHandler(List<Pharmacy> filteredClinicList){
        this.foodList = makeFoodList(filteredClinicList);
    }

    public List<FoodData> makeFoodList(List<Pharmacy> filteredClinicList){
        boolean used, hasSameName;
        String temp, type;
        List<FoodData> foodList = new ArrayList<>();
        foodList.add(new FoodData(filteredClinicList.get(0)));
        for(int i=1; i< filteredClinicList.size(); i++){
            used = false;
            hasSameName = false;
            for(int j=0; j< foodList.size(); j++) {
                temp = filteredClinicList.get(i).getContentPerUnit();
                if(temp.equals(""))
                    temp = "0";
                if (foodList.get(j).getName().equals(filteredClinicList.get(i).getName())) {
                    hasSameName = true;
                    type = filteredClinicList.get(i).getAnalysis();
                    if (type.equals("熱量")) {
                        foodList.get(j).setCalories(Double.valueOf(temp));
                        used = true;
                        break;
                    }
                    if (type.equals("粗蛋白")){
                        foodList.get(j).setProtein(Double.valueOf(temp));
                        used = true;
                        break;
                    }
                    if (type.equals("總碳水化合物")) {
                        foodList.get(j).setCarbohydrates(Double.valueOf(temp));
                        used = true;
                        break;
                    }
                    if (type.equals("粗脂肪")){
                        foodList.get(j).setFat(Double.valueOf(temp));
                        used = true;
                        break;
                    }
                    if (type.equals("飽和脂肪")) {
                        foodList.get(j).setSaturatedFat(Double.valueOf(temp));
                        used = true;
                        break;
                    }
                    if (type.equals("反式脂肪")) {
                        foodList.get(j).setTransFat(Double.valueOf(temp));
                        used = true;
                        break;
                    }
                    if (type.equals("糖質總量")) {
                        foodList.get(j).setSugar(Double.valueOf(temp));
                        used = true;
                        break;
                    }
                }
            }
            if(!hasSameName && !used)
                foodList.add(new FoodData(filteredClinicList.get(i)));
        }
        return foodList;
    }
}
