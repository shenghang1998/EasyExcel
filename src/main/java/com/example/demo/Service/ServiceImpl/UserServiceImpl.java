package com.example.demo.Service.ServiceImpl;

import com.alibaba.excel.EasyExcel;
import com.example.demo.Entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.Service.UserService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 导出表格
     * @throws IOException
     */
    @Override
    public void excelExport(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("导出文件", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), User.class).sheet("模板").doWrite(getData());
    }

    /**
     * 新增表格数据
     * */
    @Override
    public void addUser(User user){
        userMapper.addUser(user);
    }

    /**
    * 获取数据库数据
    */
    public List<User> getData(){
        List<User> users = Lists.newArrayList();
        users = userMapper.getAllUsers();
        return users;
    }
}
