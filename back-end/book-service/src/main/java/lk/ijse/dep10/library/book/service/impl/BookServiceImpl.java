package lk.ijse.dep10.library.book.service.impl;

import lk.ijse.dep10.library.book.dto.BookDTO;
import lk.ijse.dep10.library.book.entity.Book;
import lk.ijse.dep10.library.book.repository.BookRepository;
import lk.ijse.dep10.library.book.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveBook(BookDTO bookDTO) {
        if(bookRepository.existsById(bookDTO.getIsbn()))
            throw new ResponseStatusException(HttpStatus.CONFLICT,"The isbn"
                    +bookDTO.getIsbn()+"already exist");

        bookRepository.save(modelMapper.map(bookDTO, Book.class));
    }

    @Override
    public void updateBook(BookDTO bookDTO) {
        if(!bookRepository.existsById(bookDTO.getIsbn()))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "The isbn "+bookDTO.getIsbn()+"does not exist");
        bookRepository.save(modelMapper.map(bookDTO, Book.class));

    }

    @Override
    public void deleteBook(String isbn) {
        if(!bookRepository.existsById(isbn))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "The isbn "+isbn+"does not exist");

        bookRepository.deleteById(isbn);

   /*  todo:    check whether book has been issued; */
    }

    @Override
    public BookDTO getBook(String isbn) {
      return bookRepository.findById(isbn).map(book -> modelMapper.map(book, BookDTO.class)).
               orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"The isbn "+isbn+ "doesnt exist"));
    }

    @Override
    public List<BookDTO> findBooks(String query) {
      return bookRepository.findBookByIsbnLikeOrTitleLikeOrAuthorLike
              (query,query,query).stream().map(book->modelMapper.
              map(book, BookDTO.class)).collect(Collectors.toList());
    }
}
