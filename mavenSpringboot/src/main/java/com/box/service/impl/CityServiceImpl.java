package com.box.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.box.dao.CityMapper;
import com.box.entity.City;
import com.box.service.CityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityMapper cityMapper;

	@Override
	public PageInfo<City> select(Long id) {
		PageHelper.startPage(1, 2);
		List<City> list = this.cityMapper.selectAll();
		PageInfo<City> page = new PageInfo<City>(list);
		
		System.err.println(list.size());
		City city = new City();
		city.setId(id);
		return page;
	}

}
