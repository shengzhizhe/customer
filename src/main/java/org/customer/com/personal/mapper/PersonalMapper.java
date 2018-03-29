package org.customer.com.personal.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.customer.com.personal.model.PersonalModel;

/**
 * @name 个人资料
 */
public interface PersonalMapper {

    String tableName = " customer_personal_table ";

    /**
     * 新增个人资料
     *
     * @param model PersonalModel 个人资料实体
     * @return int >= 0 操作成功
     */
    @Insert({
            "insert into " + tableName + " (uuid,account,portrait,nickname,surname,name,phone,idno,sex,address,qq," +
                    "wechat,microblog) " +
                    "values (#{model.uuid},#{model.account},#{model.portrait},#{model.nickname},#{model.surname}," +
                    "#{model.name},#{model.phone},#{model.idno},#{model.sex},#{model.address},#{model.qq}," +
                    "#{model.wechat},#{model.microblog})"
    })
    int save(@Param("model") PersonalModel model);

    /**
     * 根据id删除个人资料
     *
     * @param id String id
     * @return int >= 0 操作成功
     */
    @Delete({
            "delete from " + tableName + " where uuid = #{id}"
    })
    int delete(@Param("id") String id);

    /**
     * 根据账户修改个人资料
     *
     * @param model PersonalModel 个人资料实体
     * @return int >= 0 操作成功
     */
    @Update({
            "update " + tableName + " set portrait=#{model.portrait}," +
                    "nickname=#{model.nickname}," +
                    "surname=#{model.surname}," +
                    "name=#{model.name}," +
                    "phone=#{model.phone}," +
                    "idno=#{model.idno}," +
                    "sex=#{model.sex}," +
                    "address=#{model.address}," +
                    "qq=#{model.qq}," +
                    "wechat=#{model.wechat}," +
                    "microblog=#{model.microblog} " +
                    " where account = #{model.account}"
    })
    int update(@Param("model") PersonalModel model);

    /**
     * 个人资料分页查询
     *
     * @return Page<PersonalModel> 个人资料的分页实体，按照账户升序排序
     */
    @Select({
            "select * from " + tableName + " order by account"
    })
    Page<PersonalModel> findAll();

    /**
     * 根据id查询个人资料实体
     *
     * @param id String 个人资料实体id
     * @return PersonalModel 个人资料实体
     */
    @Select({
            "select * from " + tableName + " where uuid = #{id}"
    })
    PersonalModel getById(@Param("id") String id);

    /**
     * 根据账户查询个人资料实体
     *
     * @param account String 账户名称
     * @return PersonalModel 个人资料实体
     */
    @Select({
            "select * from " + tableName + " where account = #{account}"
    })
    PersonalModel getByAccount(@Param("account") String account);

    /**
     * 根据昵称查询个人资料实体
     *
     * @param nickname String 昵称
     * @return PersonalModel 个人资料实体
     */
    @Select({
            "select * from " + tableName + " where nickname = #{nickname}"
    })
    PersonalModel getByNickname(@Param("nickname") String nickname);
}
