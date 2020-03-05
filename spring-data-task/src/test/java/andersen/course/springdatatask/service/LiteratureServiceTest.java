package andersen.course.springdatatask.service;

import andersen.course.springdatatask.entity.Book;
import andersen.course.springdatatask.entity.Literature;
import andersen.course.springdatatask.entity.developer.Author;
import andersen.course.springdatatask.entity.developer.Publisher;
import andersen.course.springdatatask.repo.LiteratureRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
public class LiteratureServiceTest {
    @MockBean
    LiteratureRepo literatureRepo;
    @Autowired
    LiteratureService subject;

    @BeforeEach
    public void setUp() {
        Author author = Author.builder().name("TestName").surname("TestSurname").build();
        Publisher publisher = Publisher.builder().name("TestName").build();
        Literature book = Book.builder().title("TestTitle").publisher(publisher).author(author).build();
        when(literatureRepo.findById(any(Long.class))).thenReturn(Optional.of(book));
    }

    @Test
    public void testSave() {
        Literature literature = subject.save(any(Literature.class));
        verify(literatureRepo, times(1)).save(literature);
    }

    @Test
    public void testGetById() {
        Optional<Literature> createdBook = subject.getById(any(Long.class));
        assertThat(createdBook.get(), instanceOf(Book.class));
        verify(literatureRepo, times(1)).findById(any(Long.class));
    }

}
