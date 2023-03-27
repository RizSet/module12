package com.homework.module12.services;

import com.homework.module12.entity.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
public class NoteService {
    private Map<Long, Note> noteMap;

    public List<Note> listAll() {
        return new ArrayList<>(noteMap.values());
    }

    public Note add(Note note) {
        long key = new Random().nextLong();
        note.setId(key);
        noteMap.put(key, note);
        return note;
    }

    public void deleteById(long id) throws Exception {
        if (noteMap.remove(id) == null) {
            throw new IllegalArgumentException();
        }
    }

    public void update(Note note) throws Exception {
        if (noteMap.replace(note.getId(), note) == null) {
            throw new IllegalArgumentException();
        }
    }

    public Note getById(long id) throws Exception {
        Note note = noteMap.get(id);
        if (note == null) {
            throw new IllegalArgumentException();
        }
        return note;
    }


}
