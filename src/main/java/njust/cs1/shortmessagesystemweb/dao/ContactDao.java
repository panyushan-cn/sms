package njust.cs1.shortmessagesystemweb.dao;

import njust.cs1.shortmessagesystemweb.pojo.Contact;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ConcurrentModificationException;
import java.util.List;


@Repository

public interface ContactDao extends JpaRepository<Contact,Integer>{
    List<Contact> findAllByLoginname(String loginname);
    @Modifying
    @Transactional
    void deleteByName(String name);
    @Modifying
    @Transactional
    void deleteById(int id);
    Contact getByLoginname(String loginname);

}
