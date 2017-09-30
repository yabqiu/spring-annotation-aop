package cc.unmi.service;

import cc.unmi.aspects.LogStartTime;
import cc.unmi.aspects.MethodStartAspect;

import javax.inject.Named;

@Named
public class UserService {

    @LogStartTime("Hello World")
    public String fetchUserById(int userId) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("start time: " + MethodStartAspect.getStartTime() + ", execution time: " +
            (System.currentTimeMillis() - MethodStartAspect.getStartTime()));

        return "nameOf" + userId;
    }
}
