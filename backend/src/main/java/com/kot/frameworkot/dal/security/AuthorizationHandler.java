package com.kot.frameworkot.dal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import com.kot.frameworkot.dal.entity.user.UserEntity;
import com.kot.frameworkot.dal.entity.user.UserRole;
import com.kot.frameworkot.dal.service.user.UserService;

@Service
public class AuthorizationHandler {

    public static final String USER_ID_ATTRIBUTE = "user_id";

    private static final String ID = "id";
    private static final String EMAIL = "email";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String NAME = "name";

    @Autowired
    private UserService userService;

    public UserEntity createUser(Map<String, Object> facebookUserAttributes, String accessToken) {
        return saveUserEntity(facebookUserAttributes);
    }

    UserEntity saveUserEntity(Map<String, Object> facebookUserAttributes) {
        UserEntity user = new UserEntity();
        user.setSocialId(facebookUserAttributes.get(ID).toString());

        Map<String, String> splitName = splitName(facebookUserAttributes.get(NAME).toString());

        user.setFirstName(splitName.get(FIRST_NAME));
        user.setLastName(splitName.get(LAST_NAME));
        if (facebookUserAttributes.get(EMAIL) != null) {
            user.setEmail(facebookUserAttributes.get(EMAIL).toString());
        }
        user.setRole(UserRole.ROLE_USER);

        return userService.create(user);
    }

    private Map<String, String> splitName(String name) {
        Map<String, String> nameArray = new HashMap<>();

        if (name.contains(" ")) {
            String[] arr = name.split(" ");
            nameArray.put(FIRST_NAME, arr[0]);
            nameArray.put(LAST_NAME, arr[1]);
        } else {
            nameArray.put(LAST_NAME, name);
            nameArray.put(FIRST_NAME, "");
        }
        return nameArray;
    }

}