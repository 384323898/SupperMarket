package aop;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import pojo.User;
import service.user.UserService;
import service.user.UserServiceImpl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyAspect {
    @Resource
    UserService userService;
    private Logger logger = Logger.getLogger(MyAspect.class);


    public void adduserafter(JoinPoint jion){
        Object[] args = jion.getArgs();
        User user=(User)args[0];
        Date date = new Date();
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        String format = dataFormat.format(date);
        User userById = userService.getUserById(user.getCreatedBy());
        logger.info(format+",用户"+user.getUserName()+"由"+userById.getUserName()+"添加成功");
    }
    public void loginuserafter(JoinPoint jion){
        Object[] args = jion.getArgs();
        HttpSession session =(HttpSession)args[3];
        User user = (User) session.getAttribute("user");
        Date date = new Date();
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        String format = dataFormat.format(date);
        logger.info(format+"用户"+user.getUserName()+"登录成功");
    }

}
