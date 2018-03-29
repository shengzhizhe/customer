package org.customer.com.personal.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @name 个人资料
 * @table customer_personal_table
 */
public class PersonalModel implements Serializable {
    //    uuid
    private String uuid;
    //    账户
    @Size(max = 100, message = "账户最大长度为100位")
    private String account;
    //    头像
    private String portrait;
    //    昵称
    @NotBlank(message = "昵称不能为空")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5\\w\\d]{1,8}$", message = "昵称可以使用字母数字或汉字,最大长度为8位")
    private String nickname;
    //    姓
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]{1,20}$", message = "姓 必须是汉字,最大长度为20位")
    private String surname;
    //    名
    @Size(max = 20, message = "名 最大长度为20(考虑少数民族)")
    @Pattern(regexp = "^[\\u4e00-\\u9fa5]{1,20}$", message = "名 必须是汉字,最大长度为20位")
    private String name;
    //    手机
    @NotBlank(message = "手机不能为空")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "请输入正确的手机号格式")
    private String phone;
    //    身份证号,支持15位和18位验证
//    @NotBlank(message = "身份证号必须填写")
    @Pattern(regexp = "(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)", message = "请输入正确的身份证格式")
    private String idno;
    //    性别 Y:男 N:女
    @NotBlank(message = "性别不能为空")
    @Pattern(regexp = "[Y,N]", message = "不支持第三性别")
    private String sex;
    //    地址
    @Size(max = 200, message = "地址最大长度为200位")
    private String address;
    //    qq
    @Pattern(regexp = "^[\\d]{5,12}$", message = "请输入正确格式的qq")
    private String qq;
    //    微信
    @Size(max = 200, message = "微信最大长度为200位")
    private String wechat;
    //    微博
    @Size(max = 200, message = "微博最大长度为200位")
    private String microblog;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdno() {
        return idno;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getMicroblog() {
        return microblog;
    }

    public void setMicroblog(String microblog) {
        this.microblog = microblog;
    }

    public PersonalModel() {
        super();
    }

    public PersonalModel(String uuid,
                         String account,
                         String portrait,
                         String nickname,
                         String surname,
                         String name,
                         String phone,
                         String idno,
                         String sex,
                         String address,
                         String qq,
                         String wechat,
                         String microblog) {
        this.uuid = uuid;
        this.account = account;
        this.portrait = portrait;
        this.nickname = nickname;
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.idno = idno;
        this.sex = sex;
        this.address = address;
        this.qq = qq;
        this.wechat = wechat;
        this.microblog = microblog;
    }
}
