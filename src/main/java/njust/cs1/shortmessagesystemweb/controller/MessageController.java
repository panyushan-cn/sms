package njust.cs1.shortmessagesystemweb.controller;
import njust.cs1.shortmessagesystemweb.pojo.Message;
import njust.cs1.shortmessagesystemweb.result.Result;
import njust.cs1.shortmessagesystemweb.result.ResultFactory;
import njust.cs1.shortmessagesystemweb.service.MessageService;
import njust.cs1.shortmessagesystemweb.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
public class MessageController {
    @Autowired
    MessageService messageService;


    @CrossOrigin
    @GetMapping("/api/messages")
    public List<Message> list() throws Exception {
        return messageService.list();
    }

    public List<Message> listByReceiveOrSend(String receive){
        return messageService.listByReceiveOrSend(receive);
    }


    @CrossOrigin
    @PostMapping("/api/admin/content/messages")
    public Result addOrUpdate(@RequestBody Message message) throws Exception {
        messageService.addOrUpdate(message);
        return ResultFactory.buildSuccessResult_p("修改成功", null);
    }


    @CrossOrigin
    @PostMapping("/api/admin/content/messages/delete")
    public Result delete(@RequestBody Message message) throws Exception {
        messageService.deleteById(message.getId());
        return ResultFactory.buildSuccessResult_p("删除成功", null);
    }


    @CrossOrigin
    @GetMapping("/api/categories/{cid}/messages")
    public List<Message> listByCategory(@PathVariable("cid") int cid) throws Exception {
        if (cid != 0) {
            return messageService.listByCategory(cid);
        } else {
            return list();
        }
    }

    @CrossOrigin
    @GetMapping("/api/categories/{cid}/messages/{receive}")
    public List<Message> listByReceiveAndCategory(@PathVariable("cid" ) int cid, @PathVariable("receive") String receive)  throws Exception{
        if (cid != 0 && receive!=null)  {
            //bookService.updateBookCid(3,receive);
            return null;
        } else {
            return listByReceiveOrSend(receive);
        }
    }

    @CrossOrigin
    @GetMapping("/api/categories/{cid}/messages1/{receive}")
    public List<Message> listByReceiveAndCategory1(@PathVariable("cid" ) int cid, @PathVariable("receive") String receive)  throws Exception{
        if (cid != 0 && receive!=null)  {
            //bookService.updateBookCid(3,receive);
            return messageService.listByCategoryAndReceive(cid,receive);
        } else {
            return listByReceiveOrSend(receive);
        }
    }
    @CrossOrigin
    @GetMapping("/api/categories/{cid}/messages2/{receive}")
    public List<Message> listByReceiveAndCategory2(@PathVariable("cid" ) int cid, @PathVariable("receive") String receive)  throws Exception{
        if (cid != 0 && receive!=null)  {
            //bookService.updateBookCid(3,receive);
            return messageService.listByCategoryAndReceive(3, receive);
        } else {
            return listByReceiveOrSend(receive);
        }
    }
    @CrossOrigin
    @GetMapping("/api/categories/{cid}/messages3/{receive}")
    public List<Message> listByReceiveAndCategory3(@PathVariable("cid" ) int cid, @PathVariable("receive") String receive)  throws Exception{
        if (cid != 0 && receive!=null)  {
            //bookService.updateBookCid(3,receive);
            return messageService.listByCategoryAndSend(cid, receive);
        } else {
            return listByReceiveOrSend(receive);
        }
    }

    @CrossOrigin
    @GetMapping("/api/categories/{cid}/messages4/{receive}")
    public List<Message> listByReceiveAndCategory4(@PathVariable("cid" ) int cid, @PathVariable("receive") String receive)  throws Exception{
        if (cid != 0 && receive!=null)  {
            //bookService.updateBookCid(3,receive);
            return messageService.listByCategoryAndSend(cid, receive);
        } else {
            return listByReceiveOrSend(receive);
        }
    }

    @CrossOrigin
    @GetMapping("/api/search")
    public List<Message> searchResult(@RequestParam("keywords") String keywords) {
        // 关键词为空时查询出所有书籍
        if ("".equals(keywords)) {
            return messageService.list();
        } else {
            return messageService.Search(keywords);
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
    public List<Message> listByReceive(@PathVariable("receive") String receive) throws Exception{
        if (receive!=null){
            return messageService.listByReceiveOrSend(receive);
        }
        else {
            return list();
        }
    }

}
