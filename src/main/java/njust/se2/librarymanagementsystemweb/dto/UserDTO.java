package njust.se2.librarymanagementsystemweb.dto;

import lombok.Data;
import lombok.ToString;
import njust.se2.librarymanagementsystemweb.dto.base.OutputConverter;
import njust.se2.librarymanagementsystemweb.pojo.AdminRole;
import njust.se2.librarymanagementsystemweb.pojo.User;

import java.util.List;

@Data
@ToString
public class UserDTO implements OutputConverter<UserDTO, User> {

    private int id;

    private String username;

    private String name;

    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public List<AdminRole> getRoles() {
        return roles;
    }

    public void setRoles(List<AdminRole> roles) {
        this.roles = roles;
    }

    private String email;

    private int enabled;

    private List<AdminRole> roles;

}
