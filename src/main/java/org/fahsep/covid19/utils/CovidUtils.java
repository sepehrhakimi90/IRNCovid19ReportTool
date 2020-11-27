package org.fahsep.covid19.utils;

import org.fahsep.covid19.model.CovidResponse;
import org.fahsep.covid19.model.CovidResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@Component
public class CovidUtils {

    Logger logger = LoggerFactory.getLogger("CovidUtils");

    public Map<String, CovidResult> getCovidData(String country, int numDay) {
        Map<String, CovidResult> response = new HashMap<>();
        Map<String, Integer> confirmed = null;
        Map<String, Integer> recovered = null;
        Map<String, Integer> deaths = null;
        try {
            confirmed = getCovidData("confirmed", country, numDay);
            recovered = getCovidData("recovered", country, numDay);
            deaths = getCovidData("deaths", country, numDay);
        } catch (Exception e) {
            logger.error("Error in fetching data", e);
        }

        for (String key : confirmed.keySet()) {
            CovidResult result = new CovidResult();
            result.setConfirmed(confirmed.get(key));
            result.setRecovered(recovered.get(key));
            result.setDeaths(deaths.get(key));
            response.put(key, result);
        }

        return response;
    }

    private Map<String, Integer> getCovidData(String status, String country, int days) throws Exception {

        Map<String, Integer> returnMap = new HashMap<>();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        String toDate = LocalDate.now().format(formatter);
        String fromDate = LocalDate.now().minusDays(days).format(formatter);


        String url = "https://api.covid19api.com/country/{country}/status/{status}?from={fromDate}&to={toDate}";
        SimpleClientHttpRequestFactory cl = new SimpleClientHttpRequestFactory();
        cl.setConnectTimeout(1000);
        cl.setReadTimeout(3000);
        RestTemplate template = new RestTemplate(cl);
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("country", country);
        uriVariables.put("status", status);
        uriVariables.put("fromDate", fromDate);
        uriVariables.put("toDate", toDate);
        CovidResponse[] responses = template.getForObject(url, CovidResponse[].class, uriVariables);


        for (CovidResponse response : responses) {
            returnMap.putIfAbsent(response.getDate(), response.getCases());
        }

        return returnMap;
    }
}
