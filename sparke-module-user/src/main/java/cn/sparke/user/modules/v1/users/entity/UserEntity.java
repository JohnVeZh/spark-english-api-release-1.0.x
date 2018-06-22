package cn.sparke.user.modules.v1.users.entity;

import cn.sparke.core.common.bean.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by zhangbowen on 2017/7/10.
 */
public class UserEntity extends BaseEntity{
    private String phone;
    private String password;
    private String qqOpenId;
    private String weixinOpenId;
    private String weiboOpenId;
    private String headerImg;
    private String nickname;
    private int sex;
    private String realName;
    private Integer userStatus;
    private String schoolName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date enrollYear;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;
    private int regType;
    private int isPush;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginDate;
    private int sectionCode;
    private int isAutoRemove;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQqOpenId() {
        return qqOpenId;
    }

    public void setQqOpenId(String qqOpenId) {
        this.qqOpenId = qqOpenId;
    }

    public String getWeixinOpenId() {
        return weixinOpenId;
    }

    public void setWeixinOpenId(String weixinOpenId) {
        this.weixinOpenId = weixinOpenId;
    }

    public String getWeiboOpenId() {
        return weiboOpenId;
    }

    public void setWeiboOpenId(String weiboOpenId) {
        this.weiboOpenId = weiboOpenId;
    }

    public String getHeaderImg() {
        return headerImg;
    }

    public void setHeaderImg(String headerImg) {
        this.headerImg = headerImg;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public Date getEnrollYear() {
        return enrollYear;
    }

    public void setEnrollYear(Date enrollYear) {
        this.enrollYear = enrollYear;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getRegType() {
        return regType;
    }

    public void setRegType(int regType) {
        this.regType = regType;
    }

    public int getIsPush() {
        return isPush;
    }

    public void setIsPush(int isPush) {
        this.isPush = isPush;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public int getSectionCode() {
        return sectionCode;
    }

    public void setSectionCode(int sectionCode) {
        this.sectionCode = sectionCode;
    }

    public int getIsAutoRemove() {
        return isAutoRemove;
    }

    public void setIsAutoRemove(int isAutoRemove) {
        this.isAutoRemove = isAutoRemove;
    }
}
