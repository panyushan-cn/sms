package njust.cs1.shortmessagesystemweb.dao;

import njust.cs1.shortmessagesystemweb.pojo.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AdminRoleDAO extends JpaRepository<AdminRole, Integer> {
    AdminRole findById(int id);
}
