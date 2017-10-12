package com.box.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.box.service.CityService;
import com.box.util.Json;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api(tags={"测试接口"})
@RestController
@RequestMapping("/helloController")
public class HelloController {

	protected static final Logger LOG = Logger.getLogger(HelloController.class);

	@Autowired
	private CityService cityService;

	@ApiOperation(value = "测试文档", notes = "根据id获取信息")
	@ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public Json hello(Long id) {
		LOG.info("/tese.json进入");
		Json json = new Json();
		try {
			json.setData(this.cityService.select(id));
			json.setReturnCode(Json.SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			json.setMessage(e.getMessage());
			json.setReturnCode(Json.ERROR);
		}
		return json;
	}
}
