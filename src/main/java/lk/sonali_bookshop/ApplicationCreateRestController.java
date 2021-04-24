package lk.sonali_bookshop;


import lk.sonali_bookshop.asset.common_asset.model.enums.CivilStatus;
import lk.sonali_bookshop.asset.common_asset.model.enums.Gender;
import lk.sonali_bookshop.asset.common_asset.model.enums.Title;
import lk.sonali_bookshop.asset.employee.entity.Employee;
import lk.sonali_bookshop.asset.employee.entity.enums.Designation;
import lk.sonali_bookshop.asset.employee.entity.enums.EmployeeStatus;
import lk.sonali_bookshop.asset.employee.service.EmployeeService;
import lk.sonali_bookshop.asset.user_management.role.entity.Role;
import lk.sonali_bookshop.asset.user_management.role.service.RoleService;
import lk.sonali_bookshop.asset.user_management.user.entity.User;
import lk.sonali_bookshop.asset.user_management.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.stream.Collectors;

@RestController
public class ApplicationCreateRestController {
    private final RoleService roleService;
    private final UserService userService;
    private final EmployeeService employeeService;


    @Autowired
    public ApplicationCreateRestController(RoleService roleService, UserService userService,
                                           EmployeeService employeeService) {
        this.roleService = roleService;
        this.userService = userService;
        this.employeeService = employeeService;
    }

    @GetMapping("/select/user") //http request go to the back end
    public String saveUser() {
        //roles list start
        String[] roles = {"ADMIN","PROCUREMENT_MANAGER","CASHIER","MANAGER","HR_MANAGER","ACCOUNT_MANAGER"};//if you want to change role
        for (String s : roles) {
            Role role = new Role();
            role.setRoleName(s);
            roleService.persist(role);// link to RoleService.java(user_management-role-service)
        }//role save

//Employee ( new employee make, not dependent)
        Employee employee = new Employee();
        employee.setCode("11111111");
        employee.setName("Admin User");
        employee.setCallingName("Admin");
        employee.setName("908670000V");
        employee.setMobileOne("0750000000");
        employee.setTitle(Title.MR);
        employee.setGender(Gender.MALE);
        employee.setDesignation(Designation.ADMIN);
        employee.setCivilStatus(CivilStatus.UNMARRIED);
        employee.setEmployeeStatus(EmployeeStatus.WORKING);
        employee.setDateOfBirth(LocalDate.now().minusYears(18));
        employee.setDateOfAssignment(LocalDate.now());
        Employee employeeDb = employeeService.persist(employee); //new employee save


        //admin user one //create new user empty object
        User user = new User();
        user.setEmployee(employeeDb);
        user.setUsername("admin");
        user.setPassword("admin");
        String message = "Username:- " + user.getUsername() + "\n Password:- " + user.getPassword();
        user.setEnabled(true);
        user.setRoles(roleService.findAll()
                .stream()
                .filter(role -> role.getRoleName().equals("ADMIN"))
                .collect(Collectors.toList()));
        userService.persist(user);

        return message;
    }


}
//ApplicationCreateController-SelectUSer function call and system user name and password how to take
//According to ER we put dependencies 1.role 2.employee
/*Procurement manager(purchasing manager) analyze costs, negotiate contract details, and offer strategies and solutions to help
companies better manage costs on supplies and vendor services. Additional duties include managing inventory, tracking orders,
resolving issues concerning price disputes, and making bids for a vendor's services.
 */