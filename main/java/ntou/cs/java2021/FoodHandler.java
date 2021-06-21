package ntou.cs.java2021;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import org.simpleflatmapper.csv.CsvParser;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FoodHandler {
    private static final String fileName = "fooddata.csv";
    private List<Pharmacy> pharmacyList;

    private Map<String, String> constructFieldNameTranslationMap() {
        Map<String, String> fieldNameTranslationMap = new HashMap<String, String>();
        fieldNameTranslationMap.put("食品分類", "foodClassification");
        fieldNameTranslationMap.put("資料類別", "dataCategory");
        fieldNameTranslationMap.put("整合編號", "id");
        fieldNameTranslationMap.put("樣品名稱", "name");
        fieldNameTranslationMap.put("俗名", "nickName");
        fieldNameTranslationMap.put("樣品英文名稱", "engName");
        fieldNameTranslationMap.put("內容物描述", "description");
        fieldNameTranslationMap.put("廢棄率", "abandonmentRate");
        fieldNameTranslationMap.put("分析項分類", "analysisClassification");
        fieldNameTranslationMap.put("分析項", "analysis");
        fieldNameTranslationMap.put("含量單位", "unit");
        fieldNameTranslationMap.put("每100克含量", "content");
        fieldNameTranslationMap.put("樣本數", "numberOfSamples");
        fieldNameTranslationMap.put("標準差", "standardDeviation");
        fieldNameTranslationMap.put("每單位含量", "contentPerUnit");
        fieldNameTranslationMap.put("每單位重", "weightPerUnit");
        fieldNameTranslationMap.put("每單位重含量", "weightContentPerUnit");

        return fieldNameTranslationMap;
    }

    public String produceStringFromFile(String fileName) throws IOException {
        InputStream is = new FileInputStream(fileName);
        BufferedReader buf = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();
        while (line != null) {
            sb.append(line).append("\n");
            line = buf.readLine();
        }
        buf.close();
        return sb.toString();
    }

    public String produceDataJson(String csvContent) throws IOException, URISyntaxException {

        Map<String, String> fieldNameTranslationMap = constructFieldNameTranslationMap();
        //System.out.println(fieldNameTranslationMap);

        org.simpleflatmapper.lightningcsv.CsvReader reader = CsvParser.reader(csvContent);

        JsonFactory jsonFactory = new JsonFactory();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        Iterator<String[]> iterator = reader.iterator();
        String[] headers = iterator.next();

        try (JsonGenerator jsonGenerator = jsonFactory.createGenerator(new PrintStream(output))) {

            jsonGenerator.setPrettyPrinter(new DefaultPrettyPrinter());
            jsonGenerator.writeStartArray();

            while (iterator.hasNext()) {
                jsonGenerator.writeStartObject();
                String[] values = iterator.next();
                int nbCells = Math.min(values.length, headers.length);
                for (int i = 0; i < nbCells; i++) {
                    //System.out.println(headers[i]);
                    //System.out.println(fieldNameTranslationMap.get(headers[i]));

                    jsonGenerator.writeFieldName(fieldNameTranslationMap.get(headers[i]));
                    jsonGenerator.writeString(values[i]);
                }
                jsonGenerator.writeEndObject();
            }
            jsonGenerator.writeEndArray();
        }

        return output.toString();
    }

    public List<Pharmacy> convertToObjects(String jsonData) {

        Gson gson = new Gson();
        ArrayList<Pharmacy> clinicList = new ArrayList<Pharmacy>();

        try {
            Type listType = new TypeToken<List<Pharmacy>>() {
            }.getType();
            //System.out.println(jsonData);
            //System.out.println(listType);
            clinicList = gson.fromJson(jsonData, listType);
            //System.out.println(clinicList);
        } catch (Exception e) {
            System.err.println("Exception: " + e);
        }
        return clinicList;
    }
/*
    public class NullStringToEmptyAdapterFactory<T> implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            Class<T> rawType = (Class<T>) type.getRawType();
            if (rawType != String.class) {
                return null;
            }
            return (TypeAdapter<T>) new StringNullAdapter();
        }
    }

    public class StringNullAdapter extends TypeAdapter<String> {
        @Override
        public String read(JsonReader reader) throws IOException {
            // TODO Auto-generated method stub
            if (reader.peek() == JsonToken.NULL) {
                reader.nextNull();
                return "";
            }
            return reader.nextString();
        }
        @Override
        public void write(JsonWriter writer, String value) throws IOException {
            // TODO Auto-generated method stub
            if (value == null) {
                writer.nullValue();
                return;
            }
            writer.value(value);
        }
    }
*/
    public List<Pharmacy> findPharmacies(String queryName) {
        List<Pharmacy> matchingElements = pharmacyList.stream().filter(
                str -> str.getName().trim().contains(queryName))
                .collect(Collectors.toList());

        return matchingElements;
    }

    public void initialize() throws IOException, URISyntaxException {
        String foodData = produceStringFromFile(fileName);
        String foodDataJson = produceDataJson(foodData);
        //System.out.println(foodDataJson);
        pharmacyList = convertToObjects(foodDataJson);
    }
}
