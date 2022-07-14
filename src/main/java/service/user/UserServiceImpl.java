package service.user;

import dao.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pojo.User;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService{
    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

         @Autowired
        private UserMapper userMapper;

        public User getUserByUserCode(String userCode) {
            try {
                return userMapper.getUserByUserCode(userCode);
            } catch (RuntimeException e) {
                e.printStackTrace();
                throw e;
            }
        }

    public int getUserCount(String queryUserName, int queryUserRole) {

        int count = 0;
        try {
            count=userMapper.getUserCount(queryUserName,queryUserRole);
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return count;

    }

    public List<User> getUserListByPage(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
        List<User> userList = null;

        try {
            userList=userMapper.getUserListByPage(queryUserName,queryUserRole,currentPageNo,pageSize);
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return userList;
    }

    public boolean add(User user) {
            boolean result =false;
        try {
            int count=userMapper.add(user);
            if (count>0){
                return  true;
            }else {
                return  false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public User getUserById(int id) {
        // TODO Auto-generated method stub
        User user=null;
        try{
            user=userMapper.getUserById(id);
        }
        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            user = null;
        }
        return user;
    }


    public boolean modify(User user) {
        boolean result=false;
        try {
            int count=userMapper.modify(user);
            if(count>0)  //如果添加成功就返回true
                return true;
            else
                return false;//如果添加失败就返回true
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    public User selectUserCodeExist(String userCode) {
        User user = null;
        try {
            user = userMapper.getUserByUserCode(userCode);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return user;
    }

    public boolean deleteUserById(int id) {
        Boolean result = false;
        try {
            if(userMapper.deleteUserById(id) > 0)
                result = true; //删除成功
            else
                result=false;  //删除失败
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
