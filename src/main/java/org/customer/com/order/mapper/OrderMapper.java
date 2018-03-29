package org.customer.com.order.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.customer.com.order.model.OrderModel;

public interface OrderMapper {
    @Insert({"INSERT INTO customer_order_table (uuid,spid,sl,psf,yhqid,zj,address,ddbh,cjtime,account,type) " +
            "VALUES (#{model.uuid},#{model.spid},#{model.sl},#{model.psf},#{model.yhqid},#{model.zj},#{model.address}," +
            "#{model.ddbh},#{model.cjtime},#{model.account},0)"})
    int add(@Param("model")OrderModel model);

    @Select({"SELECT * FROM customer_order_table WHERE account = #{account}"})
    Page<OrderModel> findByCjr(@Param("account") String account);

    @Select({"SELECT * FROM customer_order_table WHERE uuid = #{uuid}"})
    OrderModel findById(@Param("uuid") String uuid);
 }
