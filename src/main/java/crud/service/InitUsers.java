package crud.service;

import crud.entity.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitUsers  {
    private UserService userService;

    public InitUsers(UserService userService) {
        this.userService = userService;
    }
    @PostConstruct
    public void init() {
        userService.create(new User(null, "Tom", "Holland", "tom@holland"));
        userService.create(new User(null, "John", "Smith", "john@smith"));
        userService.create(new User(null, "Mike", "Scott", "mike@scott"));
        userService.create(new User(null, "Shwartc", "Negr", "shwartc@negr"));
    }
}
