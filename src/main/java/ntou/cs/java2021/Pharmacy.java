package ntou.cs.java2021;

public class Pharmacy {
    private String foodClassification; //食品分類
    private String dataCategory; //資料類別
    private String id; //整合編號
    private String name; //樣品名稱
    private String nickName; //俗名
    private String engName;//樣品英文名稱
    private String description; //內容物描述
    private String abandonmentRate; //廢棄率
    private String analysisClassification; //分析項分類
    private String analysis; //分析項
    private String unit; //含量單位
    private String content; //每100克含量
    private String numberOfSamples; //樣本數
    private String standardDeviation;//標準差
    private String contentPerUnit;//每單位含量
    private String weightPerUnit; //每單位重
    private String weightContentPerUnit; //每單位重含量

    public String getFoodClassification() {
        return foodClassification;
    }

    public void setFoodClassification(String foodClassification) {
        this.foodClassification = foodClassification;
    }

    public String getDataCategory(){
        return dataCategory;
    }

    public void setDataCategory(String dataCategory){
        this.dataCategory = dataCategory;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getNickName(){
        return nickName;
    }

    public void setNickName(String nickName){
        this.nickName = nickName;
    }

    public String getEngName(){
        return engName;
    }

    public void setEngName(String engName){
        this.engName = engName;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getAbandonmentRate(){
        return abandonmentRate;
    }

    public void setAbandonmentRate(String abandonmentRate){
        this.abandonmentRate = abandonmentRate;
    }

    public String getAnalysisClassification(){
        return analysisClassification;
    }

    public void setAnalysisClassification(String analysisClassification){
        this.analysisClassification = analysisClassification;
    }

    public String getAnalysis(){
        return analysis;
    }

    public void setAnalysis(String analysis){
        this.analysis = analysis;
    }

    public String getUnit(){
        return unit;
    }

    public void setUnit(String unit){
        this.unit = unit;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getNumberOfSamples(){
        return numberOfSamples;
    }

    public void setNumberOfSamples(String numberOfSamples){
        this.numberOfSamples = numberOfSamples;
    }

    public String getStandardDeviation(){
        return standardDeviation;
    }

    public void setStandardDeviation(String standardDeviation){
        this.standardDeviation = standardDeviation;
    }

    public String getContentPerUnit(){
        return contentPerUnit;
    }

    public void setContentPerUnit(String contentPerUnit){
        this.contentPerUnit = contentPerUnit;
    }

    public String getWeightPerUnit(){
        return weightPerUnit;
    }

    public void setWeightPerUnit(String weightPerUnit){
        this.weightPerUnit = weightPerUnit;
    }

    public String getWeightContentPerUnit(){
        return weightContentPerUnit;
    }

    public void setWeightContentPerUnit(String weightContentPerUnit){
        this.weightContentPerUnit = weightContentPerUnit;
    }

    @Override
    public String toString() {
        return "Pharmacy [foodClassification=" + foodClassification + ", dataCategory=" + dataCategory + ", id=" + id + ", name=" + name
                + ", nickName=" + nickName + ", engName=" + engName + ", description=" + description + "abandonmentRate=" + abandonmentRate
                + "analysisClassification=" + analysisClassification + "analysis=" + analysis + "unit=" + unit
                + "content=" + content + "numberOfSamples=" + numberOfSamples + "standardDeviation=" + standardDeviation
                + "contentPerUnit=" + contentPerUnit + "weightPerUnit=" + weightPerUnit + "weightContentPerUnit=" + weightContentPerUnit
                + "]";
    }
}
