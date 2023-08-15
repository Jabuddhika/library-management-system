package lk.ijse.dep10.library.book.api;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/books")
public class BookRestController {


    @PostMapping
    public String saveBook(){
        System.out.println("psot");
        return "post";
    }

    @PatchMapping("/{isbn}")
    public String updateBook(){
        System.out.println("upadte");
        return "update";
    }

    @DeleteMapping("/{isbn}")
    public String removeBook(){
        System.out.println("remove");
        return "remove";
    }

    @GetMapping("/{isbn}")
    public String getBook(){
        System.out.println("get");
        return "get";
    }

    @GetMapping
    public String findBooks(){
        System.out.println("find");
        return "find";
    }


}
