package com.meeting.scheduler.meeting.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;

@Getter
public class CreateMeetingRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String description;

    @NotBlank
    private String meetingType; // SINGLE_DATE, DATE_RANGE

    @Positive
    private int maxParticipants;
}
