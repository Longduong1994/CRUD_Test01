package ra.run;

import ra.bussinessImp.Author;
import ra.bussinessImp.Book;
import ra.config.Config;
import ra.controller.AuthorController;
import ra.controller.BookController;
import ra.service.BookComparator;

import java.util.Collections;
import java.util.Scanner;

public class BookManagement {
    static BookController bookController = new BookController();
    static AuthorController authorController = new AuthorController();

    public static void main(String[] args) {
        byte choice;
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-1-MENU***************\n" +
                    "1. Nhập số tác giả và nhập thông tin các tác giả [10 điểm]\n" +
                    "2. Nhập số sách và nhập thông tin các sách [20 điểm]\n" +
                    "3. Sắp xếp sách theo giá xuất sách tăng dần (Comparable/BookComparator) [10 điểm]\n" +
                    "4. Tìm kiếm sách theo tên tác giả sách [05 điểm]\n" +
                    "5. Thoát [05 điểm]");
            System.out.println("Nhập lựa chọn:");
            choice = Config.getByte();
            switch (choice) {
                case 1:
                    createAnthor();
                    break;
                case 2:
                    createBook();
                    break;
                case 3:
                    sortBook();
                    break;
                case 4:
                    System.out.println("Nhập tên muốn tìm");
                    String name = Config.getString();
                    searchByName(name);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhập lại lựa chọn từ 1 đến 5!!!");
            }
        }
    }

    public static void createAnthor() {
        System.out.println("Nhập số tác giả cần thêm:");
        int n = Config.getInteger();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin cho tác giả thứ : " + (i + 1));
            Author newAuthor = new Author();
            int id = authorController.newId();
            newAuthor.setAuthorId(id);
            newAuthor.inputData();
            authorController.save(newAuthor);
        }
        showAuthor();
    }

    public static void showAuthor() {
        if (authorController.getSize() == 0) {
            System.out.println("không  có tác giả nào!!!");
            return;
        }
        for (Author author : authorController.getAll()) {
            author.displayData();
        }
    }

    public static void createBook() {
        System.out.println("Nhập số sách cần thêm: ");
        int n = Config.getInteger();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sách thứ " + (i + 1));
            Book newBook = new Book();

            int newId = bookController.newId();
            newBook.setBookId(newId);
            System.out.println("New Id: " + newId);

            newBook.inputData();
            showAuthor();
            Author newAuthor = null;
            System.out.println("Chọn ID tác giả");

            while (true) {
                int idAuthor = Config.getInteger();
                boolean flag = true;
                for (Author author : authorController.getAll()) {
                    flag = false;
                    newAuthor = author;
                }
                if (flag) {
                    System.out.println("ID Không tồn tại");
                } else {
                    break;
                }
            }
            newBook.setAuthor(newAuthor);
            bookController.save(newBook);
        }
        System.out.println("Thêm thành công");
        showBook();
    }

    public static void showBook() {
        if (bookController.getSize() == 0) {
            System.out.println("Không có sách nào cả!!!");
            return;
        }
        for (Book book : bookController.getAll()) {
            book.displayData();
        }
    }

    public static void sortBook() {
        Collections.sort(bookController.getAll(), new BookComparator());
    }

    public static Book searchByName(String name) {
        for (Book book : bookController.getAll()) {
            if (book.getAuthor().getAuthorName().equals(name)) {
                book.displayData();
                break;
            }

        }
        System.out.println("Không có tên tác giả này!!!");
        return null;
    }

}
