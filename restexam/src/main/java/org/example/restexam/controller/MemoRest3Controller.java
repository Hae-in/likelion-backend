package org.example.restexam.controller;

import org.example.restexam.domain.Memo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api3/memos")
public class MemoRest3Controller {
    private final Map<Long, Memo> memos = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    @PostMapping
    public ResponseEntity<Long> createMemo(@RequestBody Memo memo) {
        long id = counter.incrementAndGet();
        memo.setId(id);
        memos.put(id, memo);

        // return ResponseEntity.ok(id);
        // return ResponseEntity.status(200).body(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @GetMapping
    public ResponseEntity<List<Memo>> getAllMemos() {
        return ResponseEntity.ok(new ArrayList<>(memos.values()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Memo> getMemoById(@PathVariable Long id) {
        // id에 해당하는 memo가 없을경우
        Memo memo = memos.get(id);
        if( memo == null ) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(memo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String>  updateMemo(@PathVariable Long id, @RequestBody Memo memo) {
        if ( !memos.containsKey(id) ) {
            // return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            // return ResponseEntity.status(404).build();
            return ResponseEntity.status(404).body("Memo not found");
        }
        memo.setId(id);
        memos.put(id, memo);
        return ResponseEntity.ok("Memo updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMemo(@PathVariable Long id) {
        if(memos.remove(id) == null ) {
            // return ResponseEntity.notFound().build(); // body 사용 불가
            return ResponseEntity.status(404).body("Memo not found");
        }
        return ResponseEntity.ok("Memo deleted");
    }
}
