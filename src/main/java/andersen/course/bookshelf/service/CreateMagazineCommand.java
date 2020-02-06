package andersen.course.bookshelf.service;

import java.util.Scanner;

import andersen.course.bookshelf.entity.Magazine;
import andersen.course.bookshelf.utils.builders.MagazineBuilder;

public class CreateMagazineCommand extends AbstractCreateLiteratureCommand {

    @Override
    public Magazine execute(Scanner aScanner) {
        setScanner(aScanner);
        MagazineBuilder builder = new MagazineBuilder();
        Magazine magazine = builder.title(getTitleInput()).authors(getAuthorsInput())
                .publisher(getPublisherInput()).releaseDate(getDateInput())
                .releaseNumber(getReleaseNumber()).build();
        getScanner().close();
        return magazine;
    }

    /**
     * Возвращает введенное значение номера издания.
     *
     * @return издатель
     */
    protected int getReleaseNumber() {
        System.out.println("Введите номер издания журнала:\n");
        return getScanner().nextInt();
    }

}
