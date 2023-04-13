package com.homework.module12.feature.note.controller;


import com.homework.module12.feature.note.entity.Note;
import com.homework.module12.feature.note.services.NoteService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.HttpServletBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.net.http.HttpResponse;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/note")
@Controller
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView getNoteList (){
        ModelAndView result = new ModelAndView("note-list");
        result.addObject("listNote", noteService.listAll());
        return result;
    }

    @PostMapping("/create")
    public ModelAndView createNote (@RequestParam String noteTitle, @RequestParam String noteText) throws Exception {
        noteService.add(new Note(noteTitle, noteText));
        ModelAndView result = new ModelAndView(new RedirectView("./list"));
        result.addObject("listNote", noteService.listAll());
        return result;
    }

    @PostMapping("/delete")
    public ModelAndView deleteNote (@RequestParam long id) throws Exception {
        noteService.deleteById(id);
        ModelAndView result = new ModelAndView(new RedirectView("./list"));
        result.addObject("listNote", noteService.listAll());
        return result;
    }

    @GetMapping("/edit")
    public ModelAndView editNote (@RequestParam(name = "id") long id) throws Exception {
        ModelAndView result = new ModelAndView("edit-note");
        result.addObject("note", noteService.getById(id));
        return result;
    }

    @PostMapping("/edit")
    public ModelAndView editNote (@RequestParam String noteText, @RequestParam (name = "id") long id) throws Exception {
        noteService.getById(id).setContent(noteText);
        noteService.update(noteService.getById(id));
        ModelAndView result = new ModelAndView(new RedirectView("./list"));
        result.addObject("listNote", noteService.listAll());
        return result;
    }
}
