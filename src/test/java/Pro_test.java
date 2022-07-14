import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Provider;
import pojo.User;
import service.provider.ProviderService;
import service.provider.ProviderServiceImpl;
import service.user.UserService;
import service.user.UserServiceImpl;

import java.util.List;


public class Pro_test {
    private Logger logger = Logger.getLogger(Pro_test.class);
    @Test
    public void getProvider(){
        ApplicationContext app = new ClassPathXmlApplicationContext("spring-config.xml");
        ProviderService providerService= app.getBean("proService", ProviderServiceImpl.class);
        Provider provider;
        int proId=2;
        provider=providerService.getProviderById(proId);
        System.out.println(provider.toString());
    }
    @Test
    public void getProviderlist(){
        ApplicationContext app = new ClassPathXmlApplicationContext("spring-config.xml");
        ProviderService providerService= app.getBean("proService", ProviderServiceImpl.class);
        List<Provider> list=null;
        list = providerService.getProviderListByPage(null,null,0,5);
        for(Provider p:list){
            System.out.println(p.toString());
        }

    }
    @Test
    public void modifyProviderlist(){
        ApplicationContext app = new ClassPathXmlApplicationContext("spring-config.xml");
        ProviderService providerService= app.getBean("proService", ProviderServiceImpl.class);
        Provider provider=new Provider();
        provider.setId(new Integer(2));
        provider.setProPhone("1221213131313");
        boolean modify = providerService.modify(provider);
        Provider providerById = providerService.getProviderById(2);
        System.out.println(providerById);


    }


}
