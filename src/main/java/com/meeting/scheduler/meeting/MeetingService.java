package com.meeting.scheduler.meeting;

import com.meeting.scheduler.meeting.dto.CreateMeetingRequest;
import com.meeting.scheduler.meeting.dto.CreateMeetingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MeetingService {

    private final MeetingRepository meetingRepository;

    @Transactional
    public CreateMeetingResponse createMeeting(Long ownerUserId, CreateMeetingRequest request) {

        // meetingType 검증 (지금은 간단히)
        if (!request.getMeetingType().equals("SINGLE_DATE")
                && !request.getMeetingType().equals("DATE_RANGE")) {
            throw new IllegalArgumentException("Invalid meetingType");
        }

        Meeting meeting = Meeting.create(
                request.getTitle(),
                request.getDescription(),
                ownerUserId,
                request.getMeetingType(),
                request.getMaxParticipants()
        );

        Meeting saved = meetingRepository.save(meeting);
        return new CreateMeetingResponse(saved.getMeetingId());
    }
}