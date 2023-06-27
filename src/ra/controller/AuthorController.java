package ra.controller;

import ra.bussinessImp.Author;
import ra.service.AuthorService;

import java.util.List;

public class AuthorController {
    AuthorService authorService = new AuthorService();
    public List<Author> getAll(){
       return authorService.getAuthors();
    }
    public int getSize() {
        return authorService.getSize();
    }
    public int newId( ){
        return authorService.newId();
    }

    public void save(Author author){
        authorService.save(author);
    }
    public void delete(Author author){
        authorService.delete(author);
    }
}
