package njust.cs1.shortmessagesystemweb.dao;

import njust.cs1.shortmessagesystemweb.pojo.AdminPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminPermissionDAO extends JpaRepository<AdminPermission, Integer> {
    AdminPermission findById(int id);
}
