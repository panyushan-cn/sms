package njust.se2.librarymanagementsystemweb.dto;

import lombok.Data;
import lombok.ToString;
import njust.se2.librarymanagementsystemweb.dto.base.OutputConverter;
import njust.se2.librarymanagementsystemweb.pojo.Book;

@Data
@ToString
public class BookDTO implements OutputConverter<BookDTO, Book> {

    private int id;

    private String theme;

    private String receive;

    private String detail;

    private String send;

    private String abs;

    private String attachment;

    private int cid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getReceive() {
        return receive;
    }

    public void setReceive(String receive) {
        this.receive = receive;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = send;
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
}
