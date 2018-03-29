package org.customer.com.coupon.service;

import org.customer.com.util.resultJson.ResponseResult;


public interface CouponService {
    ResponseResult findByActivity (String activity);
}
