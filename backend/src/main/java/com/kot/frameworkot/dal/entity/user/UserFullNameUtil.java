package com.kot.frameworkot.dal.entity.user;

public class UserFullNameUtil {

    public static String getFullUserName(UserEntity userEntity) {
        return userEntity.getFirstName() + " " + userEntity.getLastName();
    }
}