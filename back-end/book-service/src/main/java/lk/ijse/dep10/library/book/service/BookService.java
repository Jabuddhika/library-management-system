package lk.ijse.dep10.library.book.service;

import lk.ijse.dep10.library.book.dto.BookDTO;

import java.util.List;

public interface BookService {

    void saveBook(BookDTO bookDTO);

    void updateBook(BookDTO bookDTO);

    void deleteBook(String isbn);

    BookDTO getBook(String isbn);

    List<BookDTO> findBooks(String query);

}
