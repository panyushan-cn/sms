package njust.se2.librarymanagementsystemweb.service;

import njust.se2.librarymanagementsystemweb.dao.BookDao;
import njust.se2.librarymanagementsystemweb.pojo.Book;
import njust.se2.librarymanagementsystemweb.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookDao bookDAO;
    @Autowired
    CategoryService categoryService;

    /**
     * 返回所有书籍的列表
     * @return 书籍列表
     */
    public List<Book> list() {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        return bookDAO.findAll(sort);
    }

    /**
     * 无主键则增添，有主键则更新。
     * @param book 书籍对象
     */
    public void addOrUpdate(Book book) {
        bookDAO.save(book);
    }

    /**
     * 根据id删除书籍
     * @param id 书的id
     */
    public void deleteById(int id) {
        bookDAO.deleteById(id);
    }

    /**
     * 根据cid列出所有书籍信息
     * @param cid 类别id
     * @return 所有符合条件的书籍列表信息
     */
    public List<Book> listByCategory(int cid) {
        Category category = categoryService.get(cid);
        return bookDAO.findAllByCategory(category);
    }

    /**
     * 根据关键字查询书籍信息
     * @param keywords  关键字
     * @return 符合关键字条件的书籍列表
     */
    public List<Book> Search(String keywords) {
        return bookDAO.findAllByThemeLikeOrDetailLike('%' + keywords + '%', '%' + keywords + '%');
    }

    public void updateBookCid(int receive,String receive1){
        bookDAO.updateBookCid(receive,receive1);
    }
    public List<Book> listByReceive(String receive){
        return bookDAO.findAllByReceive(receive);
    }
    public List<Book> listByReceiveOrSend(String receive){
        return bookDAO.findAllByReceiveOrSend(receive,receive);
    }
    public List<Book> listByCategoryAndReceiveEquals(int cid,String receive){
        Category category = categoryService.get(cid);
        return bookDAO.findAllByCategoryAndReceiveEquals(category,receive);
    }

    public List<Book> listByCategoryAndReceiveOrSend(int cid,String receive,String send){
        Category category = categoryService.get(cid);
        return bookDAO.findAllByCategoryAndReceiveEqualsOrSendEquals(category,receive,send);
    }
    public List<Book> listByReceiveOrSendAndCategory(String receive,String send,int cid){
        Category category = categoryService.get(cid);
        return bookDAO.findAllByReceiveOrSendAndCategory(receive,send,category);
    }
    public List<Book> listByCategoryAndReceiveOrCategoryAndSend(int cid,String receive,String send){
        Category category = categoryService.get(cid);
        return bookDAO.findAllByCategoryAndReceiveOrCategoryAndSend(category,receive,category,send);
    }
    public List<Book> listByCategoryAndReceive(int cid,String receive){
        Category category = categoryService.get(cid);
        return bookDAO.findAllByCategoryAndReceive(category,receive);
    }
    public List<Book> listByCategoryAndSend(int cid,String receive){
        Category category=categoryService.get(cid);
        return bookDAO.findAllByCategoryAndSend(category, receive);
    }
}
