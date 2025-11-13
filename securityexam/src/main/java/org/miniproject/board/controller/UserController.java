package org.miniproject.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.miniproject.board.domain.User;
import org.miniproject.board.dto.UserRegisterDTO;
import org.miniproject.board.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserService userService;

    // 회원가입 폼 요청
    @GetMapping("/signup")
    public String regForm() {
        return "board/users/signupform";
    }

    // 회원가입 처리
    @PostMapping("/reguser")
    public String addUser(@ModelAttribute UserRegisterDTO userRegisterDTO, RedirectAttributes message) {
        // 사용자가 입력한 username이 이미 시스템에 존재하는지 체크
        if (userService.existsByUsername(userRegisterDTO.getLoginId())) {
            log.error("이미 사용중인 아이디 입니다. " + userRegisterDTO.getLoginId());
            message.addFlashAttribute("error", "이미 사용중인 아이디입니다.");

            return "redirect:/users/signup";
        }

        userService.registerUser(userRegisterDTO);
        message.addFlashAttribute("success", "회원가입이 완료되었습니다 🤗🎉 로그인해주세요!");

        return "redirect:/";
    }

    // 로그인 폼 요청
    @GetMapping("/login")
    public String loginForm() {
        return "board/users/loginform";
    }

    // 마이페이지
    @GetMapping("/myinfo")
    public String myInfo(Authentication auth, Model model) {
        String loginId = auth.getName();
        model.addAttribute("user", userService.findByLoginId(loginId));
        return "board/users/myinfoform";
    }

    // 회원 삭제 처리
    @GetMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id, Authentication auth, RedirectAttributes message) {
        try {
            String loginId = auth.getName();
            userService.deleteUser(id, loginId);
            message.addFlashAttribute("success", "회원이 정상적으로 삭제되었습니다.");
        } catch (Exception e) {
            log.error("삭제 권한이 없습니다. " + e.getMessage());
            message.addFlashAttribute("error", "삭제 권한이 없습니다.");
        }
        return "redirect:/";
    }
}
