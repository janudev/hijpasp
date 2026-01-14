package com.feedbackapp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class FeedbackRequest {
    @NotBlank(message = "Message cannot be empty")
    @Size(max = 1000, message = "Message too long")
    private String message;
}