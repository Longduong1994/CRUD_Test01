package ra.service;

import ra.bussinessImp.Book;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return Double.compare(o1.getExportPrice(), o2.getExportPrice());
    }
}
