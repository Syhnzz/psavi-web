package com.psavi.psavi_web.api;

import com.psavi.core.entity.Discussion;
import com.psavi.core.service.discussion.discussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/discussions")
public class discussionRestController {

    @Autowired
    private discussionService discussionService;

    @GetMapping
    public List<Discussion> getAllDiscussions() {
        return (List<Discussion>) discussionService.getAll();
    }

    @PostMapping
    public Discussion createDiscussion(@RequestBody Discussion discussion) {
        return discussionService.create(discussion);
    }

    @GetMapping("/{id}")
    public Discussion getDiscussion(@PathVariable Integer id) {
        return discussionService.getById(id);
    }
}
