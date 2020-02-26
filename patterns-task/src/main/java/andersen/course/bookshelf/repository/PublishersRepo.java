package andersen.course.bookshelf.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import andersen.course.bookshelf.entity.developers.Publisher;
import andersen.course.bookshelf.utils.DatabaseConnector;

public final class PublishersRepo {

    private static final String CREATE = "INSERT INTO publishers (name) VALUES (?)";

    private static final String READ = "SELECT * FROM publishers WHERE id = ?";

    private static final String DELETE = "DELETE FROM publishers WHERE id = ?";

    /**
     * Добавляет нового издателя в БД.
     *
     * @param aPublisher издатель
     */
    public static Long save(Publisher aPublisher) {
        try {
            Connection conn = DatabaseConnector.getConnection();
            PreparedStatement statement =
                    conn.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, aPublisher.getName());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                return result.getLong(1);
            }
        } catch (SQLException e) {
            System.err.println("Ошибка сохранения издателя: " + e.getMessage());
        }
        return null;
    }

    /**
     * Возвращает издателя по идентификатору.
     *
     * @param aId идентификатор
     * @return издатель
     */
    public static Publisher findById(Long aId) {
        try {
            Connection conn = DatabaseConnector.getConnection();
            PreparedStatement statement = conn.prepareStatement(READ);
            statement.setLong(1, aId);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Long id = result.getLong(1);
                String name = result.getString(2);
                return new Publisher(id, name);
            }
        } catch (SQLException e) {
            System.err.println("Не удалось найти издателя: " + e.getMessage());
        }
        return null;
    }

    /**
     * Удаляет издателя из БД.
     *
     * @param aPublisher издатель
     */
    public static void remove(Publisher aPublisher) {
        try {
            Connection conn = DatabaseConnector.getConnection();
            PreparedStatement statement = conn.prepareStatement(DELETE);
            statement.setLong(1, aPublisher.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Не удалось найти издателя: " + e.getMessage());
        }
    }

}
