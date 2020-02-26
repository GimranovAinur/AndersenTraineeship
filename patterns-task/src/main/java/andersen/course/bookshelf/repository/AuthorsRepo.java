package andersen.course.bookshelf.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import andersen.course.bookshelf.entity.developers.Author;
import andersen.course.bookshelf.utils.DatabaseConnector;

public final class AuthorsRepo {

    private static final String CREATE = "INSERT INTO authors (name, surname) VALUES (?, ?)";

    private static final String READ = "SELECT * FROM authors WHERE id = ?";

    private static final String DELETE = "DELETE FROM authors WHERE id = ?";

    /**
     * Добавляет нового автора в БД.
     *
     * @param aAuthor автор
     */
    public static Long save(Author aAuthor) {
        try {
            Connection conn = DatabaseConnector.getConnection();
            PreparedStatement statement =
                    conn.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, aAuthor.getName());
            statement.setString(2, aAuthor.getSurname());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                return result.getLong(1);
            }
        } catch (SQLException e) {
            System.err.println("Ошибка сохранения автора: " + e.getMessage());
        }
        return null;
    }

    /**
     * Возвращает автора по идентификатору.
     *
     * @param aId идентификатор
     * @return автор
     */
    public static Author findById(Long aId) {
        try {
            Connection conn = DatabaseConnector.getConnection();
            PreparedStatement statement = conn.prepareStatement(READ);
            statement.setLong(1, aId);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Long id = result.getLong(1);
                String name = result.getString(2);
                String surname = result.getString(3);
                return new Author(id, name, surname);
            }
        } catch (SQLException e) {
            System.err.println("Не удалось найти автора: " + e.getMessage());
        }
        return null;
    }

    /**
     * Удаляет издателя из БД.
     *
     * @param aAuthor издатель
     */
    public static void remove(Author aAuthor) {
        try {
            Connection conn = DatabaseConnector.getConnection();
            PreparedStatement statement = conn.prepareStatement(DELETE);
            statement.setLong(0, aAuthor.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Не удалось найти автора: " + e.getMessage());
        }
    }

}
