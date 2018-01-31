package org.customer.com.service;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.customer.com.model.VolumeModel;
import org.customer.com.util.resultJson.ResponseResult;

public interface VolumeService {
    /**
     * 新增领卷记录
     *
     * @param model VolumeModel 领卷记录实体
     * @return int >= 0 操作成功
     */
    ResponseResult<VolumeModel> save(@Param("model") VolumeModel model);

    /**
     * 领卷记录分页查询
     *
     * @return Page<VolumeModel> 领卷记录的分页实体，按照日期降序排序
     */
    ResponseResult<Page<VolumeModel>> findAll(int now, int size);
}
