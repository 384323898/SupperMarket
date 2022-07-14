package service.provider;

import dao.provider.ProviderMapper;
import dao.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Provider;
import pojo.User;

import javax.annotation.Resource;
import java.util.List;

@Service("proService")
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    ProviderMapper providerMapper;

    public ProviderMapper getProviderMapper() {
        return providerMapper;
    }

    public void setProviderMapper(ProviderMapper providerMapper) {
        this.providerMapper = providerMapper;
    }

    public Provider getProviderById(int id) {

        try {
            return providerMapper.getProviderById(id);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public int getProviderCount(String proCode, String proName) {
        try {
            return providerMapper.getProviderCount(proCode,proName);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Provider> getProviderListByPage(String proCode, String proName, int currentPageNo, int pageSize) {
        List<Provider> providerList = null;

        try {
            providerList = providerMapper.getProviderListByPage(proCode, proName, currentPageNo, pageSize);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return providerList;
    }

    public boolean modify(Provider provider) {
        boolean result=false;
        try {
            int count =providerMapper.promodify(provider);
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

    public boolean deleteProviderById(int proid) {
        boolean result=false;
        try {
            int count =providerMapper.deleteProviderById(proid);
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

    public boolean addprovider(Provider provider) {
        boolean result=false;
        try {
            int count =providerMapper.addprovider(provider);
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
}
