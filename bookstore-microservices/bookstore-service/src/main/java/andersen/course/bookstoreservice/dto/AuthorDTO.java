package andersen.course.bookstoreservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class AuthorDTO {

    private Long id;

    private String name;

    private String surname;

    private List<BookDTO> writtenBooks;

}
