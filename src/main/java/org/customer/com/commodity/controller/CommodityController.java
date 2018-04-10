package org.customer.com.commodity.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.customer.com.commodity.service.CommodityService;
import org.customer.com.util.resultJson.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "commodity",description = "商品")
@RestController
@RequestMapping("/commodity")
public class CommodityController {

    @Autowired
    private CommodityService service;

    @ApiOperation(
            value = "查询多个商品并且分页",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(
            value = "/commodity/page/{paegNow}/{pageSize}/{lm}",
            method = RequestMethod.GET)
    public ResponseResult page(@PathVariable(value = "pageNow") int pageNow,
                               @PathVariable(value = "pageSize") int pageSize,
                               @PathVariable(value = "lm") String lm){
        return service.findAllByPage(pageNow,pageSize,lm);
    }

    @ApiOperation(
            value = "查询单个商品",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(
            value = "/commodity/getByUuid/{uuid}",
            method = RequestMethod.GET)
    public ResponseResult getByUuid(@PathVariable(value = "uuid") String uuid){
        return service.getByUuid(uuid);
    }

    @ApiOperation(
            value = "根据名称查询单个商品",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(
            value = "/commodity/getByName/{name}",
            method = RequestMethod.GET)
    public ResponseResult getByName(@PathVariable(value = "name") String name){
        return service.getByName(name);
    }
}
