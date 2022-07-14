package service.provider;


import org.apache.ibatis.annotations.Param;
import pojo.Provider;

import java.util.List;

public interface ProviderService {
    public Provider getProviderById(int id);
    public int getProviderCount(String proCode,String proName);
    public List<Provider> getProviderListByPage(String proCode,String proName,
                                                int currentPageNo,int pageSize);

    public boolean modify(Provider provider);

    public boolean deleteProviderById(int proid);

    public boolean addprovider(Provider provider);
}
