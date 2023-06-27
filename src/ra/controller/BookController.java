package ra.controller;

import ra.bussinessImp.Book;
import ra.service.BookService;

import java.util.List;

public class BookController {
    BookService bookService = new BookService();
    public List<Book> getAll(){
        return bookService.getBooks();
    }
    public int getSize() {
        return bookService.getSize();
    }
    public int newId( ){
        return bookService.newId();
    }

    public void save(Book book){
        bookService.save(book);
    }
    public void delete(Book book){
        bookService.delete(book);
    }
}
