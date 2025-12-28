package kyjtheyj.lecture.service;

import kyjtheyj.lecture.dto.*;
import kyjtheyj.lecture.entity.User;
import kyjtheyj.lecture.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public CreateUserResponse save(CreateUserRequest request) {
        User user = new User(request.name(), request.email(), request.address());
        User savedUser = userRepository.save(user);

        return new CreateUserResponse(savedUser.getId()
                , savedUser.getName()
                , savedUser.getEmail()
                , savedUser.getAddress()
                , savedUser.getCreatedAt()
                , savedUser.getUpdatedAt());
    }

    @Transactional(readOnly = true)
    public GetOneUserResponse getOne(Long id) {
        User findUser = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("없는 유저!"));
        return new GetOneUserResponse(findUser.getId()
                , findUser.getName()
                , findUser.getEmail()
                , findUser.getAddress()
                , findUser.getCreatedAt()
                , findUser.getUpdatedAt());
    }

    @Transactional(readOnly = true)
    public List<GetOneUserResponse> getAll() {
        List<User> all = userRepository.findAll();
        List<GetOneUserResponse> responses = new ArrayList<>();
        for (User user : all) {
            responses.add(new GetOneUserResponse(user.getId()
                    , user.getName()
                    , user.getEmail()
                    , user.getAddress()
                    , user.getCreatedAt()
                    , user.getUpdatedAt()));
        }

        return responses;
    }

    // 더티체킹을 통한 update
    // 영속성인 엔티티 객체의 필드를 변경하면 자동으로 업데이트가 됨!
    @Transactional
    public UpdateUserResponse update(Long id, UpdateUserRequest request) {
        User findUser = userRepository.findById(id).orElseThrow(() -> new IllegalStateException("없는 유저!"));

        findUser.update(request.name(), request.email(), request.address());

        return new UpdateUserResponse(findUser.getId()
                , findUser.getName()
                , findUser.getEmail()
                , findUser.getAddress()
                , findUser.getCreatedAt()
                , findUser.getUpdatedAt());
    }

    @Transactional
    public void delete(Long id) {
        // 조회는 안하고 존재 자체만 확인하는 existsBy
        if (!userRepository.existsById(id)) {
            throw new IllegalStateException("없는 유저!");
        }

        userRepository.deleteById(id);
    }
}
