package main.com.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
public class HomeController
{

    @RequestMapping("/")
    public String showHomePage()
    {
        return "formPage";
    }

    @RequestMapping("/processForm")
    public String processForm(@RequestParam int year, @RequestParam int month, @RequestParam int day, Model model)
    {
        int currYear = LocalDate.now().getYear();
        int currMonth = LocalDate.now().getMonthValue();
        int currDay = LocalDate.now().getDayOfMonth();

        int yearAge = currYear - year;
        int monthAge = currMonth - month;
        int dayAge = currDay - day;

        if (dayAge < 0) {
            monthAge--;
            LocalDate prevMonth = LocalDate.now().minusMonths(1);
            dayAge += prevMonth.lengthOfMonth();
        }

        if (monthAge < 0) {
            yearAge--;
            monthAge += 12;
        }

        int age = 5;
        model.addAttribute("yearAge" , yearAge);
        model.addAttribute("monthAge" , monthAge);
        model.addAttribute("dayAge" , dayAge);

        return "resultPage";
    }
}


