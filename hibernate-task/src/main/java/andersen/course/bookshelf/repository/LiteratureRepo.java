package andersen.course.bookshelf.repository;

import java.util.Optional;

import org.hibernate.Session;

import andersen.course.bookshelf.entity.Literature;
import andersen.course.bookshelf.utils.HibernateUtil;

public class LiteratureRepo {

    /**
     * Добавляет литературу.
     *
     * @param aLiterature литература
     */
    public static void save(Literature aLiterature) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();

        session.save(aLiterature);

        session.getTransaction().commit();
    }

    /**
     * Удаляет литературу по идентфикатору.
     *
     * @param aId идентификатор
     */
    public static void deleteById(Long aId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();

        Literature literature = session.get(Literature.class, aId);
        session.delete(literature);

        session.getTransaction().commit();
    }

    /**
     * Находит литературу по идентификатору.
     *
     * @param aId идентифкатор
     * @return литература
     */
    public static Optional<Literature> findById(Long aId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.getTransaction().begin();

        Literature literature = session.get(Literature.class, aId);

        session.getTransaction().commit();
        return Optional.ofNullable(literature);
    }

}
