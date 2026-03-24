package com.mynote.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mynote.model.NoteModel;
import com.mynote.service.NoteService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    // Service，不直接操作資料庫
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    // 取得"使用者-userId"筆記
    @GetMapping
    public List<NoteModel> getNotes(HttpSession session) {
        // 接userId
        Integer userId = (Integer) session.getAttribute("userId");
        System.out.println("Current user ID: " + userId);
        // 查資料庫
        return noteService.findByUserId(userId);
    }

    // 新增筆記
    @PostMapping
    public NoteModel createNote(@RequestBody NoteModel note, HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        note.setUserId(userId);
        return noteService.create(note);
    }

    // 更新筆記
    @PutMapping("/{id}")
    public NoteModel updateNote(@PathVariable Integer id, @RequestBody NoteModel updatedNote) {
        updatedNote.setId(id);
        return noteService.update(updatedNote);
    }

    // 刪除筆記
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Integer id) {
        noteService.delete(id);
    }
}
