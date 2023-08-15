package lk.ijse.dep10.library.book.repository;

import lk.ijse.dep10.library.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends JpaRepository<Book,String> {

}
