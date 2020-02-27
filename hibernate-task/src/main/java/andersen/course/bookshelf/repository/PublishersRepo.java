package andersen.course.bookshelf.repository;

import java.util.Optional;

import org.hibernate.Session;

import andersen.course.bookshelf.entity.developers.Publisher;
import andersen.course.bookshelf.utils.HibernateUtil;

public final class PublishersRepo {

    /**
     * Добавляет издателя.
     *
     * @param aPublisher издатель
     */
    public static void save(Publisher aPublisher) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();

        session.save(aPublisher);

        session.getTransaction().commit();
    }

    /**
     * Удаляет издателя по идентфикатору.
     *
     * @param aId идентификатор
     */
    public static void deleteById(Long aId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();

        Publisher publisher = session.get(Publisher.class, aId);
        session.delete(publisher);

        session.getTransaction().commit();
    }

    /**
     * Находит издателя по идентификатору.
     *
     * @param aId идентифкатор
     * @return издатель
     */
    public static Optional<Publisher> findById(Long aId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();

        Publisher publisher = session.get(Publisher.class, aId);

        session.getTransaction().commit();
        return Optional.ofNullable(publisher);
    }
}
