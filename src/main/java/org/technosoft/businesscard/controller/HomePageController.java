package org.technosoft.businesscard.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.technosoft.businesscard.model.PlaceOfWork;
import org.technosoft.businesscard.service.EmployeeService;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class HomePageController {

    private final EmployeeService employeeService;

    @Value("${employeeId}")
    private int employeeId;

    @GetMapping("/home")
    public String openHomepage(Model model) {
        var employee = employeeService.getEmployeeById(employeeId);
        var placeOfWork = employeeService.getAllPlacesOfWork();
        model.addAttribute("lastName", employee.getLastName());
        model.addAttribute("name", employee.getName());
        model.addAttribute("middleName", employee.getMiddleName());
        model.addAttribute("birthday", employee.getBirthday());
        model.addAttribute("phone", employee.getPhone());
        model.addAttribute("email", employee.getEmail());
        model.addAttribute("city", employee.getCity());
        model.addAttribute("specialization", employee.getSpecialization());
        model.addAttribute("gender", employee.getGender());
        model.addAttribute("education", employee.getEducation());
        model.addAttribute("languages", employee.getLanguages());
        model.addAttribute("skills", employee.getSkills());
        model.addAttribute("auto", employee.getAuto());
        model.addAttribute("additionalInformation", employee.getAdditionalInformation());
        model.addAttribute("hobby", employee.getHobby());
        model.addAttribute("placeOfWork", placeOfWork);
        return "home_page";
    }
//    , start, finish, duration, city, position, description
    @GetMapping("/admin")
    public String editHomePage() {
        return "login_page.html";
    }

    @GetMapping("/test/{id}")
    public String testEndpoint(@PathVariable Integer id, Model model) {
        var employee = employeeService.getEmployeeById(id);
        var placeOfWork = employeeService.getAllPlacesOfWork();
        model.addAttribute("city", employee.getCity());
        model.addAttribute("lastname", employee.getLastName());
        model.addAttribute("gender", employee.getGender());
        model.addAttribute("placeOfWork", placeOfWork);
        return "home_page";
    }


    @PostMapping("/edit")
    public String addNewPlaceOfWork(@ModelAttribute("placeOfWork") PlaceOfWork placeOfWork) {
        System.err.println(placeOfWork.getCity() + " " + placeOfWork.getName()
                + " " + placeOfWork.getPosition() + " " + placeOfWork.getDuration());
        employeeService.createNewPlaceOfWork(placeOfWork);
        return "redirect:/home";
    }

    @GetMapping("/edit")
    public String testEditing(Model model) {
        model.addAttribute("placeOfWork", new PlaceOfWork());
        return "edit_page";
    }
}
