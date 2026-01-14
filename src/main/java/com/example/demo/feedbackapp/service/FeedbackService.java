package com.feedbackapp.service;

import com.feedbackapp.entity.Feedback;
import com.feedbackapp.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FeedbackService {
    
    @Autowired
    private FeedbackRepository feedbackRepository;
    
    public Feedback saveFeedback(String message) {
        Feedback feedback = new Feedback();
        feedback.setMessage(message);
        return feedbackRepository.save(feedback);
    }
    
    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAllByOrderByCreatedAtDesc();
    }
    
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}