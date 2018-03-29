package org.customer.com.coupon.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.customer.com.coupon.service.CouponService;
import org.customer.com.util.resultJson.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Coupon",description = "优惠券")
@RestController
@RequestMapping("/coupon")
public class CouponController {

    @Autowired
    private CouponService service;

    @ApiOperation(
            value = "查询优惠券",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(
            value = "/coupon/find/findByActivity/{activity}",
            method = RequestMethod.GET)
    public ResponseResult findByActivity (@PathVariable String activity){
        return service.findByActivity(activity);
    }
}
