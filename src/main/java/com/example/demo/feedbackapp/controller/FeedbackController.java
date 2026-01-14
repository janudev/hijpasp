package com.feedbackapp.controller;

import com.feedbackapp.dto.FeedbackRequest;
import com.feedbackapp.entity.Feedback;
import com.feedbackapp.service.FeedbackService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "*")
public class FeedbackController {
    
    @Autowired
    private FeedbackService feedbackService;
    
    @PostMapping("/submit")
    public ResponseEntity<Feedback> submitFeedback(
            @Valid @RequestBody FeedbackRequest request) {
        Feedback feedback = feedbackService.saveFeedback(request.getMessage());
        return ResponseEntity.ok(feedback);
    }
    
    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        return ResponseEntity.ok(feedbackService.getAllFeedbacks());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.noContent().build();
    }
}