package kyjtheyj.lecture.dto;

import java.time.LocalDateTime;

public record UpdateUserRequest(String name, String email, String address, LocalDateTime createAt, LocalDateTime updateAt, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
