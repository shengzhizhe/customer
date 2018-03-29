package org.customer.com.activity.service;

import org.customer.com.util.resultJson.ResponseResult;

public interface ActivityService {

    ResponseResult page(int pageNow,int pageSize,String classification);

    ResponseResult getByUuid(String uuid);
}
