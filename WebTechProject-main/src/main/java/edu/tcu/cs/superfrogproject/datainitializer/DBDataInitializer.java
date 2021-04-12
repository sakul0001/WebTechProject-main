package edu.tcu.cs.superfrogproject.datainitializer;

import edu.tcu.cs.superfrogproject.domain.User;
import edu.tcu.cs.superfrogproject.service.ProductService;
import edu.tcu.cs.superfrogproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBDataInitializer implements CommandLineRunner {
    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }
    private void loadData() {

        // create some users
        User u1 = new User();
        u1.setUsername("Kate");
        u1.setPassword("123456");
        u1.setEnabled(true);
        u1.setRoles("superfrog");
        u1.setFirstname("Kate");
        u1.setLastname("Brayshaw");

        User u2 = new User();
        u2.setUsername("Damon");
        u2.setPassword("654321");
        u2.setEnabled(true);
        u2.setRoles("person");

        User u3 = new User();
        u3.setUsername("anh");
        u3.setPassword("holahola");
        u3.setEnabled(true);
        u3.setRoles("person");
        u3.setFirstname("Anh");
        u3.setLastname("Nguyen");

        User u4 = new User();
        u4.setUsername("Maria");
        u4.setPassword("holahola");
        u4.setEnabled(true);
        u4.setRoles("director");
        u4.setFirstname("Maria");
        u4.setLastname("Amoros");

        userService.save(u1);
        userService.save(u2);
        userService.save(u3);
        userService.save(u4);


    }
}
