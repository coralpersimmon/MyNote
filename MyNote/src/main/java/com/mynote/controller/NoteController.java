package com.mynote.controller;

import com.mynote.model.NoteModel;
import com.mynote.service.NoteService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    private NoteService noteService;

    // 取得"使用者-userId"筆記
    @GetMapping
    public List<NoteModel> getNotes(HttpSession session) {
        Integer userId = getRequiredUserId(session);
        System.out.println("Current user ID: " + userId);
        return noteService.findByUserId(userId);
    }

    // 新增筆記
    @PostMapping
    public NoteModel createNote(@RequestBody NoteModel note, HttpSession session) {
        Integer userId = getRequiredUserId(session);
        note.setUserId(userId);
        return noteService.create(note);
    }

    // 更新筆記
    @PutMapping("/{id}")
    public NoteModel updateNote(@PathVariable Integer id, @RequestBody NoteModel updatedNote, HttpSession session) {
        Integer userId = getRequiredUserId(session);
        updatedNote.setId(id);
        updatedNote.setUserId(userId);
        return noteService.update(userId, updatedNote);
    }

    // 刪除筆記
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Integer id, HttpSession session) {
        Integer userId = getRequiredUserId(session);
        noteService.delete(userId, id);
    }

    private Integer getRequiredUserId(HttpSession session) {
        Integer userId = (Integer) session.getAttribute("userId");
        if (userId == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Please log in first.");
        }
        return userId;
    }
}
