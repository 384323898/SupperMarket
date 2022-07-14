package dao.provider;


import org.apache.ibatis.annotations.Param;
import pojo.Provider;
import pojo.User;

import java.util.List;

public interface ProviderMapper {
    public Provider getProviderById(int id);
    public int getProviderCount(@Param("proCode")String proCode,
                                @Param("proName")String proName);
    public List<Provider> getProviderListByPage(@Param("proCode")String proCode,
                                                @Param("proName")String proName,
                                                @Param("currentPageNo")Integer currentPageNo,
                                                @Param("pageSize")Integer pageSize);
    public int promodify(Provider provider);

    public int deleteProviderById(int proid);

    public int addprovider(Provider provider);
}
