package org.technosoft.businesscard.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.technosoft.businesscard.model.Employee;
import org.technosoft.businesscard.model.PlaceOfWork;
import org.technosoft.businesscard.repository.EmployeeRepository;
import org.technosoft.businesscard.repository.PlaceOfWorkRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PlaceOfWorkRepository placeOfWorkRepository;

    public List<PlaceOfWork> getAllPlacesOfWork() {
        return placeOfWorkRepository.findAll(Sort.by(Sort.Direction.DESC, "start", "finish"));
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    public void createNewPlaceOfWork(PlaceOfWork placeOfWork) {
        placeOfWorkRepository.save(placeOfWork);
    }

    public void editEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
