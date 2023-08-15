package lk.ijse.dep10.library.book.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Validated
public class BookDTO implements Serializable {

    @NotBlank(message = "isbn cant be empty")
    private String isbn;

    @NotBlank(message = "title cant be empty")
    private String title;
    @Pattern(regexp = "^[A-Za-z ]+$",message = "author name is invalid")
    @NotBlank
    private String author;

    @NotNull(message = "copies cant be null")
    @PositiveOrZero(message = "copies cant be negative")
    private Integer copies;

}
