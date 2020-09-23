package njust.cs1.shortmessagesystemweb.service;


import njust.cs1.shortmessagesystemweb.dao.ContactDao;
import njust.cs1.shortmessagesystemweb.pojo.Contact;
import njust.cs1.shortmessagesystemweb.pojo.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    ContactDao contactDao;

    public List<Contact> findAllByLoginname(String loginname){
        return contactDao.findAllByLoginname(loginname);
    }
    public void deleteById(int id){
        contactDao.deleteById(id);
    }

    public int editContact(Contact contact){
        System.out.println(contact.getLoginname());
        System.out.println(contact.getName());
        System.out.println(contact.getPhone());
        System.out.println(contact.getEmail());
        System.out.println(contact.getId());
        Contact contactInDB = contactDao.getByLoginname(contact.getLoginname());
        contactInDB.setName(contact.getName());
        contactInDB.setPhone(contact.getPhone());
        contactInDB.setEmail(contact.getEmail());
        contactDao.save(contactInDB);
        return 1;
    }

    public int  contactRegister(Contact contact){
        System.out.println(contact.getLoginname());
        System.out.println(contact.getName());
        System.out.println(contact.getPhone());
        System.out.println(contact.getEmail());
        contactDao.save(contact);
        return 1;
    }


}
