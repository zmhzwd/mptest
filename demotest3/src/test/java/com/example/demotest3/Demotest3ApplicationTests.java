package com.example.demotest3;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demotest3.entity.User;
import com.example.demotest3.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class Demotest3ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    //修改
    @Test
    public void TestUpdate(){
        User user=new User();
        user.setId(1645750773071515649L);
        user.setName("James2");
        int num=userMapper.updateById(user);
        System.out.println(num);
    }

    //添加
    @Test
    public void testAdd(){
        User user=new User();
        user.setName("Lucy3");
        user.setAge(21);
        user.setEmail("123@163.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }

//查找
    @Test
    void findall() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    //测试乐观锁
    @Test
    public void testOptimisticLocker(){
        //根据id查询再修改
        User user = userMapper.selectById(1645963559047299073L);
        user.setName("czl");
        userMapper.updateById(user);

    }

    //简单条件查询
    @Test
    public void testSelect2()
    {
        Map<String, Object> columnMap=new HashMap<>();
        columnMap.put("name","Jack");
        columnMap.put("age",20);
        List<User> users = userMapper.selectByMap(columnMap);
        System.out.println(users);
    }

    //分页查询
    @Test
    public void testSelectPage(){
        Page<User> page=new Page<>(1,3);
        Page<User> page1 = userMapper.selectPage(page,null);
        //返回对象得到分页所以数据
        long pages = page1.getPages();
        long current = page1.getCurrent();
        List<User> records = page1.getRecords();
        long total = page1.getTotal();
        boolean hasNext = page1.hasNext();
        boolean hasPrevious = page.hasPrevious();
        System.out.println(pages);
        System.out.println(current);
        System.out.println(records);
        System.out.println(total);
        System.out.println(hasNext);
        System.out.println(hasPrevious);
    }


    //多个id批量查询
    @Test
    public void testSelect1(){

        List<User> users = userMapper.selectBatchIds(Arrays.asList(1,2,3));
        System.out.println(users);
    }

    //根据Id删除
    @Test
    public void testDDelete(){
        int rows =userMapper.deleteById(1L);
        System.out.println(rows);
    }

    @Test
    public void complicateAdd(){
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.ge("age",21);
        List<User> users = userMapper.selectList(queryWrapper);
        System.out.println(users);

    }

}
