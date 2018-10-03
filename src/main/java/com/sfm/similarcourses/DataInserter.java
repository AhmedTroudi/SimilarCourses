package com.sfm.similarcourses;


import com.google.common.collect.ImmutableList;
import org.apache.predictionio.sdk.java.Event;
import org.apache.predictionio.sdk.java.EventClient;


public class DataInserter {

    private static final String API_KEY = "pbH7nucjN4EUdBzP-r_GP5jXJtkNk9M_Mr9KABF0xQYmicx1-Y9PBNA4JcEC4IBL";
    private static final String SERVER_URL = "http://localhost:7070";



    public static void main(String[] args) throws Exception {


        EventClient client = null;
        try {
            client = new EventClient(API_KEY, SERVER_URL);
            Event userEvent = new Event()
                    .event("$set")
                    .entityType("user")
                    .entityId("u0")
                    .property("prop0", "value");

            Event userEvent2 = new Event()
                    .event("$set")
                    .entityType("user")
                    .entityId("u1")
                    .property("prop1", "value");

            Event userEvent3 = new Event()
                    .event("$set")
                    .entityType("user")
                    .entityId("u2")
                    .property("prop2", "value");

            client.createEvent(userEvent);
            client.createEvent(userEvent2);
            client.createEvent(userEvent3);

            Event itemEvent = new Event()
                    .event("$set")
                    .entityType("item")
                    .entityId("i0")
                    .property("categories", ImmutableList.of("c1","c2"));

            Event itemEvent2 = new Event()
                    .event("$set")
                    .entityType("item")
                    .entityId("i1")
                    .property("categories", ImmutableList.of("c1","c2"));

            Event itemEvent3 = new Event()
                    .event("$set")
                    .entityType("item")
                    .entityId("i2")
                    .property("categories", ImmutableList.of("c1","c2"));
            client.createEvent(itemEvent);
            client.createEvent(itemEvent2);
            client.createEvent(itemEvent3);

            Event viewEvent = new Event()
                    .event("view")
                    .entityType("user")
                    .entityId("u0")
                    .targetEntityType("item")
                    .targetEntityId("i0");
            client.createEvent(viewEvent);

            Event viewEvent2 = new Event()
                    .event("view")
                    .entityType("user")
                    .entityId("u1")
                    .targetEntityType("item")
                    .targetEntityId("i0");
            client.createEvent(viewEvent2);
            System.out.println(viewEvent);
            System.out.println(viewEvent2);

            System.out.println("Events Created Successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            client.close();
        }




    }
}
