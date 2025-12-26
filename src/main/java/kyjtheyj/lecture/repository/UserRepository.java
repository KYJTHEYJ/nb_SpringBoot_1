package kyjtheyj.lecture.repository;

import kyjtheyj.lecture.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // 커스텀 조회
    Optional<User> findByEmail(String email);
    List<User> findAllByAddress(String address);
}
