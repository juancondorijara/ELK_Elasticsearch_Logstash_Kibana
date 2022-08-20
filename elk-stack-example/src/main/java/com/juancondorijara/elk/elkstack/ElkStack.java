package com.juancondorijara.elk.elkstack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.juancondorijara.elk.model.User;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class ElkStack {

	Logger logger=LoggerFactory.getLogger(ElkStack.class);

    @GetMapping("/getUser/{id}")
    public User getUserById(@PathVariable int id) {
		List<User> users = getUsers();
		User user = users.stream().filter(u->u.getId() == id).findAny().orElse(null);
		if (user != null) {
			logger.info("Usuario Encontrado : {}",user);
			return user;
		} else {
			try {
				throw new Exception();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("Usuario NO Encontrado con ID : {}",id);
			}
			return new User();
		}
    }

    private List<User> getUsers() {
        return Stream.of(
        		new User(1, "Juan Gabriel", "Condori Jara", "940460321"),
				new User(2, "Maria Daniela", "Díaz Romero", "938954678"),
				new User(3, "Josue Miguel", "Alarcon Asto", "945763267"),
				new User(4, "Lucia Dayana", "Cuzcano Cuya", "945768902"),
				new User(5, "Diego Alvaro", "Galvez Quispe", "902354213"),
				new User(6, "Sofia Carmen", "Huamán Vásquez", "956734534"),
				new User(7, "Victor Raúl", "Quispe Manturano", "934657856"),
				new User(8, "Brayan Enrique", "Vicente Manrique", "903456324"),
				new User(9, "Kevin Rodrigo", "Guerra Cáceres", "967856456"),
				new User(10, "Carlos Danilo", "Flores Quispe", "945678342"))
				.collect(Collectors.toList());
    }
}
