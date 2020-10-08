package njust.cs1.shortmessagesystemweb.service;

import njust.cs1.shortmessagesystemweb.dao.CategoryDao;
import njust.cs1.shortmessagesystemweb.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryDao categoryDAO;

    /**
     * 将短消息列表根据id排序
     * @return 排序过后的短消息列表
     */
    public List<Category> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        return categoryDAO.findAll(sort);
    }

    /**
     * 获取短消息id信息
     * @param id 短消息id信息
     * @return 查询是否库中有此id信息，没有则添加，有则返回。
     */
    public Category get(int id) {
        return categoryDAO.findById(id).orElse(null);
    }
}
