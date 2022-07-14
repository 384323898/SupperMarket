import javafx.scene.input.DataFormat;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.User;
import service.user.UserService;
import service.user.UserServiceImpl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserTest {
    private Logger logger = Logger.getLogger(UserTest.class);
    @Test
    public  void getId(){
        ApplicationContext app = new ClassPathXmlApplicationContext("spring-config.xml");
        UserService userService = app.getBean("userService", UserServiceImpl.class);
        User user;
        String userCode="liming";
        user=userService.getUserByUserCode(userCode);
        logger.debug("用户帐号: " + user.getUserCode() +
                "用户密码: "+user.getUserPassword()+
                "用户名:"+ user.getUserName() +
                "用户地址:"+user.getAddress());

    }
    @Test
    public void testGetUserCount() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "spring-config.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        int count=0;
        String userName="";
        int userRole=0;
        count = userService.getUserCount(userName,userRole);
        logger.debug("共有"+count+"条记录");
    }
    @Test
    public void testGetUserListByPage() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "spring-config.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        int count = 0;
        String userName = null;
        int userRole = 0;
        int currentPageNo = 0;
        int pageSize = 5;
        List<User> userList = userService.getUserListByPage(userName, userRole, currentPageNo, pageSize);
        logger.debug("当前记录从"+currentPageNo+1+"开始");
        logger.debug("共显示"+pageSize+"条记录");
        for (User user : userList) {
            logger.debug("ID:" + user.getId() +
                    " 用户帐号：" + user.getUserCode() +
                    " 用户姓名:" + user.getUserName() +
                    " 用户角色:" + user.getRole().getRoleName() +
                    " 地址:" + user.getAddress());
        }
    }
    @Test
    public void testa() {
        Date date = new Date();
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        String format = dataFormat.format(date);
        System.out.println(format);
    }


}
