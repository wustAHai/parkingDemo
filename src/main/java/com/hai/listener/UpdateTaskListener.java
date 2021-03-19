package com.hai.listener;

import com.hai.service.ItemService;
import com.hai.task.UpdateTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.Timer;

/**
 * Created by chenz at 16:10 on 2021/3/19
 */
@Component
public class UpdateTaskListener implements ServletContextListener {


    @Autowired
    ItemService itemService;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Timer timer = new Timer();
        UpdateTask updateTask = new UpdateTask();
        updateTask.setItemService(itemService);
        timer.schedule(updateTask,0,100000);//100秒更新一次数据库
    }
}
