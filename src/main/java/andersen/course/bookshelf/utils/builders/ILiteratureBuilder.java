package andersen.course.bookshelf.utils.builders;

import java.util.Date;
import java.util.List;

import andersen.course.bookshelf.entity.Literature;
import andersen.course.bookshelf.entity.developers.Author;
import andersen.course.bookshelf.entity.developers.Publisher;

/**
 * Интерфейс конструктора литературы.
 */
public interface ILiteratureBuilder {

    /**
     * Устанавливает название.
     *
     * @param aTitle название
     */
    ILiteratureBuilder title(String aTitle);

    /**
     * Устанавливает авторов.
     *
     * @param aAuthors авторы
     */
    ILiteratureBuilder authors(List<Author> aAuthors);

    /**
     * Устанавливает издателя.
     *
     * @param aPublisher издатель
     */
    ILiteratureBuilder publisher(Publisher aPublisher);

    /**
     * Устанавливает дату издания.
     *
     * @param aReleaseDate дата издания
     */
    ILiteratureBuilder releaseDate(Date aReleaseDate);

    /**
     * Возвращает готовый объект.
     *
     * @return готовый объект
     */
    Literature build();

    /**
     * Оповещает наблюдателя.
     *
     * @param конструируемая литература
     */
    void notifyObserver(Literature aLiterature);

}
