package lk.ijse.dep10.library.book.repository;

import lk.ijse.dep10.library.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,String> {

    List<Book> findBookByIsbnLikeOrTitleLikeOrAuthorLike(String q1,String q2,String q3);
}
