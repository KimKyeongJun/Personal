package com.ktds.movie.web;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieApiController {
	
	/*@GetMapping("/movie/apilist")
	public String viewMovieApiListPage() {
		
		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
		converters.add(new FormHttpMessageConverter());
		converters.add(new StringHttpMessageConverter());
		
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(converters);
		
		MultiValueMap<String,String> map = new LinkedMultiValueMap<String, String>();
		map.add("key", "895f7756a1c6fa04dbca2ee0e70c7445");
		
		String result = restTemplate.postForObject("http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json", map, String.class);
		System.out.println("restController " + result);
		return "movie/apiList";
	}*/

}
