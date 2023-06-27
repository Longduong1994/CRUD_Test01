package ra.service;

import ra.bussinessImp.Book;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    List<Book> books;

    public BookService() {
        books = new ArrayList<Book>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public int getSize() {
        return books.size();
    }

    public int newId() {
        int max = 0;
        for (Book book : books) {
            if (book.getBookId() > max) {
                max = book.getBookId();
            }
        }
        return max + 1;
    }

    public Book findById(int id) {
        for (Book book : books) {
            if (book.getBookId() == id) {
                return book;
            }
        }
        return null;
    }

    public void save(Book book) {
        if(findById(book.getBookId())==null){
            books.add(book);
        }else{
            books.set(books.indexOf(book.getBookId()),book);
        }
    }

    public void delete(Book book){
        if(findById(book.getBookId())==null){
            System.out.println("ID không tồn tại!!!");
            return;
        }
        books.remove(book.getBookId());
    }
}
