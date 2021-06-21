package ntou.cs.java2021;

import java.util.ArrayList;
import java.util.List;

public class DailyEnergyRecoder {
    private String date;
    private List<FoodData> list;
    private double calories;
    private double protein;
    private double carbohydrates;
    private double fat;
    private double saturatedFat;
    private double transFat;
    private double sugar;

    public String getDate() {
        return date;
    }

    public double getCalories() {
        return calories;
    }

    public double getProtein() {
        return protein;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getFat() {
        return fat;
    }

    public double getSaturatedFat() {
        return saturatedFat;
    }

    public double getTransFat() {
        return transFat;
    }

    public double getSugar() {
        return sugar;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public void setSaturatedFat(double saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    public void setTransFat(double transFat) {
        this.transFat = transFat;
    }

    public void setSugar(double sugar) {
        this.sugar = sugar;
    }
    public DailyEnergyRecoder(String date){
        this.date = date;
        this.calories = 0;
        this.protein = 0;
        this.carbohydrates = 0;
        this.fat = 0;
        this.saturatedFat = 0;
        this.transFat = 0;
        this.sugar = 0;
        this.list = new ArrayList<>();
    }

    public void add(FoodData foodData){
        list.add(foodData);
        this.calories += foodData.getCalories();
        this.protein += foodData.getProtein();
        this.carbohydrates += foodData.getCarbohydrates();
        this.fat += foodData.getFat();
        this.saturatedFat += foodData.getSaturatedFat();
        this.transFat += foodData.getTransFat();
        this.sugar += foodData.getSugar();
    }
    public void delete(FoodData foodData){
        for(int i = 0; i < list.size(); i++){
            if(foodData.equals(list.get(i))) {
                this.calories -= list.get(i).getCalories();
                this.protein -= list.get(i).getProtein();
                this.carbohydrates -= list.get(i).getCarbohydrates();
                this.fat -= list.get(i).getFat();
                this.saturatedFat -= list.get(i).getSaturatedFat();
                this.transFat -= list.get(i).getTransFat();
                this.sugar -= list.get(i).getSugar();
                list.remove(i);
                break;
            }
        }
    }
}