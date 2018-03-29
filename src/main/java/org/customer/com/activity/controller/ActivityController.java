package org.customer.com.activity.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.customer.com.activity.service.ActivityService;
import org.customer.com.util.resultJson.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "activity",description = "活动")
@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService service;

    @ApiOperation(
            value = "查询多个活动并且分页",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(
            value = "/activity/page/{pageNow}/{pageSize}/{classification}",
            method = RequestMethod.GET)
    public ResponseResult page(@PathVariable int pageNow,
                               @PathVariable int pageSize,
                               @PathVariable String classification){
        return service.page(pageNow,pageSize,classification);
    }

    @ApiOperation(
            value = "查询单个活动",
            response = ResponseResult.class,
            httpMethod = "GET")
    @RequestMapping(
            value = "/activity/getByUuid/{uuid}",
            method = RequestMethod.GET)
    public ResponseResult getByUuid(@PathVariable(value = "uuid") String uuid){
        return service.getByUuid(uuid);
    }
}
