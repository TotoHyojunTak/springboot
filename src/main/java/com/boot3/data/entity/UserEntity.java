package com.boot3.data.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter
@ToString
@Entity
@Table(name = "TB_USERS")
public class UserEntity {
    @Id
    @Column(nullable = false, unique = true)
    private String userId;

    @Column(nullable = false, length = 50)
    private String email;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false)
    private String encryptedPwd;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdDate;

}