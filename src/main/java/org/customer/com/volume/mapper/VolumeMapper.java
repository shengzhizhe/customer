package org.customer.com.volume.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.customer.com.volume.model.VolumeModel;

import java.util.List;

/**
 * @name 用户领卷记录
 */
public interface VolumeMapper {

    String tableName = " volume_table ";

    /**
     * 新增领卷记录
     *
     * @param model VolumeModel 领卷记录实体
     * @return int >= 0 操作成功
     */
    @Insert({
            "insert into " + tableName + " (uuid,account_id,activity,type_id,number,receive_times,use,use_times) " +
                    "values (#{model.uuid},#{model.accountId},#{model.activity},#{model.typeId},#{model.number}," +
                    "#{model.receiveTimes},#{model.use},#{model.useTimes})"
    })
    int save(@Param("model") VolumeModel model);

    /**
     * 领卷记录分页查询
     *
     * @return Page<VolumeModel> 领卷记录的分页实体，按照领取日期降序排序
     */
    @Select({
            "select uuid,account_id accountId,activity,type_id typeId,number,receive_times receiveTimes,use,use_times useTimes " +
                    " from " + tableName + " where use = #{use} order by receiveTimes desc"
    })
    Page<VolumeModel> findAll(@Param("use") String use);

    /**
     * 根据活动和账户查询是否有卷，并返回领卷记录实体
     *
     * @return List<VolumeModel> 领卷记录的实体集合，按照领取日期降序排序
     */
    @Select({
            "select uuid,account_id accountId,activity,type_id typeId,number,receive_times receiveTimes,use,use_times useTimes " +
                    " from " + tableName + " where activity = #{activity} and account_id = #{accountId} " +
                    " and use = #{use} order by receiveTimes desc"
    })
    List<VolumeModel> findByActivity(@Param("activity") String activity,
                                     @Param("accountId") String accountId,
                                     @Param("use") String use);

}
