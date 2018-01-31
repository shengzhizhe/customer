package org.customer.com.service;

import com.github.pagehelper.Page;
import org.customer.com.model.PersonalModel;
import org.customer.com.util.resultJson.ResponseResult;

/**
 * @name 个人资料
 */
public interface PersonalService {
    /**
     * 新增个人资料
     *
     * @param model PersonalModel 个人资料实体
     * @return ResponseResult<PersonalModel>
     */
    ResponseResult<PersonalModel> save(PersonalModel model);

    /**
     * 根据id删除个人资料
     *
     * @param id String id
     * @return ResponseResult<PersonalModel>
     */
    ResponseResult<PersonalModel> delete(String id);

    /**
     * 根据账户修改个人资料
     *
     * @param model PersonalModel 个人资料实体
     * @return ResponseResult<PersonalModel>
     */
    ResponseResult<PersonalModel> update(PersonalModel model);

    /**
     * 个人资料分页查询
     *
     * @return ResponseResult<Page<PersonalModel>>
     */
    ResponseResult<Page<PersonalModel>> findAll(int now,int size);

    /**
     * 根据id查询个人资料实体
     *
     * @param id String 个人资料实体id
     * @return ResponseResult<PersonalModel>
     */
    ResponseResult<PersonalModel> getById(String id);

    /**
     * 根据账户查询个人资料实体
     *
     * @param account String 账户名称
     * @return ResponseResult<PersonalModel>
     */
    ResponseResult<PersonalModel> getByAccount(String account);
}
