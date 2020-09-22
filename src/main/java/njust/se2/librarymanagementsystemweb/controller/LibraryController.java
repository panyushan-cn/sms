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
    @GetMapping("/api/books")
    public List<Book> list() throws Exception {
        return bookService.list();
    }

    public List<Book> listByPressOrDate(String press){
        return bookService.listByPressOrDate(press);
    }

    /**
     * 返回书籍对象，更新状态。
     *
     * @param book 书籍对象
     * @return 更改过后的书籍对象
     * @throws Exception 异常
     */
    @CrossOrigin
    @PostMapping("/api/admin/content/books")
    public Result addOrUpdate(@RequestBody Book book) throws Exception {
        bookService.addOrUpdate(book);
        return ResultFactory.buildSuccessResult("修改成功");
    }

    /**
     * 根据id删除id操作
     *
     * @param book 书籍对象
     * @throws Exception 异常
     */
    @CrossOrigin
    @PostMapping("/api/admin/content/books/delete")
    public void delete(@RequestBody Book book) throws Exception {
        int id = book.getId();
        bookService.deleteById(book.getId());
    }

    /**
     * 根据类别查找书籍
     *
     * @param cid 书籍类别
     * @return 书籍列表
     * @throws Exception 异常
     */
    @CrossOrigin
    @GetMapping("/api/categories/{cid}/books")
    public List<Book> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (cid != 0) {
            return bookService.listByCategory(cid);
        } else {
            return list();
        }
    }

    @CrossOrigin
    @GetMapping("/api/categories/{cid}/books/{press}")
    public List<Book> listByPressAndCategory(@PathVariable("cid" ) int cid,@PathVariable("press") String press)  throws Exception{
        if (cid != 0 && press!=null)  {
            //bookService.updateBookCid(3,press);
            return null;
        } else {
            return listByPressOrDate(press);
        }
    }

    @CrossOrigin
    @GetMapping("/api/categories/{cid}/books1/{press}")
    public List<Book> listByPressAndCategory1(@PathVariable("cid" ) int cid,@PathVariable("press") String press)  throws Exception{
        if (cid != 0 && press!=null)  {
            //bookService.updateBookCid(3,press);
            return bookService.listByCategoryAndPress(cid,press);
        } else {
            return listByPressOrDate(press);
        }
    }
    @CrossOrigin
    @GetMapping("/api/categories/{cid}/books2/{press}")
    public List<Book> listByPressAndCategory2(@PathVariable("cid" ) int cid,@PathVariable("press") String press)  throws Exception{
        if (cid != 0 && press!=null)  {
            //bookService.updateBookCid(3,press);
            return bookService.listByCategoryAndPress(3, press);
        } else {
            return listByPressOrDate(press);
        }
    }
    @CrossOrigin
    @GetMapping("/api/categories/{cid}/books3/{press}")
    public List<Book> listByPressAndCategory3(@PathVariable("cid" ) int cid,@PathVariable("press") String press)  throws Exception{
        if (cid != 0 && press!=null)  {
            //bookService.updateBookCid(3,press);
            return bookService.listByCategoryAndDate(cid, press);
        } else {
            return listByPressOrDate(press);
        }
    }

    @CrossOrigin
    @GetMapping("/api/categories/{cid}/books4/{press}")
    public List<Book> listByPressAndCategory4(@PathVariable("cid" ) int cid,@PathVariable("press") String press)  throws Exception{
        if (cid != 0 && press!=null)  {
            //bookService.updateBookCid(3,press);
            return bookService.listByCategoryAndDate(cid, press);
        } else {
            return listByPressOrDate(press);
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
    @PostMapping("/api/admin/content/books/covers")
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
    @GetMapping("/api/press/{press}/books")
    public List<Book> listByPress(@PathVariable("press") String press) throws Exception{
        if (press!=null){
            return bookService.listByPressOrDate(press);
        }
        else {
            return list();
        }
    }

}
