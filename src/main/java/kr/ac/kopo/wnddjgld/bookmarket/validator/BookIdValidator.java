package kr.ac.kopo.wnddjgld.bookmarket.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import kr.ac.kopo.wnddjgld.bookmarket.domain.Book;
import kr.ac.kopo.wnddjgld.bookmarket.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookIdValidator implements ConstraintValidator<BookId, String> {
    @Autowired
    private BookService bookService;

    @Override
    public void initialize(BookId constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String bookId, ConstraintValidatorContext constraintValidatorContext) {
        Book book = null;
        try {
            book = bookService.getBookById(bookId);
        }catch (RuntimeException e) {
            return true;
        }

        if(book != null) {
            return false;
        }
        return true;
    }
}
