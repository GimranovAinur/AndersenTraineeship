package andersen.course.bookshelf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import andersen.course.bookshelf.entity.Book;
import andersen.course.bookshelf.entity.developers.Author;
import andersen.course.bookshelf.entity.developers.Publisher;
import andersen.course.bookshelf.repository.LiteratureRepo;
import andersen.course.bookshelf.utils.builders.BookBuilder;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // int commandNumber = getCommandNumber(scanner);
        // ICommand command = null;
        // switch (commandNumber) {
        // case 1:
        // command = new CreateBookCommand();
        // break;
        // case 2:
        // command = new CreateMagazineCommand();
        // case 0:
        // System.exit(0);
        // default:
        // System.out.println("Не понял, а как так получилось?!");
        // break;
        // }

        BookBuilder builder = new BookBuilder();
        Author author = new Author("Иван", "Тургенев");
        List<Author> authors = new ArrayList<>();
        authors.add(author);
        Publisher publisher = new Publisher("Kek");
        Book book = builder.title("Отцы и дети").releaseDate(new Date()).authors(authors)
                .publisher(publisher).build();
        LiteratureRepo.save(book);
        LiteratureRepo.findById(1L)
                .ifPresent(literature -> System.out.println(literature.getTitlePageInfo()));
    }

    private static int getCommandNumber(Scanner aScanner) {
        String commands = "[1]. Добавить книгу\n[2]. Добавить журнал\n[0]. Выйти";
        System.out.println("Что вы хотите сделать?(Введите номер команды)\n" + commands);
        while (true) {
            int commandNumber = Integer.parseInt(aScanner.nextLine());
            if (commandNumber == 1 || commandNumber == 2 || commandNumber == 0) {
                return commandNumber;
            } else {
                System.out.println(
                        "НЕА. Не верно! Попробуйте еще раз (Введите номер команды)\n" + commands);
            }
        }
    }
}
