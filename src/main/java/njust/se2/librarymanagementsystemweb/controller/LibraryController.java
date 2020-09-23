package njust.se2.librarymanagementsystemweb.controller;
import njust.se2.librarymanagementsystemweb.pojo.Book;
import njust.se2.librarymanagementsystemweb.result.Result;
import njust.se2.librarymanagementsystemweb.result.ResultFactory;
import njust.se2.librarymanagementsystemweb.service.BookService;
import njust.se2.librarymanagementsystemweb.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
public class LibraryController {
    @Autowired
    BookService bookService;

    /**
     * 获取书籍列表
     *
     * @return 返回列表 json
     * @throws Exception 异常
     */
    @CrossOrigin
    @GetMapping("/api/messages")
    public List<Book> list() throws Exception {
        return bookService.list();
    }

    public List<Book> listByReceiveOrSend(String receive){
        return bookService.listByReceiveOrSend(receive);
    }

    /**
     * 返回书籍对象，更新状态。
     *
     * @param book 书籍对象
     * @return 更改过后的书籍对象
     * @throws Exception 异常
     */
    @CrossOrigin
    @PostMapping("/api/admin/content/messages")
    public Result addOrUpdate(@RequestBody Book book) throws Exception {
        bookService.addOrUpdate(book);
        return ResultFactory.buildSuccessResult_p("修改成功", null);
    }

    /**
     * 根据id删除id操作
     *
     * @param book 书籍对象
     * @throws Exception 异常
     */
    @CrossOrigin
    @PostMapping("/api/admin/content/messages/delete")
    public Result delete(@RequestBody Book book) throws Exception {
        bookService.deleteById(book.getId());
        return ResultFactory.buildSuccessResult_p("删除成功", null);
    }

    /**
     * 根据类别查找书籍
     *
     * @param cid 书籍类别
     * @return 书籍列表
     * @throws Exception 异常
     */
    @CrossOrigin
    @GetMapping("/api/categories/{cid}/messages")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (cid != 0) {
            return bookService.listByCategory(cid);
        } else {
            return list();
        }
    }

    @CrossOrigin
    @GetMapping("/api/categories/{cid}/messages/{receive}")
    public List<Book> listByReceiveAndCategory(@PathVariable("cid" ) int cid,@PathVariable("receive") String receive)  throws Exception{
        if (cid != 0 && receive!=null)  {
            //bookService.updateBookCid(3,receive);
            return null;
        } else {
            return listByReceiveOrSend(receive);
        }
    }

    @CrossOrigin
    @GetMapping("/api/categories/{cid}/messages1/{receive}")
    public List<Book> listByReceiveAndCategory1(@PathVariable("cid" ) int cid,@PathVariable("receive") String receive)  throws Exception{
        if (cid != 0 && receive!=null)  {
            //bookService.updateBookCid(3,receive);
            return bookService.listByCategoryAndReceive(cid,receive);
        } else {
            return listByReceiveOrSend(receive);
        }
    }
    @CrossOrigin
    @GetMapping("/api/categories/{cid}/messages2/{receive}")
    public List<Book> listByReceiveAndCategory2(@PathVariable("cid" ) int cid,@PathVariable("receive") String receive)  throws Exception{
        if (cid != 0 && receive!=null)  {
            //bookService.updateBookCid(3,receive);
            return bookService.listByCategoryAndReceive(3, receive);
        } else {
            return listByReceiveOrSend(receive);
        }
    }
    @CrossOrigin
    @GetMapping("/api/categories/{cid}/messages3/{receive}")
    public List<Book> listByReceiveAndCategory3(@PathVariable("cid" ) int cid,@PathVariable("receive") String receive)  throws Exception{
        if (cid != 0 && receive!=null)  {
            //bookService.updateBookCid(3,receive);
            return bookService.listByCategoryAndSend(cid, receive);
        } else {
            return listByReceiveOrSend(receive);
        }
    }

    @CrossOrigin
    @GetMapping("/api/categories/{cid}/messages4/{receive}")
    public List<Book> listByReceiveAndCategory4(@PathVariable("cid" ) int cid,@PathVariable("receive") String receive)  throws Exception{
        if (cid != 0 && receive!=null)  {
            //bookService.updateBookCid(3,receive);
            return bookService.listByCategoryAndSend(cid, receive);
        } else {
            return listByReceiveOrSend(receive);
        }
    }
    /**
     * 根据关键字查询书籍
     *
     * @param keywords 关键字
     * @return 书籍列表
     */
    @CrossOrigin
    @GetMapping("/api/search")
    public List<Book> searchResult(@RequestParam("keywords") String keywords) {
        // 关键词为空时查询出所有书籍
        if ("".equals(keywords)) {
            return bookService.list();
        } else {
            return bookService.Search(keywords);
        }
    }

    @CrossOrigin
    @PostMapping("/api/admin/content/messages/attachment")
    public String coversUpload(MultipartFile file) throws Exception {
        String folderPath = "D:/workspace/img";
        File imageFolder = new File(folderPath);
        if (file.getOriginalFilename().endsWith(".jpeg")) {
            File f = new File(imageFolder, StringUtils.getRandomString(8) + Objects.requireNonNull(file.getOriginalFilename())
                    .substring(file.getOriginalFilename().length() - 5));
            if (!f.getParentFile().exists()) {
                f.getParentFile().mkdirs();
            }
            try {
                file.transferTo(f);
                return "http://localhost:8998/api/file/" + f.getName();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        } else {
            File f = new File(imageFolder, StringUtils.getRandomString(8) + Objects.requireNonNull(file.getOriginalFilename())
                    .substring(file.getOriginalFilename().length() - 4));
            if (!f.getParentFile().exists()) {
                f.getParentFile().mkdirs();
            }
            try {
                file.transferTo(f);
                return "http://localhost:8998/api/file/" + f.getName();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }

    }



    @CrossOrigin
    @GetMapping("/api/receive/{receive}/messages")
    public List<Book> listByReceive(@PathVariable("receive") String receive) throws Exception{
        if (receive!=null){
            return bookService.listByReceiveOrSend(receive);
        }
        else {
            return list();
        }
    }

}
