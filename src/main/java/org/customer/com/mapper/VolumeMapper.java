package org.customer.com.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.customer.com.model.VolumeModel;

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
            "insert into " + tableName + " (uuid,account_id,volume_id,times) " +
                    "values (#{model.uuid},#{model.accountId},#{model.volumeId},#{model.times})"
    })
    int save(@Param("model") VolumeModel model);

    /**
     * 领卷记录分页查询
     *
     * @return Page<VolumeModel> 领卷记录的分页实体，按照日期降序排序
     */
    @Select({
            "select uuid,account_id accountId,volume_id volumeId,times from " + tableName + " order by times desc"
    })
    Page<VolumeModel> findAll();

}
