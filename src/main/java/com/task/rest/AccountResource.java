package com.task.rest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.task.model.User;
import com.task.rest.vm.EmailVM;
import com.task.rest.vm.ManagedUserVM;
import com.task.rest.vm.NewPasswordVM;
import com.task.service.UserService;
import com.task.service.dto.PasswordChangeDTO;
import com.task.service.dto.UserDTO;

@RestController
@RequestMapping("/api")
public class AccountResource {
	   
	private static class AccountResourceException extends RuntimeException {
		private AccountResourceException(String message) {
			super(message);
	    }
	}

	
    private final UserService userService;
	
	
	public AccountResource( UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/authenticate")
	public String isAuthenticated(HttpServletRequest request) {
		return request.getRemoteUser();
	}
	

	@PostMapping("/register")
    public void registerAccount(@Valid @RequestBody ManagedUserVM managedUserVM) {
        userService.registerUser(managedUserVM, managedUserVM.getPassword());
        //mailService.sendActivationEmail(user);
    }
	
	@GetMapping("/account")
	public UserDTO getAccount() {
		return userService.getUserWithAuthorities()
				.map(UserDTO::new)
				.orElseThrow(() -> new AccountResourceException("User could not be found"));
	}
	
	@PostMapping(path = "/account/reset-password/init")
    public String requestPasswordReset(@RequestBody EmailVM emailVM) throws Exception {
	    User user = userService.requestPasswordReset(emailVM.getEmail());
	    String response = "http://localhost:8080/reset-password?token=" + user.getResetKey();
	    return response;
    }
	
	@PostMapping(path = "/account/reset-password/finish")
    public void finishPasswordReset(@RequestParam("token")String token, @RequestBody NewPasswordVM password) throws Exception {
	    userService.completePasswordReset(password.getNewPassword(), token);
    }
	
	@PostMapping("/account/change-password")
	public void changePassword(@RequestBody PasswordChangeDTO passwordChangeDTO) {
		userService.changePassword(passwordChangeDTO.getCurrentPassword(), passwordChangeDTO.getNewPassword());
	}
	
	
}