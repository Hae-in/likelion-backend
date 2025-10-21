package com.example.springjdbc.friendapp.service;

import com.example.springjdbc.friendapp.domain.Friend;
import com.example.springjdbc.friendapp.repository.FriendRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FriendService {
    private final FriendRepository friendRepository;

    public FriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }
    // Controller에서 구현한 메서드 사용
    // 나중에 serviceImpl 구현해보기

    // 서비스와 레파지토리의 구분이 모호??
    // 실제 레파지토리는 DB에 저장 조회 삭제 수정만 함 -> 비지니스 로직이 없음
    // ex) 회원가입 - 14세 이상만 회원으로 받겠다. 의 판단 -> 서비스
    // - 서비스: 회원가입해줘()
    // - 레파지토리: 회원정보저장해줘()

    // 대체로 서비스에서 그냥 레파지토리만 이용하고 있는 경우가 많다.
    // 실제 좀 더 복잡한 어플리케이션에서는 가장 중요한 부분은 서비스.

    // ✅ Repository (저장소 계층)
    // - 역할: 데이터를 저장하고 조회하는 것 자체에 집중
    // - 관심사: “데이터를 어떻게 다룰까?”
    // - DB, CRUD, SQL, JPA 등 데이터 접근 관련 코드
    // - 파일, 외부 API 등 저장소와의 통신
    // - 비즈니스 로직 없음 → 단순히 데이터를 주고받는 통로

    // ✅ Service (비즈니스 계층)
    // - 역할: 프로그램의 **비즈니스 규칙(로직)**을 담당
    // - 관심사: “무엇을 해야 하는가?”
    // - 여러 Repository를 조합하거나, 로직을 추가해 업무 규칙을 구현함
    // - 트랜잭션 관리, 유효성 검증, 정책 판단 등을 포함

    // 친구 추가
    @Transactional
    public Friend addFriend(Friend friend) {
        // 친구를 추가하기 위해서 조건이 있다라면? 조건을 만족하면 db에 저장, 아니면 추가 x
        return friendRepository.save(friend); // save 메서드가 실행되고 리턴되는 객체는 id 값을 직접
    }

    // 친구 목록
    @Transactional(readOnly = true)
    public Iterable<Friend> getFriends() {
        return friendRepository.findAll();
    }

    // 친구 상세페이지
    @Transactional(readOnly = true)
    public Friend getFriendById(Long id) {
        // return friendRepository.findById(id).get(); // get(): optional 리턴
        return friendRepository.findById(id).orElseThrow(); // 없으면 예외 발생
    }

    // 친구 정보 수정
    @Transactional
    public Friend updateFriend(Friend friend) {
        // save() 메서드는 엔티티에 id로 지정된 필드의 값이 존재하면 update 쿼리 생성.
        // id 필드 값이 없으면 insert 쿼리 셍성
        return friendRepository.save(friend);
    }

    // 친구 삭제
    @Transactional
    public void deleteFriendById(Long id) {
        friendRepository.deleteById(id);
    }
}
