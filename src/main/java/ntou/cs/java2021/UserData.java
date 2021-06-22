package ntou.cs.java2021;

public class UserData {
    private String gender;
    private double age;
    private double height;
    private double weight;
    private double needCalories;
    private double needProtein;
    private double needCarbohydrates;
    private double needFat;
    private double needSaturatedFat;
    private double needTransFat;
    private double needSugar;

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getAge() {
        return age;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public double getNeedCalories() {
        return needCalories;
    }

    public double getNeedProtein() {
        return needProtein;
    }

    public double getNeedCarbohydrates() {
        return needCarbohydrates;
    }

    public double getNeedFat() {
        return needFat;
    }

    public double getNeedSaturatedFat() {
        return needSaturatedFat;
    }

    public double getNeedTransFat() {
        return needTransFat;
    }

    public double getNeedSugar() {
        return needSugar;
    }

    public UserData(String gender, double age, double height, double weight){
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        if(gender == "boy")
            this.needCalories = 13.397 * weight + 4.799 * height - 5.677 * age + 88.362;
        else
            this.needCalories = 9.247 * weight + 3.098 * height - 4.330 * age + 447.593;
        this.needProtein = needCalories * 0.15;
        this.needCarbohydrates = needCalories * 0.75;
        this.needFat = needCalories * 0.35;
        this.needSaturatedFat = needCalories * 0.1;
        this.needTransFat = needCalories * 0.01;
        this.needSugar = needCalories * 0.1;
    }


}
