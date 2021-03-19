package com.hai.task;

import com.hai.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.TimerTask;

/**
 * Created by chenz at 16:01 on 2021/3/19
 */
public class UpdateTask extends TimerTask {



    private ItemService itemService;

    @Override
    public void run() {
        System.out.println("后台定时更新任务启动...");
        itemService.updateParksAndItems();
    }

    public ItemService getItemService() {
        return itemService;
    }

    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }
}
