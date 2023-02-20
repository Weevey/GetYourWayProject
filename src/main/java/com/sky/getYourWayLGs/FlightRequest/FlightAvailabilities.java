package com.sky.getYourWayLGs.FlightRequest;
import com.amadeus.Amadeus;
import com.amadeus.Response;
import com.amadeus.exceptions.ResponseException;
import com.amadeus.resources.FlightAvailability;

public class FlightAvailabilities {

    public static void main(String[] args) throws ResponseException {

        Amadeus amadeus = Amadeus
                .builder("4DoCEKYpLX4r6rh1QUWPTa4LrfCSvmIk", "Kl1wTf1LricDruPO")
                .build();

        String body = "{\"originDestinations\":[{\"id\":\"1\",\"originLocationCode\":\"ATH\",\"destinationLocationCode\":\"SKG\",\"departureDateTime\":{\"date\":\"2023-08-14\",\"time\":\"21:15:00\"}}],\"travelers\":[{\"id\":\"1\",\"travelerType\":\"ADULT\"}],\"sources\":[\"GDS\"]}";

        FlightAvailability[] flightAvailabilities = amadeus.shopping.availability.flightAvailabilities.post(body);

        if (flightAvailabilities[0].getResponse().getStatusCode() != 200) {
            System.out.println("Wrong status code: " + flightAvailabilities[0].getResponse().getStatusCode());
            System.exit(-1);
        }

        System.out.println(flightAvailabilities[0]);
    }

}