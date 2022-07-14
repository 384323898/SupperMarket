package service.role;

import dao.role.RoleMapper;
import org.springframework.stereotype.Service;
import pojo.Role;

import javax.annotation.Resource;
import java.util.List;
@Service("roleService")
public class RoleServiceImpl implements RoleService {


    @Resource
     private RoleMapper roleMapper;
    public RoleMapper getRoleMapper() {
        return roleMapper;
    }

    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public List<Role> getRoleList() {
        List<Role> roleList=null;
        try {
            roleList = roleMapper.getRoleList();
        }
        catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
        return roleList;
    }
}
