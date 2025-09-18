package com.sparta.memo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Timestamped {

    //추상 클래스인 이유는?
    //이 자체를 객체로 생성할 일은 없이 상속만 시킬거기 때문에 추상클래스로 씀
    @CreatedDate
    @Column(updatable = false)//생성일자는 처음에만 입력되고 이후에 수정되면 안됨
    @Temporal(TemporalType.TIMESTAMP)
    //Temporal은
    //DATE : 2023-01-01
    //TIME : 20:21:14
    //TIMESTAMP : 2023-01-01 20:21:14 9993939
    //와 같은 시간값들 매핑시 사용
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime modifiedAt;
}