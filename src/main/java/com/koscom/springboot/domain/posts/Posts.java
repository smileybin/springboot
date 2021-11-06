package com.koscom.springboot.domain.posts;

import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //making default constructor opt
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 채번 방식
    private Long id; //pk (auto increment, bigint)

    @Column(length = 500, nullable = false) //varchar(500), not null
    private String title;

    @Column(length = 2000, nullable = false) //varchar(2000), not null
    private String content;

    private String author; //@Column 없으면 varchar(255), nullable = true -> default value

    @Builder //lombok builder
    public Posts(String title, String content, String author) { //id 제외 필드값 있는 생성자
        this.title = title;
        this.content = content;
        this.author = author;
    }

    //update에서는 title, content만 수정가능하고, author는 불가하다.
    //수정일자도 신규로 생성된다.
    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }
}
