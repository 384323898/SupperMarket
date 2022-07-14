package service.user;

import pojo.User;

import java.util.List;

public interface UserService {
    public User getUserByUserCode(String userCode);
    public int getUserCount(String queryUserName,int queryUserRole);
    public List<User> getUserListByPage (String queryUserName, int queryUserRole, int currentPageNo, int pageSize);
    public  boolean add(User user);
    public User getUserById(int id);
    public boolean modify(User user);
    public User selectUserCodeExist(String userCode);
    public boolean deleteUserById(int id);
}
