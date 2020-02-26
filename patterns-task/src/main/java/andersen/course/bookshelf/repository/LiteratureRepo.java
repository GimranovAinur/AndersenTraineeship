package andersen.course.bookshelf.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import andersen.course.bookshelf.entity.Literature;
import andersen.course.bookshelf.entity.Magazine;
import andersen.course.bookshelf.entity.developers.Author;
import andersen.course.bookshelf.entity.developers.Publisher;
import andersen.course.bookshelf.utils.DatabaseConnector;
import andersen.course.bookshelf.utils.builders.BookBuilder;
import andersen.course.bookshelf.utils.builders.ILiteratureBuilder;

public class LiteratureRepo {

    private static final String CREATE =
            "INSERT INTO literature (title, publisher_id, release_date, release_number, author_id) VALUES (?, ?, ?, ?, ?)";

    private static final String READ = "SELECT * FROM literature WHERE id = ?";

    private static final String READ_AUTHORS =
            "SELECT a.name, a.surname FROM authors AS a JOIN literature_author_ref AS la ON a.id = la.author_id "
                    + "JOIN literature AS l ON l.id = la.literature_id WHERE l.id = ?";

    private static final String ADD_AUTHORS =
            "INSERT INTO literature_author_ref (literature_id, author_id) VALUES (?, ?)";

    /**
     * Добавляет новую литературу в БД.
     *
     * @param aLiterature литература
     */
    public static Long save(Literature aLiterature) {
        try {
            Connection conn = DatabaseConnector.getConnection();
            PreparedStatement statement =
                    conn.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, aLiterature.getTitle());
            Long publisherId = PublishersRepo.save(aLiterature.getPublishers());
            statement.setLong(2, publisherId);
            statement.setDate(3, new Date(aLiterature.getReleaseDate().getTime()));
            if (aLiterature instanceof Magazine) {
                statement.setInt(4, ((Magazine) aLiterature).getReleaseNumber());
            } else {
                statement.setNull(4, Types.INTEGER);
            }
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            Long id = null;
            if (result.next()) {
                id = result.getLong(1);
            }
            aLiterature.setId(id);
            addAuthors(aLiterature);
            return id;
        } catch (SQLException e) {
            System.err.println("Ошибка сохранения литературы: " + e.getMessage());
        }
        return null;
    }

    /**
     * Добавляет авторов литературы в БД.
     *
     * @param aLiterature литература
     */
    private static void addAuthors(Literature aLiterature) {
        try {
            Connection conn = DatabaseConnector.getConnection();
            for (Author author : aLiterature.getAuthors()) {
                PreparedStatement statement = conn.prepareStatement(ADD_AUTHORS);
                statement.setLong(1, aLiterature.getId());
                Long id = AuthorsRepo.save(author);
                statement.setLong(2, id);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Ошибка добавления автора: " + e.getMessage());
        }
    }

    /**
     * Возвращает литературу по идентификатору.
     *
     * @param aId идентификатор
     * @return автор
     */
    public static Literature findById(Long aId) {
        ILiteratureBuilder builder = new BookBuilder();
        try {
            Connection conn = DatabaseConnector.getConnection();
            PreparedStatement statement = conn.prepareStatement(READ);
            statement.setLong(1, aId);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Long id = result.getLong(1);
                String title = result.getString(2);
                Publisher publisher = PublishersRepo.findById(result.getLong(3));
                List<Author> authors = getAuthors(aId);
                Literature literature =
                        builder.title(title).publisher(publisher).authors(authors).build();
                literature.setId(id);
                return literature;
            }
        } catch (SQLException e) {
            System.err.println("Не удалось найти автора: " + e.getMessage());
        }
        return null;
    }

    private static List<Author> getAuthors(Long aId) {
        List<Author> authors = new ArrayList<>();
        try {
            Connection conn = DatabaseConnector.getConnection();
            PreparedStatement statement = conn.prepareStatement(READ_AUTHORS);
            statement.setLong(1, aId);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                authors.add(new Author(result.getString(1), result.getString(2)));
            }
            return authors;
        } catch (SQLException e) {
            System.err.println("Не удалось найти автора: " + e.getMessage());
        }
        return null;
    }

}
