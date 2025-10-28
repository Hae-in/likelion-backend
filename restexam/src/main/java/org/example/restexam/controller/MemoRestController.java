package org.example.restexam.controller;

import lombok.Getter;
import org.example.restexam.domain.Memo;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/memos")
public class MemoRestController {
    private final Map<Long, String> memos = new HashMap<>();

    // memo의 id 값 자동 증가
    private final AtomicLong counter = new AtomicLong();

    // 추가
    @PostMapping
    public String createMemo(@RequestBody String content) {
        long id = counter.incrementAndGet();
        memos.put(id, content);
        return "Memo created with id " + id;
    }

    // 전체 조회
    @GetMapping
    public Map<Long, String> getMemos() {
        return memos;
    }

    // 조회
    @GetMapping("/{id}")
    public String getMemo(@PathVariable("id") Long id) {
        // return memos.get(id);
        return memos.getOrDefault(id, "해당 메모를 찾을 수 없습니다...");
    }

    // 수정
    @PutMapping("/{id}")
    public String updateMemo(@PathVariable("id") Long id, @RequestBody String content) {
        if(!memos.containsKey(id)) {
            return id + "에 해당하는 메모가 없습니다...";
        }
        memos.put(id, content);
        return "Memo updated with id " + id;
    }

    // 삭제
    @DeleteMapping("/{id}")
    public String deleteMemo(@PathVariable("id") Long id) {
        if(memos.remove(id) == null) {
            return id + "에 해당하는 메모가 없습니다...";
        }
        return "Memo deleted with id " + id;
    }
}
