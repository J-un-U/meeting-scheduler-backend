package com.meeting.scheduler.meeting;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity //엔티티 지정
@Table(name = "meeting") //테이블 연결
@Getter //Getter 메서드 자동 생성
@NoArgsConstructor(access = AccessLevel.PROTECTED) //생성자 자동 생성 단, 무분별 생성 제한
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meetingId;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Long ownerUserId;

    @Column(nullable = false, length = 20)
    private String meetingType; // SINGLE_DATE, DATE_RANGE

    @Column(nullable = false)
    private int maxParticipants;

    private LocalDate agreedDate;

    private LocalDate agreedStartDate;
    private LocalDate agreedEndDate;

    private LocalTime startTime;
    private LocalTime endTime;

    @Column(nullable = false, length = 20)
    private String status; // OPEN, CONFIRMED, CLOSED

    private LocalDateTime confirmedAt;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    public static Meeting create(
            String title,
            String description,
            Long ownerUserId,
            String meetingType,
            int maxParticipants
    ) {
        Meeting meeting = new Meeting();
        meeting.title = title;
        meeting.description = description;
        meeting.ownerUserId = ownerUserId;
        meeting.meetingType = meetingType;
        meeting.maxParticipants = maxParticipants;
        meeting.status = "OPEN";
        meeting.createdAt = LocalDateTime.now();
     return meeting;
    }
}
