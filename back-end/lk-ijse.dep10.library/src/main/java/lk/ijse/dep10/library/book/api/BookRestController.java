package lk.ijse.dep10.library.book.api;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/books")
public class BookRestController {


    @PostMapping
    public String saveBook(){
        return "<h1>save book</h1>";
    }


    @PatchMapping
    public String updateBook(){
        return "<h1>update book</h1>";
    }


    @DeleteMapping
    public String removeBook(){
        return "<h1>remove book</h1>";
    }


    @GetMapping
    public String getBook(){
        return "<h1>get book</h1>";
    }


    @GetMapping
    public String findBook(){
        return "<h1>find books</h1>";
    }

}
