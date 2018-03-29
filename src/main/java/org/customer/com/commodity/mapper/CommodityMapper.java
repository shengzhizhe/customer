package org.customer.com.commodity.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.customer.com.commodity.model.CommodityModel;

public interface CommodityMapper {
    @Select({"SELECT * FROM business_commodity_table WHERE lm = #{lm}"})
    Page<CommodityModel> findAllByPage(@Param("lm") String lm);
    @Select({"SELECT * FROM business_commodity_table WHERE uuid = #{uuid}"})
    CommodityModel getByUuid(@Param("uuid") String uuid);
}
