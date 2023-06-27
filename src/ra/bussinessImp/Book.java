package ra.bussinessImp;

import ra.bussiness.IShop;
import ra.config.Config;

import java.awt.*;
import java.util.ArrayList;

public class Book implements IShop {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private Author author;
    private float importPrice;
    private float exportPrice;
    private int quantity;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, Author author, float importPrice, float exportPrice, int quantity, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public void inputData() {
        System.out.println("Nhập tên sách:");
        this.bookName = Config.getString();
        System.out.println("Nhập tiêu đề:");
        this.title = Config.getString();
        System.out.println("Nhập số trang:");
        this.numberOfPages = Config.getInteger();
        System.out.println("Nhập giá nhập sách:");
        this.importPrice = Config.getInteger();
        this.exportPrice = importPrice*RATE;
        System.out.println("Nhập số lượng:");
        this.quantity = Config.getInteger();
        System.out.println("Nhập trạng thái (true/false): ");
        this.bookStatus = Config.getBoolean();
    }

    @Override
    public void displayData() {
        System.out.println("-----------------------------------------------------");
        System.out.println("|| ID: " + bookId + " Name: " +bookName + " Author: " + author.getAuthorName() +
                " ExportPrice: " + exportPrice + " Quantity: " + quantity + " BookStatus: " + bookStatus+" ||");
    }
}
