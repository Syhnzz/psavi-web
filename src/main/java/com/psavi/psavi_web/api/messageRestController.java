package com.psavi.psavi_web.api;

import com.psavi.core.entity.Message;
import com.psavi.core.service.message.messageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class messageRestController {

    @Autowired
    private messageService messageService;

    @GetMapping("/discussions/{discussionId}")
    public List<Message> getMessagesByDiscussion(@PathVariable Integer discussionId) {
        return messageService.getByDiscussionId(discussionId);
    }

    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        return messageService.create(message);
    }
}

