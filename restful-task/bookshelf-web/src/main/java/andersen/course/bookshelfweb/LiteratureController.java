package andersen.course.bookshelfweb;

import andersen.course.bookshelfdata.LiteratureRepo;
import andersen.course.bookshelfdomain.Literature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/literature")
public class LiteratureController {

    private LiteratureRepo<Literature> literatureRepo;

    @Autowired
    public LiteratureController(LiteratureRepo literatureRepo) {
        this.literatureRepo = literatureRepo;
    }

    @GetMapping
    public String literatureForm(@ModelAttribute Literature literature) {
        return "newLiteratureForm";
    }

    @PostMapping
    public String processSave(Literature literature) {
        literatureRepo.save(literature);
        return "redirect:/all";
    }

    @GetMapping(path = "/all")
    public String allLiterature(Model model) {
        model.addAttribute("literature", literatureRepo.findAll());
        return "literatureList";
    }

}
