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
            System.out.println(filteredClinicList);

        } catch (IOException | URISyntaxException e) {
            // TODO Auto-generated catch block
            System.err.println(e);
        }
    }
}
