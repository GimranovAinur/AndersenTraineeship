package andersen.course.bookshelf.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import andersen.course.bookshelf.entity.developers.Author;
import andersen.course.bookshelf.entity.developers.Publisher;
import andersen.course.bookshelf.utils.adapters.DateAdapter;

public abstract class AbstractCreateLiteratureCommand implements ICommand {

    private Scanner scanner;

    /**
     * Возвращает введенное значение названия.
     *
     * @return название
     */
    protected String getTitleInput() {
        System.out.println("Введите название книги:");
        return scanner.nextLine();
    }

    /**
     * Возвращает введенное значение авторов. Сложные(составные) имена авторов не учтены.
     *
     * @return авторы
     */
    protected List<Author> getAuthorsInput() {
        System.out.println("Введите имена и фамилии авторов книги через запятую:");
        String input = scanner.nextLine();
        List<Author> authors = new ArrayList<>();

        String[] initials = input.split(",");
        for (String initial : initials) {
            String[] authorInfo = initial.split(" ");
            Author author = new Author(authorInfo[0], authorInfo[1]);
            authors.add(author);
        }
        return authors;
    }

    /**
     * Возвращает введенное значение издателя.
     *
     * @return издатель
     */
    protected Publisher getPublisherInput() {
        System.out.println("Введите название издателя книги:");
        return new Publisher(scanner.next());
    }

    /**
     * Возвращает введенное значение даты издания.
     *
     * @return дата издания
     */
    protected Date getDateInput() {
        System.out.println("Введите дату издания книги в формате dd-MM-yyy:");
        return DateAdapter.getFormattedDate(scanner.next());
    }

    protected Scanner getScanner() {
        return scanner;
    }

    protected void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

}
