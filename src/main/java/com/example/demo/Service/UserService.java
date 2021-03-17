package com.example.demo.Service;

import com.example.demo.Entity.User;
import org.apache.tomcat.util.buf.UEncoder;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


public interface UserService {

    void excelExport(HttpServletResponse response) throws Exception;

    void addUser(User user);

    List<User> getData();
}
