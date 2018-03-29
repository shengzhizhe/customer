package org.customer.com.coupon.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.customer.com.coupon.model.Coupon;

import java.util.List;

public interface CouponMapper {

    @Select({"SELECT * FROM business_coupon_table WHERE activity = #{activity}"})
    List<Coupon> findByActivity(@Param("activity") String activity);
}
