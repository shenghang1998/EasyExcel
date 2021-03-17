package com.example.demo.Controller;

import com.alibaba.excel.EasyExcel;
import com.example.demo.Entity.User;
import com.example.demo.Listener.UserListener;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserListener userListener;


    @GetMapping("/download")
    public void doDownLoad(HttpServletResponse response) throws Exception {
        userService.excelExport(response);
    }


    @PostMapping("/read")
    public String doRead(MultipartFile file) throws IOException {
        System.out.println(file.getName());
        EasyExcel.read(file.getInputStream(), User.class, userListener).sheet().doRead();
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String hello(Model model){
        List<User> users = userService.getData();
        model.addAttribute("users",users);
        return "list";
    }
}
