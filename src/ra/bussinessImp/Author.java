package ra.bussinessImp;

import ra.bussiness.IShop;
import ra.config.Config;

import java.util.Scanner;

public class Author implements IShop {
    private int authorId;
    private String authorName;
    boolean sex;
    int year;

    @Override
    public void inputData() {
        System.out.println("Nhập tên tác giả: ");
        this.authorName = Config.getString();
        System.out.println("Nhập giới tính (true/false): ");
        this.sex = Config.getBoolean();
        System.out.println("Nhập năm:");
        this.year = Config.getInteger();
    }

    @Override
    public void displayData() {
        System.out.println("-----------------------------------------------------");
        System.out.println("||  ID: " + authorId + " Name: " + authorName + " Sex: " + (sex ? "Nam" : "Nữ") + " ||");

    }

    public Author() {
    }

    public Author(int authorId, String authorName, boolean sex, int year) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.sex = sex;
        this.year = year;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
