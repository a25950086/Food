package ntou.cs.java2021;

import java.util.ArrayList;
import java.util.List;

public class FoodData {
    private String name;
    private double calories;
    private double protein;
    private double carbohydrates;
    private double fat;
    private double saturatedFat;
    private double transFat;
    private double sugar;

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
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

    public FoodData(){
        this.name = "";
        this.calories = 0;
        this.protein = 0;
        this.carbohydrates = 0;
        this.fat = 0;
        this.saturatedFat = 0;
        this.transFat = 0;
        this.sugar = 0;
    }
    public FoodData(Pharmacy pharmacy){
        this.name = pharmacy.getName();
        String temp, type;
        temp = pharmacy.getContentPerUnit();
        type = pharmacy.getAnalysis();
        if(temp.equals(""))
            temp = "0";
        if (type.equals("??????"))
            this.setCalories(Double.valueOf(temp));
        else if (type.equals("?????????"))
            this.setProtein(Double.valueOf(temp));
        else if (type.equals("??????????????????"))
            this.setCarbohydrates(Double.valueOf(temp));
        else if (type.equals("?????????"))
            this.setFat(Double.valueOf(temp));
        else if (type.equals("????????????"))
            this.setSaturatedFat(Double.valueOf(temp));
        else if (type.equals("????????????"))
            this.setTransFat(Double.valueOf(temp));
        else if (type.equals("????????????"))
            this.setSugar(Double.valueOf(temp));
    }

    @Override
    public String toString() {
        return "#"+name+" "+calories+" "+protein+" "+carbohydrates+" "+fat+" "+saturatedFat+" "+transFat+" "+sugar;
    }
}
