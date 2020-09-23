package njust.cs1.shortmessagesystemweb.service;

import njust.cs1.shortmessagesystemweb.dao.MessageDao;
import njust.cs1.shortmessagesystemweb.pojo.Category;
import njust.cs1.shortmessagesystemweb.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageDao messageDAO;
    @Autowired
    CategoryService categoryService;

    /**
     * 返回所有书籍的列表
     * @return 书籍列表
     */
    public List<Message> list() {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        return messageDAO.findAll(sort);
    }

    /**
     * 无主键则增添，有主键则更新。
     * @param message 书籍对象
     */
    public void addOrUpdate(Message message) {
        messageDAO.save(message);
    }

    /**
     * 根据id删除书籍
     * @param id 书的id
     */
    public void deleteById(int id) {
        messageDAO.deleteById(id);
    }

    /**
     * 根据cid列出所有书籍信息
     * @param cid 类别id
     * @return 所有符合条件的书籍列表信息
     */
    public List<Message> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        return messageDAO.findAllByCategory(category);
    }

    /**
     * 根据关键字查询书籍信息
     * @param keywords  关键字
     * @return 符合关键字条件的书籍列表
     */
    public List<Message> Search(String keywords) {
        return messageDAO.findAllByThemeLikeOrDetailLike('%' + keywords + '%', '%' + keywords + '%');
    }

    public void updateBookCid(int receive,String receive1){
        messageDAO.updateBookCid(receive,receive1);
    }
    public List<Message> listByReceive(String receive){
        return messageDAO.findAllByReceive(receive);
    }
    public List<Message> listByReceiveOrSend(String receive){
        return messageDAO.findAllByReceiveOrSend(receive,receive);
    }
    public List<Message> listByCategoryAndReceiveEquals(int cid, String receive){
        Category category = categoryService.get(cid);
        return messageDAO.findAllByCategoryAndReceiveEquals(category,receive);
    }

    public List<Message> listByCategoryAndReceiveOrSend(int cid, String receive, String send){
        Category category = categoryService.get(cid);
        return messageDAO.findAllByCategoryAndReceiveEqualsOrSendEquals(category,receive,send);
    }
    public List<Message> listByReceiveOrSendAndCategory(String receive, String send, int cid){
        Category category = categoryService.get(cid);
        return messageDAO.findAllByReceiveOrSendAndCategory(receive,send,category);
    }
    public List<Message> listByCategoryAndReceiveOrCategoryAndSend(int cid, String receive, String send){
        Category category = categoryService.get(cid);
        return messageDAO.findAllByCategoryAndReceiveOrCategoryAndSend(category,receive,category,send);
    }
    public List<Message> listByCategoryAndReceive(int cid, String receive){
        Category category = categoryService.get(cid);
        return messageDAO.findAllByCategoryAndReceive(category,receive);
    }
    public List<Message> listByCategoryAndSend(int cid, String receive){
        Category category=categoryService.get(cid);
        return messageDAO.findAllByCategoryAndSend(category, receive);
    }
}
