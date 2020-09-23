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
    @Query("update Book b set b.category.id=?1 where b.send=?2")
    void updateBookCid(@Param("receive") int receive1, @Param("receive1") String receive2);

    List<Book> findAllByCategory(Category category);
    List<Book> findAllByReceive(String receive);
    List<Book> findAllByReceiveOrSend(String receive,String send);
    List<Book> findAllByThemeLikeOrDetailLike(String keyword1, String keyword2);
    List<Book> findAllByCategoryAndReceiveEquals(Category category, String receive);
    List<Book> findAllByCategoryAndReceiveEqualsOrSendEquals(Category categoty,String receive,String send);
    List<Book> findAllByReceiveOrSendAndCategory(String receive,String send,Category category);
    List<Book> findAllByCategoryAndReceiveOrCategoryAndSend(Category category, String receive, Category category1,String send);
    List<Book> findAllByCategoryAndReceive(Category category,String receive);
    List<Book> findAllByCategoryAndSend(Category category,String receive);
}
