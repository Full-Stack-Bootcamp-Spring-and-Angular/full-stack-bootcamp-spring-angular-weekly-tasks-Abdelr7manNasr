package main.com.myApp.controller;

import main.dao.DatabaseOperations;
import main.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDate;

@Controller
public class HomeController
{
    @Autowired
    private DatabaseOperations db;
    @RequestMapping("/")
    public String showHomePage()
    {
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm( @RequestParam String firstName, @RequestParam String lastName,
                               @RequestParam String email, @RequestParam String dateOfBirth,
                               @RequestParam String city, Model model)
    {

        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        model.addAttribute("email", email);
        model.addAttribute("dateOfBirth", dateOfBirth);
        model.addAttribute("city", city);

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setCity(city);
        user.setDateOfBirth(Date.valueOf(dateOfBirth));
        db.saveUser(user);
        return "resultPage";
    }
}


