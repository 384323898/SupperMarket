package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CountController {

    @RequestMapping("/getIDName")
    public String getIDName(){
        return "getidname";
    }


    @RequestMapping("/searchIdName")
    public String dosearch(@RequestParam String id ,@RequestParam String name,Model model){
        model.addAttribute("id",id);
        model.addAttribute("name",name);
        return "searchIdName";
    }

}
