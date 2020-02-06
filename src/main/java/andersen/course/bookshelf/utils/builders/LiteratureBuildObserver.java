package andersen.course.bookshelf.utils.builders;

import andersen.course.bookshelf.entity.Literature;
import andersen.course.bookshelf.entity.developers.Author;

/**
 * Наблюдатель за конструкторами литературы. Добавляет созданные книги в список написанных книг
 * авторов и иданных книг издателя.
 */
public class LiteratureBuildObserver {

    /**
     * Добавляет созданные книги в список написанных книг авторов и иданных книг издателя.
     *
     * @param aLiterature созданный объект
     */
    public void handle(Literature aLiterature) {
        for (Author author : aLiterature.getAuthors()) {
            author.addWrittenLiterature(aLiterature);
        }
        aLiterature.getPublishers().addReleasedLiterature(aLiterature);
    }

}
