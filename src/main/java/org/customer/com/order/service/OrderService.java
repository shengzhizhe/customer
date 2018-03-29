package org.customer.com.order.service;

import org.customer.com.order.model.OrderModel;
import org.customer.com.util.resultJson.ResponseResult;

public interface OrderService {
    ResponseResult add(OrderModel model);
    ResponseResult findByCjr(int pageNow,int pageSize,String account);
    ResponseResult findById(String uuid);
}
