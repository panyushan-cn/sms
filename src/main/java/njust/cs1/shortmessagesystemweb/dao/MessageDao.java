package njust.cs1.shortmessagesystemweb.dao;

import njust.cs1.shortmessagesystemweb.pojo.Message;
import njust.cs1.shortmessagesystemweb.pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MessageDao extends JpaRepository<Message,Integer> {

    @Modifying
    @Query("update Message b set b.category.id=?1 where b.send=?2")
    void updateBookCid(@Param("receive") int receive1, @Param("receive1") String receive2);

    List<Message> findAllByCategory(Category category);
    List<Message> findAllByReceive(String receive);
    List<Message> findAllByReceiveOrSend(String receive, String send);
    List<Message> findAllByThemeLikeOrDetailLike(String keyword1, String keyword2);
    List<Message> findAllByCategoryAndReceiveEquals(Category category, String receive);
    List<Message> findAllByCategoryAndReceiveEqualsOrSendEquals(Category categoty, String receive, String send);
    List<Message> findAllByReceiveOrSendAndCategory(String receive, String send, Category category);
    List<Message> findAllByCategoryAndReceiveOrCategoryAndSend(Category category, String receive, Category category1, String send);
    List<Message> findAllByCategoryAndReceive(Category category, String receive);
    List<Message> findAllByCategoryAndSend(Category category, String receive);
}
