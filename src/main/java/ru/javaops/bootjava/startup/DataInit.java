package ru.javaops.bootjava.startup;

import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import ru.javaops.bootjava.model.Role;
import ru.javaops.bootjava.model.User;
import ru.javaops.bootjava.repository.UserRepository;

import java.util.Set;

@AllArgsConstructor
@Component
public class DataInit implements ApplicationRunner {

    private final UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User("vasya@gmail.com", "Vasya", "Pupkin", "1234", Set.of(Role.ROLE_USER));
        User user2 = new User("admin@gmail.com", "Admin", "Adminovich", "1234", Set.of(Role.ROLE_ADMIN));
        userRepository.save(user);
        userRepository.save(user2);

        System.out.println(userRepository.findAll());
    }
}
