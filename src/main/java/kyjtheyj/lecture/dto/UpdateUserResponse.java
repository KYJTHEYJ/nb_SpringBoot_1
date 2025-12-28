package kyjtheyj.lecture.dto;

import java.time.LocalDateTime;

public record UpdateUserResponse(Long id, String name, String email, String address, LocalDateTime createAt, LocalDateTime updateAt) {
}
