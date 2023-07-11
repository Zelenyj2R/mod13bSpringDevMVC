package com.goit10.mod13bSpringDevMVC.controller;


import com.goit10.mod13bSpringDevMVC.entity.Note;
import com.goit10.mod13bSpringDevMVC.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }


    @GetMapping("/list")
    public ModelAndView getNotes() {
        var notes = noteService.listAll();
        ModelAndView result = new ModelAndView("note/list");
        result.addObject("notes", notes);
        return result;
    }


    @PostMapping("/delete")
    public ModelAndView deleteNote(@RequestParam(name = "id") Long id) {
        noteService.deleteById(id);
        return getNotes();
    }

    @GetMapping("/edit")
    public ModelAndView editNote(@RequestParam(name = "id") Long id) {
        var note = noteService.getById(id);
        ModelAndView result = new ModelAndView("note/edit");
        result.addObject("note", note);
        return result;
    }

    @PostMapping("/edit")
    public ModelAndView saveNote(@RequestParam(name = "id") Long id,
                                 @RequestParam(name = "title") String title,
                                 @RequestParam(name = "content") String content) {
        Note note = noteService.getById(id);
        note.setTitle(title);
        note.setContent(content);
        return getNotes();
    }
}