package com.mynote.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mynote.mapper.NoteMapper;
import com.mynote.model.NoteModel;

@Service
public class NoteService {

    private final NoteMapper noteMapper;

    public NoteService(NoteMapper noteMapper) {
        this.noteMapper = noteMapper;
    }

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
    public NoteModel update(NoteModel note) {
        noteMapper.update(note);
        return note;
    }

    // 刪除筆記
    public void delete(Integer id) {
        System.out.println("Deleting note ID: " + id);
        noteMapper.deleteById(id);
    }
}
