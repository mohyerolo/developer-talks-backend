package com.dtalks.dtalks.studyroom.service;

import com.dtalks.dtalks.studyroom.dto.StudyRoomRequestDto;
import com.dtalks.dtalks.studyroom.dto.StudyRoomResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudyRoomService {
    public StudyRoomResponseDto createStudyRoom(StudyRoomRequestDto studyRoomRequestDto);

    public StudyRoomResponseDto findStudyRoomById(Long id);

    public Page<StudyRoomResponseDto> findAll(Pageable pageable);

    public StudyRoomResponseDto updateStudyRoom(Long id, StudyRoomRequestDto studyRoomRequestDto);

    public void deleteStudyRoom(Long id);
}