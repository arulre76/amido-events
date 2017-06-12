package com.eventful;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.evdb.javaapi.data.SearchResult;
import com.weatherlibrary.datamodel.Forecast;
import com.weatherlibrary.datamodel.Location;

@Controller
public class EventController {

	private static String EVENT_API_URL="http://api.eventful.com/rest/events/search?app_key=h8VhXx6DqM8DXfsj&keywords=music&date=future&location=";
	private static String APIXU_WEATHER_FORECAST_API_URL="http://api.apixu.com/v1/forecast.json?key=b22eb4b9958f417694e183601171106&q=";

	@RequestMapping("/events/{location}")
	public String welcome(Map<String, Object> model, @PathVariable(value="location", required=false) String location) {

		model.put("eventResult", searchLondonEvents(location));
		return "events";
	}

	private SearchResult searchLondonEvents(String location) {
		
		RestTemplate restTemplate = new RestTemplate();
		String eventSearchUrl = EVENT_API_URL + location;
		SearchResult result = restTemplate.getForObject(eventSearchUrl, SearchResult.class);
		//findWeatherContidion(location);
		return result;
	}
	
//	public String findWeatherContidion(String location) {
//		
//		RestTemplate restTemplate = new RestTemplate();
//		String weather_forecast_Url = APIXU_WEATHER_FORECAST_API_URL + location;
//		Location forecast = restTemplate.getForObject(weather_forecast_Url, Location.class);
//		System.out.println(forecast.toString());
//		return forecast.toString();
//	}
}
