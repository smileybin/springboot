package com.koscom.springboot.service;

import com.koscom.springboot.domain.posts.Posts;
import com.koscom.springboot.domain.posts.PostsRepository;
import com.koscom.springboot.web.dto.posts.PostsResponseDto;
import com.koscom.springboot.web.dto.posts.PostsSaveRequestDto;
import com.koscom.springboot.web.dto.posts.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;

@Service //spring bean 등록 및 Service class 선언
@RequiredArgsConstructor //final로 선언된 필드들은 생성자 항목으로 자동 포함시켜서 생성자 생성
public class PostsService {
    private final PostsRepository postsRepository;

    //등록
    @Transactional
    public Long save(PostsSaveRequestDto requestDto)
    {
        Posts posts = postsRepository.save(requestDto.toEntity());
        return posts.getId();
    }

    //수정
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto dto)
    {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자는 없습니다. id="+id));

        entity.update(dto.getTitle(),dto.getContent());

        return entity.getId();
    }

    // 조회
    public PostsResponseDto findById (Long id)
    {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자는 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }
}
