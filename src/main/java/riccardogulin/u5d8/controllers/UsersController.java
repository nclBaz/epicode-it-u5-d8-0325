package riccardogulin.u5d8.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import riccardogulin.u5d8.entities.User;
import riccardogulin.u5d8.payload.NewUserPayload;
import riccardogulin.u5d8.services.UsersService;

import java.util.List;
import java.util.UUID;

/*

1. GET http://localhost:3001/users
2. POST http://localhost:3001/users (+ request body)
3. GET http://localhost:3001/users/{userId}
4. PUT http://localhost:3001/users/{userId} (+ request body)
5. DELETE  http://localhost:3001/users/{userId}

*/

@RestController
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersService usersService;

	// 1. GET http://localhost:3001/users
	@GetMapping
	public List<User> findAll() {
		return this.usersService.findAll();
	}

	// 2. POST http://localhost:3001/users (+ request body)
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody NewUserPayload payload) {
		return this.usersService.save(payload);
	}

	// 3. GET http://localhost:3001/users/{userId}
	@GetMapping("/{userId}")
	public User findById(@PathVariable UUID userId) {
		return this.usersService.findById(userId);
	}


	// 4. PUT http://localhost:3001/users/{userId} (+ request body)
	@PutMapping("/{userId}")
	public User findByIdAndUpdate(@PathVariable UUID userId, @RequestBody NewUserPayload payload) {
		return this.usersService.findByIdAndUpdate(userId, payload);
	}

	// 5. DELETE  http://localhost:3001/users/{userId}
	@DeleteMapping("/{userId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void findByIdAndDelete(@PathVariable UUID userId) {
		this.usersService.findByIdAndDelete(userId);
	}
}
