package com.homework.module12.feature.note.services;

import com.homework.module12.feature.note.NoteRepository;
import com.homework.module12.feature.note.entity.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(long id) throws NoSuchElementException {
        noteRepository.findById(id).orElseThrow();
        noteRepository.deleteById(id);
    }


    public void update(Note note) throws NoSuchElementException {
        noteRepository.findById(note.getId()).orElseThrow();
        noteRepository.save(note);
    }

    public Note getById(long id) throws NoSuchElementException {
        return noteRepository.findById(id).get();
    }

}
