package andersen.course.bookshelf.controller;

import andersen.course.bookshelf.entity.Literature;
import andersen.course.bookshelf.exceptions.LiteratureNotFoundException;
import andersen.course.bookshelf.repository.LiteratureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public abstract class LiteratureController<T extends Literature> {

    private LiteratureRepo<T> literatureRepo;

    @Autowired
    public LiteratureController(LiteratureRepo<T> literatureRepo) {
        this.literatureRepo = literatureRepo;
    }

    @GetMapping
    public String showLiteratureForm(@ModelAttribute(value = "literature") T literature) {
        return "newLiteratureForm";
    }

    @GetMapping("list")
    public String allLiterature(Model model) {
        model.addAttribute("literature", literatureRepo.findAll());
        return "literatureList";
    }

    @PostMapping("add")
    public String addLiterature(@Valid T literature, BindingResult result, Model model) {
        if(result.hasErrors()) {
            return "newLiteratureForm";
        }
        literatureRepo.save(literature);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        T literature = literatureRepo.findById(id).orElseThrow(LiteratureNotFoundException::new);
        model.addAttribute("literature", literature);
        return "updateLiterature";
    }

    @PostMapping("update/{id}")
    public String updateLiterature(@PathVariable("id") Long id, T literature, BindingResult result, Model model) {
        if(result.hasErrors()) {
            literature.setId(id);
            return "updateLiterature";
        }
        literatureRepo.save(literature);
        model.addAttribute("literature", literatureRepo.findAll());
        return "literatureList";
    }

}
