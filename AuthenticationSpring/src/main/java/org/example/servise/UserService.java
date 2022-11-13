package org.example.servise;

import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void updateEmail(String id, String email) {
        userRepository.updateEmail(id, email);
    }

    public void updatePassword(String id, String password) {
        userRepository.updatePassword(id, password);
    }

    public void updateUserName(String id, String username) {

        userRepository.updateName(id, username);
    }

    public void deleteUser(String id) {
        userRepository.deleteUser(id);
    }

    public boolean checkIfEmailExists(String email) {
        return userRepository.checkIfEmailExists(email);
    }
}