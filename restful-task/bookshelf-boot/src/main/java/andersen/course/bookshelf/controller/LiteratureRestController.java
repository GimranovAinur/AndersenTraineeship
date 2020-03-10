package andersen.course.bookshelf.controller;

import andersen.course.bookshelf.entity.Literature;
import andersen.course.bookshelf.exceptions.LiteratureNotFoundException;
import andersen.course.bookshelf.repository.LiteratureRepo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(value = "Literature Store")
public abstract class LiteratureRestController<T extends Literature> {

    private LiteratureRepo<T> literatureRepo;

    public LiteratureRestController(LiteratureRepo<T> literatureRepo) {
        this.literatureRepo = literatureRepo;
    }

    @ApiOperation(value = "Get list of existing literature", response = List.class)
    @GetMapping
    public List<T> allLiterature() {
        return literatureRepo.findAll();
    }

    @ApiOperation(value = "Get literature by id")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully"),
            @ApiResponse(code = 404, message = "The literature is not found")})
    @GetMapping(path = "/{literatureId}")
    public T getOne(@PathVariable Long literatureId) {
        return literatureRepo.findById(literatureId).orElseThrow(LiteratureNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public T postLiterature(@RequestBody T literature) {
        return literatureRepo.save(literature);
    }

    @PutMapping(path = "/{literatureId}")
    public T putLiterature(@RequestBody T literature) {
        return literatureRepo.save(literature);
    }

    @PatchMapping(path = "/{literatureId}")
    public T patchLiterature(@PathVariable("literatureId") Long literatureId,
                                      @RequestBody T patch) {
        Optional<T> literatureOpt = literatureRepo.findById(literatureId);
        if(literatureOpt.isPresent()) {
            T literature = literatureOpt.get();
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
        } else {
            throw new LiteratureNotFoundException();
        }

    }

    @DeleteMapping("/{literatureId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLiterature(@PathVariable("literatureId") Long literatureId) {
        literatureRepo.deleteById(literatureId);
    }

}
