package org.example.bitcoinlion.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TroubleMakerController {
    // 메모리 누수용(static GC 안됨)
    private static final List<byte[]> LEAK_LIST = new ArrayList<>();

    @GetMapping("/leak")
    public String leak() {
        LEAK_LIST.add(new byte[10*1024*1024]); // 한 번 호출 될때 10MB 씩 공간차지
        return "Memory leak!! current size: " + LEAK_LIST.size();
    }
}
