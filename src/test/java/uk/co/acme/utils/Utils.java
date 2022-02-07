package uk.co.acme.utils;

import com.google.gson.Gson;
import uk.co.acme.model.TestDataModel;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {

    public TestDataModel[] getAllFromJson() throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("src/test/resources/test_data/test_data.json"));
        TestDataModel[] models = gson.fromJson(reader, TestDataModel[].class);
        return models;
    }

    public TestDataModel getTestDataById(String id) throws IOException {
        TestDataModel result = null;
        TestDataModel[] models = getAllFromJson();
        for (TestDataModel model: models) {
            if (id.equals(model.getId())) {
                result = model;
            }
        }
        return result;
    }
}
