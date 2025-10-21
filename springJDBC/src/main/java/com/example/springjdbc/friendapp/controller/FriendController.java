package com.example.springjdbc.friendapp.controller;

import com.example.springjdbc.friendapp.domain.Friend;
import com.example.springjdbc.friendapp.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/friends")
public class FriendController {
    private final FriendService friendService;

    // 기능
    // 친구 추가
    // 친구 목록 보기
    // 친구정보 수정
    // 친구 삭제

    // URL
    // 친구 추가: /addFriend or /friends/add
    // 친구 목록 보기: /friendList or friends/list

    // 친구 추가: 친구 추가 폼 보여줘(get), 친구 추가해줘(post)
    @GetMapping("/add")
    public String addFriendForm() {
        return "friends/addForm";
    }

    @PostMapping("/add")
    public String addFriend(@ModelAttribute Friend friend) {
        // 서비스에 이름과 이메일을 보내서 친구정보를 저장해 달라고 요청
        // 서비스에 이름과 이메일을 담은 Friend 객체를 전달할것인지, name, email을 전달 할지 정해야함.

        // Friend 객체 전달 -> @ModelAttribute Friend friend
        Friend saveFriend = friendService.addFriend(friend);
        System.out.println(saveFriend);

        return "redirect:/friends/list"; // 임시로 저장되고 다시 친구추가폼(addFriendForm)을 요청함
    }

    // 친구 목록
    @GetMapping("/list")
    public String listFriends(Model model) {
        // 서비스한테 list 받아와야함
        // 모델에 담아서 넘기기

        Iterable<Friend> friends = friendService.getFriends();
        model.addAttribute("friends", friends);

        return "friends/list";
    }

    // 친구 상세페이지
    @GetMapping("/{id}")
    public String detailFriend(@PathVariable("id") Long id, Model model) {
        Friend friend = friendService.getFriendById(id);
        model.addAttribute("friend", friend);

        return "friends/detail";
    }

    // 친구 정보 수정 -> 수정 폼 보여줘, 수정한 내용 db에 반영 해줘
    @GetMapping("/edit/{id}")
    public String editFriendForm(@PathVariable("id") Long id, Model model) {
        Friend friend = friendService.getFriendById(id);
        model.addAttribute("friend", friend);

        return "friends/editForm";
    }

    @PostMapping("/edit")
    public String editFriend(@ModelAttribute Friend friend) {
        System.out.println("==> 수정된 친구 정보: " + friend);
        friendService.updateFriend(friend);
        return "redirect:/friends/list";
    }

    // 친구 삭제
    @GetMapping("/delete/{id}")
    public String deleteFriend(@PathVariable("id") Long id) {
        friendService.deleteFriendById(id);
        return "redirect:/friends/list";
    }

}
