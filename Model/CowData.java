package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CowData {
    private Map<String, Cow> cowMap;

    public CowData() {
        cowMap = new HashMap<>();
        loadCowData();
    }

    private void loadCowData() {
        String filepath = "Model/Database.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                String[] data = line.split(",");
                String cowID = data[0];
                String color = data[1];
                String[] ageParts = data[2].split("year-|months");
                int years = Integer.parseInt(ageParts[0].trim());
                int months = Integer.parseInt(ageParts[1].trim());
                Cow cow = new Cow(cowID, color, years, months);
                cowMap.put(cowID, cow);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Cow getCowByID(String cowID) {
        return cowMap.getOrDefault(cowID, null);
    }
}
