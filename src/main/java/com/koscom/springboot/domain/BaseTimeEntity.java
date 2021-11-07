package com.koscom.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;


//Auditing: createAt /updateAt / createUser / updateUser 자동으로 관리 해주는 기능

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate //등록시간
    private LocalDateTime createdDate;

    @LastModifiedDate //수정시간
    private LocalDateTime modifiedDate;

}