package com.vijay.learn.sbsecurity.bootstrap;
/*
Project : springboot-security-webapp
User    : Vijay Gupta
Date    : May 2020
*/

import com.vijay.learn.sbsecurity.domain.Product;
import com.vijay.learn.sbsecurity.domain.Role;
import com.vijay.learn.sbsecurity.domain.User;
import com.vijay.learn.sbsecurity.repositories.ProductRepository;
import com.vijay.learn.sbsecurity.services.RoleService;
import com.vijay.learn.sbsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class SpringJpaBootstrap implements CommandLineRunner {
    private ProductRepository productRepository;
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadProducts();
        loadUsers();
        loadRoles();
        assignUsersToUserRole();
        assignUsersToAdminRole();
    }

    private void loadProducts() {
        Product mobile = new Product();
        mobile.setDescription("Mobile Phone");
        mobile.setPrice(new BigDecimal("3589"));
        mobile.setImageUrl("/images/mobile_phone.png");
        mobile.setProductId("235268845711068308");
        productRepository.save(mobile);
        System.out.println("Saved mobile - id: " + mobile.getId());

        Product headPhone = new Product();
        headPhone.setDescription("HeadPhone");
        headPhone.setImageUrl("/images/head_phone.png");
        headPhone.setProductId("168639393495335947");
        headPhone.setPrice(new BigDecimal("11.95"));
        productRepository.save(headPhone);
        System.out.println("Saved headPhone - id:" + headPhone.getId());
    }

    private void loadUsers() {
        User user1 = new User();
        user1.setUsername("user");
        user1.setPassword("user");
        userService.saveOrUpdate(user1);
        System.out.println("Saved User1 " + user1.getUsername());

        User user2 = new User();
        user2.setUsername("admin");
        user2.setPassword("admin");
        userService.saveOrUpdate(user2);
        System.out.println("Saved User2 " + user2.getUsername());
    }

    private void loadRoles() {
        Role role = new Role();
        role.setRole("USER");
        roleService.saveOrUpdate(role);
        System.out.println("Saved role " + role.getRole());

        Role adminRole = new Role();
        adminRole.setRole("ADMIN");
        roleService.saveOrUpdate(adminRole);
        System.out.println("Saved role " + adminRole.getRole());
    }

    private void assignUsersToUserRole() {
        List<Role> roles = (List<Role>) roleService.listAll();
        List<User> users = (List<User>) userService.listAll();
        roles.forEach(role -> {
            if (role.getRole().equalsIgnoreCase("USER")) {
                users.forEach(user -> {
                    if (user.getUsername().equals("user")) {
                        user.addRole(role);
                        userService.saveOrUpdate(user);
                    }
                });
            }
        });
    }

    private void assignUsersToAdminRole() {
        List<Role> roles = (List<Role>) roleService.listAll();
        List<User> users = (List<User>) userService.listAll();
        roles.forEach(role -> {
            if (role.getRole().equalsIgnoreCase("ADMIN")) {
                users.forEach(user -> {
                    if (user.getUsername().equals("admin")) {
                        user.addRole(role);
                        userService.saveOrUpdate(user);
                    }
                });
            }
        });
    }


}
