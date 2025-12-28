package kyjtheyj.lecture.dto;

import java.time.LocalDateTime;

public record CreateUserResponse(Long id
        , String name
        , String email
        , String address
        , LocalDateTime createdAt
        , LocalDateTime updatedAt) {
}
