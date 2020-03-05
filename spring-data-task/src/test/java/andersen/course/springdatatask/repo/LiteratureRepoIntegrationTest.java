package andersen.course.springdatatask.repo;

import andersen.course.springdatatask.entity.Book;
import andersen.course.springdatatask.entity.Literature;
import andersen.course.springdatatask.entity.developer.Author;
import andersen.course.springdatatask.entity.developer.Publisher;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LiteratureRepoIntegrationTest {

    public static Literature testData;
    @Autowired
    public LiteratureRepo subject;
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;

    @BeforeEach
    public void setUp() {
        Author author = Author.builder().name("TestName").surname("TestSurname").build();
        Publisher publisher = Publisher.builder().name("TestName").build();
        testData = Book.builder().title("TestTitle").publisher(publisher).author(author).build();
        subject.save(testData);
    }

    @Test
    public void injectedComponentsAreNotNull(){
        assertThat(dataSource, notNullValue());
        assertThat(jdbcTemplate, notNullValue());
        assertThat(entityManager, notNullValue());
        assertThat(subject, notNullValue());
    }

    @Test
    public void testLiteratureSaveAndGet() {
        subject.save(testData);
        assertThat(subject.findById(testData.getId()), equalTo(Optional.of(testData)));
    }

    @Test
    public void testFindAuthorById() {
        Optional<Literature> literature = subject.findById(testData.getId());
        Author author = literature.get().getAuthors().get(0);

        assertThat(author, equalTo(testData.getAuthors().get(0)));
    }

    @Test
    public void testFindPublisherById() {
        Optional<Literature> literature = subject.findById(testData.getId());
        Publisher publisher = literature.get().getPublisher();

        assertThat(publisher, equalTo(testData.getPublisher()));
    }

    @AfterEach
    public void removeData() {
        subject.delete(testData);
    }

 }
