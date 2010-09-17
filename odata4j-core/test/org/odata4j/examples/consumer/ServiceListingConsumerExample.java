package org.odata4j.examples.consumer;

import org.core4j.Enumerable;
import org.odata4j.consumer.ODataConsumer;
import org.odata4j.examples.BaseExample;
import org.odata4j.examples.ODataEndpoints;

public class ServiceListingConsumerExample extends BaseExample {

  
    public static void main(String[] args) {

        ODataConsumer.DUMP_REQUEST_HEADERS = true;
       // ODataConsumer.DUMP_RESPONSE_BODY = true;
       // ODataConsumer.DUMP_RESPONSE_HEADERS = true;
        
        Enumerable<String> smallServices = Enumerable.create(
                ODataEndpoints.NORTHWIND,ODataEndpoints.ODATA4JSAMPLE_APPSPOT,
                  ODataEndpoints.ODATA_WEBSITE_DATA, ODataEndpoints.ODATA_TEST_SERVICE_READONLY,  ODataEndpoints.NERD_DINNER, 
                  ODataEndpoints.MIX10, ODataEndpoints.TECH_ED, ODataEndpoints.PLURALSIGHT, ODataEndpoints.TELERIK_TV
             
                  );
        Enumerable<String> brokenServices = Enumerable.create(
                ODataEndpoints.CITY_OF_EDMONTON,
                  ODataEndpoints.DEVEXPRESS,
                  ODataEndpoints.BASEBALL_STATS
                  );
        
        Enumerable<String> largeServices = Enumerable.create(
                
                ODataEndpoints.NETFLIX,
                ODataEndpoints.STACK_OVERFLOW,
                ODataEndpoints.SUPER_USER,
                ODataEndpoints.SERVER_FAULT,
                ODataEndpoints.META_STACK_OVERFLOW,
                ODataEndpoints.WORLD_CUP
                  );
        
        
        // print out each entity in every entity-set exposed by small services
        for(String endpoint : smallServices) {
            ODataConsumer c = ODataConsumer.create(endpoint);
            
            for(String entitySet : c.getEntitySets()){
                reportEntities(entitySet,c.getEntities(entitySet).execute());
            }
        }
        
        // print out the first record in each entity set exposed by large services
        for(String endpoint : largeServices) {
            ODataConsumer c = ODataConsumer.create(endpoint);
            
            for(String entitySet : c.getEntitySets()){
                reportEntities(entitySet,c.getEntities(entitySet).top(1).execute());
            }
        }
        
        
       
    }

}