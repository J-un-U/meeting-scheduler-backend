package com.meeting.scheduler.meeting;

import com.meeting.scheduler.meeting.dto.CreateMeetingRequest;
import com.meeting.scheduler.meeting.dto.CreateMeetingResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Json형태 객체 데이터 반환
@RequiredArgsConstructor //생성자 자동 주입
@RequestMapping("api/meetings") //HTTP Request URL을 특정 클래스 및 메소드로 연결
public class MeetingController {

    private final MeetingService meetingService;

    //임시 userId
    private Long getCurrentUserId() {
        return 1L;
    }

    @PostMapping
    public CreateMeetingResponse createMeeting(
            @RequestBody @Valid CreateMeetingRequest request
    ) {
        return meetingService.createMeeting(getCurrentUserId(), request);
    }
}
