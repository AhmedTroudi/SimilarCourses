package com.sfm.similarcourses;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonObject;
import org.apache.predictionio.sdk.java.EngineClient;

public class CourseRecommender {

    public static void main(String[] args) throws Exception {

        EngineClient engineClient = null;
        try {
            engineClient = new EngineClient("http://localhost:8000");
            JsonObject response = engineClient.sendQuery(ImmutableMap.<String, Object>of(
                    "items", ImmutableList.of("i1"),
                    "num",  4));
            System.out.println(response);
        } finally {
            engineClient.close();
        }


    }
}
