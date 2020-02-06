package andersen.course.bookshelf.utils.factories;

import andersen.course.bookshelf.entity.Literature;

public abstract class LiteratureFactory {

    /**
     * Выкладывает в публикацию литературу.
     *
     * @return новая литература
     */
    public abstract Literature publish();

}
