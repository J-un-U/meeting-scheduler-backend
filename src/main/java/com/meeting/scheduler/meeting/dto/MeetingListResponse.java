package com.meeting.scheduler.meeting.dto;

import com.meeting.scheduler.meeting.Meeting;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MeetingListResponse {
    private Long meetingId;
    private String title;
    private String meetingType;
    private String status;
    private LocalDateTime createdAt;

    public static MeetingListResponse from(Meeting meeting) {
        return new MeetingListResponse(
                meeting.getMeetingId(),
                meeting.getTitle(),
                meeting.getMeetingType(),
                meeting.getStatus(),
                meeting.getCreatedAt()
        );
    }
}
