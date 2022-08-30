package com.example.demo.es;

/**
 * @Create: IntelliJ IDEA.
 * @Author: subtlman_ljx
 * @Date: 2022/08/30/14:28
 * @Description:
 */
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 第一种方式，类似于JPA，编写一个ElasticsearchRepository
 *  第一个泛型为Bean的类型
 *  第二个泛型为Bean的主键类型
 */
@Repository
@Component
@Mapper
public interface SysUserDao extends ElasticsearchRepository<SysUser,String> {

}
