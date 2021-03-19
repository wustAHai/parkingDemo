package com.hai.task;

import org.junit.Test;

import java.util.Scanner;
import java.util.Timer;

import static org.junit.Assert.*;

/**
 * Created by chenz at 16:02 on 2021/3/19
 */
public class UpdateTaskTest {

    @Test
    public void update(){
        Timer timer = new Timer();
        UpdateTask updateTask = new UpdateTask();
        timer.schedule(updateTask,0,10000);
        Scanner scanner = new Scanner(System.in);
    }
}