package com.dtalks.dtalks.admin.post.controller;

import com.dtalks.dtalks.admin.post.dto.AdminPostDto;
import com.dtalks.dtalks.admin.post.service.AdminPostService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/post")
public class AdminPostController {
    private final AdminPostService adminPostService;

    @Operation(summary = "관리자에 의해 삭제 처리 되지 않은 게시글들 조회 (전체 조회랑 마찬가지) (size=10, sort=id,desc 적용)")
    @GetMapping("/all")
    public ResponseEntity<Page<AdminPostDto>> getAllPosts(
            @PageableDefault(size = 10, sort = "id",  direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(adminPostService.getAllPosts(pageable));
    }

    @Operation(summary = "관리자에 의해 삭제된 게시글들 조회 (size=10, sort=id,desc 적용)")
    @GetMapping("/all/removed")
    public ResponseEntity<Page<AdminPostDto>> getAllRemovedPosts(
            @PageableDefault(size = 10, sort = "id",  direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(adminPostService.getAllRemovedPosts(pageable));
    }

    @Operation(summary = "게시글 삭제 처리 (forbidden이 true로 바뀜, 사용자 접근 불가능으로 바뀜)")
    @PutMapping("/remove/{id}")
    public ResponseEntity<Void> removePost(@PathVariable Long id) {
        adminPostService.removePost(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "게시글 복구 처리 (forbidden이 false로 바뀜, 사용자 접근 가능해짐)")
    @PutMapping("/restore/{id}")
    public ResponseEntity<Void> restorePost(@PathVariable Long id) {
        adminPostService.restorePost(id);
        return ResponseEntity.ok().build();
    }
}