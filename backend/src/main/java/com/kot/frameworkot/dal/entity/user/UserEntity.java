package com.kot.frameworkot.dal.entity.user;

import java.util.Objects;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.kot.frameworkot.dal.entity.BaseEntity;

@Getter
@Setter
@ToString
@Document(collection = "users")
public class UserEntity implements BaseEntity {

    @Id
    private String id;
    private String socialId;
    private String firstName;
    private String lastName;
    private String surname;
    private String phoneNumber;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id)
                && Objects.equals(socialId, that.socialId)
                && Objects.equals(lastName, that.lastName)
                && Objects.equals(firstName, that.firstName)
                && Objects.equals(surname, that.surname)
                && Objects.equals(phoneNumber, that.phoneNumber)
                && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, socialId, lastName, firstName, surname, phoneNumber, email);
    }
}
