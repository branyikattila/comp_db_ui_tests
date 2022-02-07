package uk.co.acme.testData;

import java.util.HashMap;

public class TestData {

    public final String[] test_data1 = new String[] {"Name : First Comp", "Introduced: 1974-01-04", "Discontinued: 2000-01-06", "Company: Atari"};
    public final String[] test_data2 = new String[] {"Name : ACE", "Introduced: 1058-01-01", "Discontinued: 1978-01-01", "Company: IBM"};
    public final String[] test_data3 = new String[] {"Name : AC1", "Introduced: 1037-01-01", "Discontinued: 1978-01-01", "Company: Sony"};

    public HashMap<String, String> getTestDataByFieldName(String[] data) {
        HashMap<String, String> hmap = new HashMap<String, String>();
        for (int i = 0; i < data.length; i++) {
            hmap.put(data[i].split(":")[0].trim(), data[i].split(":")[1].trim());
        }
        return hmap;
    }

}
