package andersen.course.bookshelf.repository;

import java.util.Optional;

import org.hibernate.Session;

import andersen.course.bookshelf.entity.developers.Author;
import andersen.course.bookshelf.utils.HibernateUtil;

public final class AuthorsRepo {

    /**
     * Добавляет автора.
     *
     * @param aAuthor автора
     */
    public static void save(Author aAuthor) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();

        session.save(aAuthor);

        session.getTransaction().commit();
    }

    /**
     * Удаляет автора по идентфикатору.
     *
     * @param aId идентификатор
     */
    public static void deleteById(Long aId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();

        Author author = session.get(Author.class, aId);
        session.delete(author);

        session.getTransaction().commit();
    }

    /**
     * Находит автора по идентификатору.
     *
     * @param aId идентифкатор
     * @return автор
     */
    public static Optional<Author> findById(Long aId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();

        Author author = session.get(Author.class, aId);

        session.getTransaction().commit();
        return Optional.ofNullable(author);
    }

}
