package com.mynote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.mynote.mapper.NoteMapper;
import com.mynote.model.NoteModel;

@Service
public class NoteService {

    @Autowired
    private NoteMapper noteMapper;

    // 依"使用者-userId"取得筆記
    public List<NoteModel> findByUserId(Integer userId) {
        return noteMapper.findByUserId(userId);
    }

    // 新增筆記
    public NoteModel create(NoteModel note) {
        noteMapper.insert(note);
        System.out.println("Created note ID: " + note.getId());
        return note;
    }

    // 更新筆記
    public NoteModel update(Integer userId, NoteModel note) {
        NoteModel existingNote = noteMapper.findById(note.getId());
        validateOwnership(userId, existingNote);

        note.setUserId(existingNote.getUserId());
        note.setCreatedAt(existingNote.getCreatedAt());
        noteMapper.update(note);
        return noteMapper.findById(note.getId());
    }

    // 刪除筆記
    public void delete(Integer userId, Integer id) {
        NoteModel existingNote = noteMapper.findById(id);
        validateOwnership(userId, existingNote);

        System.out.println("Deleting note ID: " + id);
        noteMapper.deleteById(id);
    }

    private void validateOwnership(Integer userId, NoteModel note) {
        if (note == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Note not found.");
        }
        if (!userId.equals(note.getUserId())) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You cannot access this note.");
        }
    }
}
