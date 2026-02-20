package main.com.myApp.controller;

import main.com.myApp.model.UserModel;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class HomeController
{

    @RequestMapping("/")
    public String showHomePage(Model model)
    {
        UserModel userModel=new UserModel();
        model.addAttribute("userModel",userModel);
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("userModel") UserModel userModel , BindingResult bindingResult, Model model)
    {
        if (bindingResult.hasErrors()) return "formPage";
        model.addAttribute("userModelRes" , userModel);

        return "resultPage";
    }

    @InitBinder
    public void initBinder(WebDataBinder DataBinder){
        StringTrimmerEditor stringTrimmerEditor=new StringTrimmerEditor(true);
        DataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }
}


