package com.service.extenal.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.service.model.Hotel;

@FeignClient(name = "HOTELMICROSERVICE")
public interface HotelService {

	@GetMapping("/getByid/{id}")
	public Hotel getHotelByID(@PathVariable String id);

}
