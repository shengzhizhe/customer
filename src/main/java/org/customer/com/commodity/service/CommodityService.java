package org.customer.com.commodity.service;

import org.customer.com.util.resultJson.ResponseResult;

public interface CommodityService {

    ResponseResult findAllByPage(int pageNow,int pageSize,String lm);

    ResponseResult getByUuid(String uuid);
}
