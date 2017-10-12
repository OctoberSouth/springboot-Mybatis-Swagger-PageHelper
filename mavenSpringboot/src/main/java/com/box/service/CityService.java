package com.box.service;

import com.box.entity.City;
import com.github.pagehelper.PageInfo;

public interface CityService {
	
	PageInfo<City> select(Long id);
}
