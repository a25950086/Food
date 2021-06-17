package ntou.cs.java2021;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        try {
            FoodHandler handler = new FoodHandler();
            handler.initialize();
            List<Pharmacy> filteredClinicList = handler.findPharmacies("旗魚腹肉");
            for(Pharmacy i : filteredClinicList) {
                if (i.getAnalysis().equals("糖質總量"))
                    System.out.println(i);
                if (i.getAnalysis().equals("粗脂肪"))
                    System.out.println(i);
                if (i.getAnalysis().equals("粗蛋白"))
                    System.out.println(i);
                if (i.getAnalysis().equals("飽和脂肪"))
                    System.out.println(i);
                if (i.getAnalysis().equals("反式脂肪"))
                    System.out.println(i);
                if (i.getAnalysis().equals("熱量"))
                    System.out.println(i);
                if (i.getAnalysis().equals("總碳水化合物"))
                    System.out.println(i);
            }
        } catch (IOException | URISyntaxException e) {
            // TODO Auto-generated catch block
            System.err.println(e);
        }
    }
}
