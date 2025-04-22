package com.psavi.psavi_web.api;

import com.psavi.core.entity.Discussion;
import com.psavi.core.service.discussion.discussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/discussions")
public class discussionRestController {

    @Autowired
    private discussionService discussionService;

    @PostMapping
    public Discussion createDiscussion(@RequestBody Discussion discussion) {
        return discussionService.create(discussion);
    }

    @GetMapping("/{id}")
    public Discussion getDiscussion(@PathVariable Integer id) {
        return discussionService.getById(id);
    }

    @GetMapping
    public Page<Discussion> getAllDiscussions(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size) {
        return discussionService.getAll(page, size);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDiscussion(@PathVariable Integer id) {
        boolean deleted = discussionService.deleteIfOwner(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Vous n'êtes pas autorisé à supprimer cette discussion.");
        }
    }

}
