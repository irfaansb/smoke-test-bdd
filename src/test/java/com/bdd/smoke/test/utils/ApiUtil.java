package com.bdd.smoke.test.utils;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import cucumber.api.DataTable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bdd.smoke.test.utils.ConstantsUtil.*;
import static org.assertj.core.api.Assertions.fail;


public class ApiUtil {

    /**
     * Constructs the header parameters of the API
     *
     * @return Key-value pair of headers parameters in Map
     */
    public static Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Accept", "application/json");
        headers.put("Content-Type","application/json");
        return headers;
    }

    /**
     * Returns the dataTable data in the form of Map
     *
     * @param table dataTable
     * @return dataTable data in Map
     */
    public Map<String, String> returnMap(DataTable table) {
        Map<String, String> dataMap = new HashMap<>();
        List<List<String>> UserDetails = table.raw();
        for (List<String> detail : UserDetails) {
            dataMap.put(detail.get(0), detail.get(1));
        }
        return dataMap;
    }

    /**
     * This implementation method updates the existing json file content with map of data passed to
     * the method
     *
     * @param fileName   name of the request file
     * @return updated json file data in String
     *
     *
     */

    public String readJsonFile(String fileName){
        try {
            byte[] jsonData = Files.readAllBytes(Paths.get(JSON_REQUEST_PATH + fileName + ".json"));
            //create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();
            //read JSON like DOM Parser
            JsonNode rootNode = objectMapper.readTree(jsonData);
            return rootNode.toString();

    } catch (IOException exe) {
        fail("Exception occured", exe);
    }
    return null;
    }
}
