package com.koscom.springboot.web;


import com.koscom.springboot.service.PostsService;
import com.koscom.springboot.web.dto.posts.PostsSaveRequestDto;
import com.koscom.springboot.web.dto.posts.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController

public class PostsApiController {
    private  final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/api/vi/posts/{id}") //put은 전체 교체
    public Long update (@PathVariable Long id, @RequestBody PostsUpdateRequestDto dto)
    {
        return postsService.update(id,dto);
    }
}
