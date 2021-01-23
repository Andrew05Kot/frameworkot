package com.kot.frameworkot.dal.security;

import java.util.Collection;
import java.util.Map;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import com.kot.frameworkot.dal.entity.user.UserEntity;

public class CustomUser extends DefaultOAuth2User {

    private static final long serialVersionUID = 1L;

    private final transient UserEntity userEntity;

    public CustomUser(UserEntity userEntity, Collection<? extends GrantedAuthority> authorities,
                      Map<String, Object> attributes, String nameAttributeKey) {
        super(authorities, attributes, nameAttributeKey);
        this.userEntity = userEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((userEntity == null) ? 0 : userEntity.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        CustomUser other = (CustomUser) obj;
        if (userEntity == null) {
            if (other.userEntity != null)
                return false;
        } else if (!userEntity.equals(other.userEntity)) {
            return false;
        }
        return true;
    }
}

