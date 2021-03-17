package com.example.demo.Listener;

import java.util.List;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 1、注意监听器不能由spring容器管理，每次调用时都需要手动new
 * 2、监听器内部需要使用ioc中的bean时，可以通过构造方法传入
 *
 * @author guilin
 *
 */

@Service
public class UserListener extends AnalysisEventListener<User>{

    private List<User> data = Lists.newArrayList();

    private static final Logger LOGGER = LoggerFactory.getLogger(UserListener.class);

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     *    解析每条数据时都会调用
     */
    @Override
    public void invoke(User user, AnalysisContext context) {
        System.out.println("解析到一条数据："+user);
        System.out.println(userService);
        userService.addUser(user);
    }


    /**
     *    所有数据解析完之后调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 可以在此处执行业务操作
        // 本例就打印到控制台即可，表示读取完成
        System.out.println("解析数据完毕");
    }
}
