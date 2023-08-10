package org.technosoft.businesscard.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.technosoft.businesscard.model.Employee;
import org.technosoft.businesscard.model.PlaceOfWork;
import org.technosoft.businesscard.service.EmployeeService;

@Controller
@RequiredArgsConstructor
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

    @GetMapping("/admin/add_place")
    public String testEditing(Model model) {
        model.addAttribute("placeOfWork", new PlaceOfWork());
        return "add_place";
    }

    @PostMapping("/admin/add_place")
    public String addNewPlaceOfWork(@ModelAttribute("placeOfWork") PlaceOfWork placeOfWork) {
        employeeService.createNewPlaceOfWork(placeOfWork);
        return "redirect:/home";
    }

    @GetMapping("/admin/edit_owner")
    public String editOwner(Model model) {
        model.addAttribute("owner", new Employee());
        return "edit_owner";
    }

//    @PostMapping("/admin/edit_owner")
//    public String editOwner(@ModelAttribute("owner") Employee employee) {
//        employeeService.editEmployee(employee);
//        return "redirect:/home";
//    }

    @PostMapping("/admin/edit_owner")
    public String editOwner(@RequestParam("phone") String phone,
                            @RequestParam("email") String email,
                            @RequestParam("auto") String auto,
                            @RequestParam("skills") String skills,
                            @RequestParam("additionalInformation") String additionalInformation,
                            @RequestParam("hobby") String hobby) {
        var editedEmployee = employeeService.getEmployeeById(employeeId);
        editedEmployee.setPhone(phone);
        editedEmployee.setEmail(email);
        editedEmployee.setAuto(auto);
        editedEmployee.setSkills(skills);
        editedEmployee.setAdditionalInformation(additionalInformation);
        editedEmployee.setHobby(hobby);
        employeeService.editEmployee(editedEmployee);
        return "redirect:/home";
    }
}