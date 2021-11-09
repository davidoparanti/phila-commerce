package com.decagon.phila.service.serviceImplementation;

import com.decagon.phila.model.User;
import com.decagon.phila.payload.request.UpdatePasswordRequest;
import com.decagon.phila.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
//@ExtendWith(BcryptParameterResolver.class)
class UserServiceImplementationTest {


    BcryptParameterResolver bcryptParameterResolver;

    @Mock
    BCryptPasswordEncoder passwordEncoder;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImplementation userService;

    @Test
    void contextLoads() {
    }

    @Test
    void saveUserTest() {
        User user = new User("austin", "sam", "austin@gmail.com", "male", "27-11-1999",  "password");
        given(userRepository.save(user)).willAnswer(invocationOnMock -> invocationOnMock.getArgument(0));
        User savedUser = userService.saveUser(user);
        assertThat(savedUser).isNotNull();
        verify(userRepository).save(any(User.class));
    }

    @Test
    void existsByMailTest() {
        String email = "austin@gmail.com";
        new User("austin", "sam", "austin@gmail.com", "male", "27-11-1999",  "password");

        given(userRepository.existsByEmail(email)).willReturn(true);
        boolean expected = userService.existsByMail(email);
        assert(expected);
    }

    @Test
    void changeUserPasswordTest() {

        User user = new User("austin", "sam", "austin@gmail.com", "male", "27-11-1999",  "password");
        given(userRepository.save(user)).willAnswer(invocationOnMock -> invocationOnMock.getArgument(0));
        User savedUser = userService.saveUser(user);

        UpdatePasswordRequest updatePasswordRequest = new UpdatePasswordRequest();
        updatePasswordRequest.setOldPassword("password");
        updatePasswordRequest.setNewPassword("password123");
        updatePasswordRequest.setConfirmNewPassword("password123");

        boolean changedUserPassword = userService.changeUserPassword(savedUser, updatePasswordRequest);
        assertThat(changedUserPassword).isEqualTo(true);


    }

    @Test
    void passwordMismatch(){
        User user = new User("austin", "sam", "austin@gmail.com", "male", "27-11-1999",  "password");
        given(userRepository.save(user)).willAnswer(invocationOnMock -> invocationOnMock.getArgument(0));
        User savedUser = userService.saveUser(user);

        UpdatePasswordRequest updatePasswordRequest = new UpdatePasswordRequest();
        updatePasswordRequest.setOldPassword("password");
        updatePasswordRequest.setNewPassword("password123");
        updatePasswordRequest.setConfirmNewPassword("123password");

        boolean changedUserPassword = userService.changeUserPassword(savedUser, updatePasswordRequest);
        assertThat(changedUserPassword).isEqualTo(false);

    }



}