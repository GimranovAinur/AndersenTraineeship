package andersen.course.bookshelf.service;

import java.util.Scanner;

import andersen.course.bookshelf.entity.Literature;

public interface ICommand {

    /**
     * Исполняет команду.
     *
     * @param aScanner сканнер
     */
    Literature execute(Scanner aScanner);

}
