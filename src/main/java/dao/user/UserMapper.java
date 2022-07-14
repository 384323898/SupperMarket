package dao.user;


import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;

public interface UserMapper {
public User getUserByUserCode(String userCode);
public int getUserCount(@Param("userName")String userName, @Param("userRole")Integer userRole);
public List<User> getUserListByPage(@Param("userName")String userName,
                                        @Param("userRole")Integer userRole,
                                        @Param("currentPageNo")Integer currentPageNo,
                                        @Param("pageSize")Integer pageSize);
    public int add(User user) throws Exception;
    public User getUserById(int id)throws Exception;

    //修改用户信息
    public int modify(User user)throws Exception;
    //删除用户
    public int deleteUserById(int id) throws Exception;
}
