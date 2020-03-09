package andersen.course.bookshelfapi;

import andersen.course.bookshelfdata.LiteratureRepo;
import andersen.course.bookshelfdomain.Literature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/literature")
public class LiteratureApiController {

    private LiteratureRepo<Literature> literatureRepo;

    @Autowired
    public LiteratureApiController(LiteratureRepo literatureRepo) {
        this.literatureRepo = literatureRepo;
    }

    @GetMapping
    public Iterable<Literature> allLiterature() {
        return literatureRepo.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Literature postLiterature(@RequestBody Literature literature) {
        return literatureRepo.save(literature);
    }

    @PutMapping(path = "/{literatureId}")
    public Literature putLiterature(@RequestBody Literature literature) {
        return literatureRepo.save(literature);
    }

    @PatchMapping(path = "/{literatureId}")
    public Literature patchLiterature(@PathVariable("literatureId") Long literatureId,
                                      @RequestBody Literature patch) {
        Literature literature = literatureRepo.findById(literatureId).get();
        if(patch.getTitle() != null) {
            literature.setTitle(patch.getTitle());
        }
        if(patch.getAuthors() != null && !patch.getAuthors().isEmpty()) {
            literature.setAuthors(patch.getAuthors());
        }
        if(patch.getPublisher() != null) {
            literature.setPublisher(patch.getPublisher());
        }
        if(patch.getReleaseDate() != null) {
            literature.setReleaseDate(patch.getReleaseDate());
        }
        return literatureRepo.save(literature);
    }

    @DeleteMapping("/{literatureId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLiterature(@PathVariable("literatureId") Long literatureId) {
        literatureRepo.deleteById(literatureId);
    }

}
