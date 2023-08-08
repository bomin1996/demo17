package com.example.demo17;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@Repository
@RequestMapping("/memos")
public class MemoController {

    @Autowired
    private MemoRepository memoRepository;

    @GetMapping
    public List<Memo> getAllMemos() {
        return memoRepository.findAll();
    }

    @PostMapping
    public Memo createMemo(@RequestBody Memo memo) {
        return memoRepository.save(memo);
    }

    @GetMapping("/{id}")
    public Memo getMemoById(@PathVariable Long id) {
        return memoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Memo not found with id: " + id));
    }

    @PutMapping("/{id}")
    public Memo updateMemo(@PathVariable Long id, @RequestBody Memo memoDetails) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Memo not found with id: " + id));


        return memoRepository.save(memo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMemo(@PathVariable Long id) {
        Memo memo = memoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Memo not found with id: " + id));

        memoRepository.delete(memo);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Memo memo) {

        return ResponseEntity.ok("Memo created successfully");
    }
}