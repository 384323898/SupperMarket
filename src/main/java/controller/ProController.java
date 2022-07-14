package controller;

import com.alibaba.fastjson.JSONArray;
import com.sun.deploy.nativesandbox.comm.Request;
import com.sun.deploy.net.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Provider;
import pojo.User;
import service.provider.ProviderService;
import service.provider.ProviderServiceImpl;
import service.user.UserService;
import tools.PageSupport;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class ProController {
    @Resource
    private ProviderService providerService;

    @RequestMapping("/providerList")
    public String proList(Model model, HttpSession session,
                          @RequestParam(value="queryProviderCode",required=false) String queryProviderCode,
                          @RequestParam(value="queryProviderName",required=false) String queryProviderName,
                          @RequestParam(value="pageIndex",required=false) String pageIndex) throws Exception{

        if(session.getAttribute("user") == null){ //如果用户没有登录就直接来到userlist就回到syserror
            return "redirect:/syserror";
        }
        List<Provider> proList = null;
        int pageSize = 5;
        int currentPageNo = 1;
        if(queryProviderCode == null){
            queryProviderCode = "";
        }
        if(queryProviderName == null){
            queryProviderName = "";
        }
        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch(NumberFormatException e){
                return "redirect:/syserror";
            }
        }
        int totalCount=providerService.getProviderCount(queryProviderCode,queryProviderName);
        PageSupport pages=new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        int totalPageCount = pages.getTotalPageCount();
        int start = ((currentPageNo-1) * pageSize);
        if(currentPageNo < 1){
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }
        proList=providerService.getProviderListByPage(queryProviderCode,queryProviderName,start,pageSize);
        model.addAttribute("providerList", proList);
        model.addAttribute("queryProviderCode", queryProviderCode);
        model.addAttribute("queryProviderName", queryProviderName);
        model.addAttribute("totalPageCount", totalPageCount);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currentPageNo", currentPageNo);
        return "providerlist";
    }

    @RequestMapping(value="/providerview")
    public String  providerview(@RequestParam int pid,Model model){
        Provider pro = providerService.getProviderById(pid);
        model.addAttribute("pro",pro);
        return "providerview";

    }
    @RequestMapping("/providermodify")
    public String providermodify(@RequestParam int pid,Model model){
        Provider pro = providerService.getProviderById(pid);
        model.addAttribute("pro",pro);
        return "providermodify";
    }
    @RequestMapping(value ="/providermodifysave",method = RequestMethod.POST)
    public String providermodifysave(HttpServletRequest req, HttpSession session){
        Provider provider = new Provider();

        int id = Integer.parseInt(req.getParameter("id"));
        String proCode = req.getParameter("proCode");
        String proName = req.getParameter("proName");
        String proDesc =req.getParameter("proDesc");
        String proContact = req.getParameter("proContact");
        String proPhone =   req.getParameter("proPhone");
        String proAddress =  req.getParameter("proAddress");
        String proFax =  req.getParameter("proFax");
        Integer createdBy = Integer.valueOf(req.getParameter("createdBy"));
        Date creationDate = new Date(req.getParameter("creationDate"));
        User user = (User) session.getAttribute("user");
        Integer modifyBy =user.getId();
        provider.setId(id);
        provider.setProCode(proCode);
        provider.setProName(proName);
        provider.setProDesc(proDesc);
        provider.setProContact(proContact);
        provider.setProPhone(proPhone);
        provider.setProAddress(proAddress);
        provider.setProFax(proFax);
        provider.setCreatedBy(createdBy);
        provider.setCreationDate(creationDate);
        provider.setModifyDate(new Date());
        provider.setModifyBy(modifyBy);
        if(providerService.modify(provider)){
            return "redirect:/providerList";
        }
        return "providermodify";
    }
    @RequestMapping(value="/delprovider")
    @ResponseBody
    public Object delprovider(@RequestParam int proid){
        String data="{\"delResult\":\"false\"}";  //初始化字符串
        boolean result= providerService.deleteProviderById(proid);
        if(result==true)
            data="{\"delResult\":\"true\"}"; //删除成功
        else
            data="{\"delResult\":\"false\"}"; //删除失败
        return JSONArray.toJSONString(data);//将data转为json对象,并将结果发回给当前页面
    }
    @RequestMapping(value="/provideradd")
    public String  provideradd(){
        return "provideradd";
    }
    @RequestMapping(value="/provideraddsave",method = RequestMethod.POST)
    public String  provideraddsave(HttpServletRequest req, HttpSession session){
        Provider provider = new Provider();
        String proCode = req.getParameter("proCode");
        String proName = req.getParameter("proName");
        String proDesc =req.getParameter("proDesc");
        String proContact = req.getParameter("proContact");
        String proPhone =   req.getParameter("proPhone");
        String proAddress =  req.getParameter("proAddress");
        String proFax =  req.getParameter("proFax");
        User user = (User) session.getAttribute("user");
        Integer createdBy =user.getId();
        Date creationDate = new Date();
        provider.setProCode(proCode);
        provider.setProName(proName);
        provider.setProDesc(proDesc);
        provider.setProContact(proContact);
        provider.setProPhone(proPhone);
        provider.setProAddress(proAddress);
        provider.setProFax(proFax);
        provider.setCreatedBy(createdBy);
        provider.setCreationDate(creationDate);
        System.out.println(provider.toString());
        if(providerService.addprovider(provider)){
            return "redirect:/providerList";
        }
         return "provideradd";
    }

}
