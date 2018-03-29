package org.customer.com.activity.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.customer.com.activity.model.Activity;

public interface ActivityMapper {
    @Select({"SELECT * FROM business_activity_table WHERE classification = #{classification}"})
    Page<Activity> page(@Param("classification") String classification);

    @Select({"SELECT * FROM business_activity_table WHERE uuid = #{uuid}"})
    Activity getByUuid(@Param("uuid") String uuid);
}
