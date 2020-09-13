package njust.se2.librarymanagementsystemweb.controller;

import njust.se2.librarymanagementsystemweb.pojo.Book;
import njust.se2.librarymanagementsystemweb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    /**
     * 获取书籍列表
     * @return 返回列表 json
     * @throws Exception 异常
     */
    @GetMapping("/api/books")
    public List<Book> list() throws Exception {
        return bookService.list();
    }

    /**
     * 返回书籍对象，更新状态。
     * @param book 书籍对象
     * @return 更改过后的书籍对象
     * @throws Exception 异常
     */
    @PostMapping("/api/books")
    public Book addOrUpdate(@RequestBody Book book) throws Exception {
        bookService.addOrUpdate(book);
        return book;
    }

    /**
     * 根据id删除id操作
     * @param book 书籍对象
     * @throws Exception 异常
     */
    @PostMapping("/api/delete")
    public void delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
    }


    /**
     * 根据类别查找书籍
     * @param cid 书籍类别
     * @return 书籍列表
     * @throws Exception 异常
     */
    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (cid != 0) {
            return bookService.listByCategory(cid);
        } else {
            return list();
        }
    }
}
