package lk.ijse.dep10.library.book.api;

import lk.ijse.dep10.library.book.dto.BookDTO;
import lk.ijse.dep10.library.book.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBook(@RequestBody @Validated BookDTO bookDTO){
        bookService.saveBook(bookDTO);
    }

    @PatchMapping(value = "/{isbn}",consumes = "application/json")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBook(@RequestBody @Validated BookDTO bookDTO, @PathVariable String isbn){
        bookDTO.setIsbn(isbn);
        bookService.updateBook(bookDTO);
    }

    @DeleteMapping("/{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeBook(@PathVariable String isbn){
        bookService.deleteBook(isbn);
    }

    @GetMapping("/{isbn}")
    public BookDTO getBook(@PathVariable String isbn){
         return bookService.getBook(isbn);

    }

    @GetMapping
    public List<BookDTO> findBooks(@RequestParam(value = "q",required = false) String query){
        if(query==null) query="";
        return bookService.findBooks(query);
    }


}
