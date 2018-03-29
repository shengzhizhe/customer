package org.customer.com.order.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.customer.com.order.model.OrderModel;
import org.customer.com.order.service.OrderService;
import org.customer.com.util.resultJson.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "Order",description = "订单")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @ApiOperation(
            value = "创建订单",
            response = ResponseResult.class,
            httpMethod = "POST")
    @RequestMapping(
            value = "/order/add",
            method = RequestMethod.POST)
    public ResponseResult add(@Valid @RequestBody OrderModel model){
        return service.add(model);
    }

    @ApiOperation(
            value = "根据创建人查询订单",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(
            value = "/order/page/{pageNow}/{pageSize}/{account}",
            method = RequestMethod.GET)
    public ResponseResult page(@PathVariable(value = "pageNow") int pageNow,
                               @PathVariable(value = "pageSize") int pageSize,
                               @PathVariable String account){
        return service.findByCjr(pageNow,pageSize,account);
    }

    @ApiOperation(
            value = "根据订单id查询订单",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(
            value = "/order/find/id/{uuid}",
            method = RequestMethod.GET)
    public ResponseResult findById(@PathVariable String uuid){
        return service.findById(uuid);
    }
}
