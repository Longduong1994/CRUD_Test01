package ra.service;


import ra.bussinessImp.Author;

import java.util.ArrayList;
import java.util.List;

public class AuthorService {
    List<Author> authors;

    public AuthorService() {
        authors = new ArrayList<Author>();
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public int getSize() {
        return authors.size();
    }

    public int newId() {
        int max = 0;
        for (Author author : authors) {
            if (author.getAuthorId() > max) {
                max = author.getAuthorId();
            }
        }
        return max + 1;
    }

    public Author findById(int id) {
        for (Author author : authors) {
            if (author.getAuthorId() == id) {
                return author;
            }
        }
        return null;
    }

    public void save(Author author) {
        if(findById(author.getAuthorId())==null){
            authors.add(author);
        }else{
            authors.set(authors.indexOf(author.getAuthorId()),author);
        }
    }

    public void delete(Author author){
        if(findById(author.getAuthorId())==null){
            System.out.println("ID không tồn tại!!!");
            return;
        }
        authors.remove(author.getAuthorId());
    }


}
