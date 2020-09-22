package njust.se2.librarymanagementsystemweb.dao;

import njust.se2.librarymanagementsystemweb.LibrarymanagementsystemWebApplication;
import njust.se2.librarymanagementsystemweb.pojo.Book;
import njust.se2.librarymanagementsystemweb.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.swing.*;
import java.util.List;

public interface BookDao extends JpaRepository<Book,Integer> {

    @Modifying
    @Query("update Book b set b.category.id=?1 where b.date=?2")
    void updateBookCid(@Param("press") int press1, @Param("press1") String press2);

    List<Book> findAllByCategory(Category category);
    List<Book> findAllByPress(String press);
    List<Book> findAllByPressOrDate(String press,String date);
    List<Book> findAllByTitleLikeOrAuthorLike(String keyword1, String keyword2);
    List<Book> findAllByCategoryAndPressEquals(Category category, String press);
    List<Book> findAllByCategoryAndPressEqualsOrDateEquals(Category categoty,String press,String date);
    List<Book> findAllByPressOrDateAndCategory(String press,String date,Category category);
    List<Book> findAllByCategoryAndPressOrCategoryAndDate(Category category, String press, Category category1,String date);
    List<Book> findAllByCategoryAndPress(Category category,String press);
    List<Book> findAllByCategoryAndDate(Category category,String press);
}
