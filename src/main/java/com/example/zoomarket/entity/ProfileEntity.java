package com.example.zoomarket.entity;

import com.example.zoomarket.enums.ProfileRole;
import com.example.zoomarket.enums.ProfileStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
@Entity
@Table(name = "profile")
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String phone;

    @Column
    private String email;

    @Column(name = "full_name")
    private String fullName;


    @Enumerated(value = EnumType.STRING)
    @Column
    private ProfileStatus status=ProfileStatus.NOT_ACTIVE;

    @Enumerated(value = EnumType.STRING)
    @Column
    private ProfileRole role;

    @Column(name = "photo_id")
    private String photoId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "photo_id", insertable = false, updatable = false)
    private AttachEntity photo;

    @Column
    private Boolean visible = true;

    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();


}
