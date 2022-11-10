package org.example.servise;

import org.example.entity.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AuthenticationService {
    private static AuthenticationService authenticationService;
    @Autowired
    private UserRepository userRepository;

    private AuthenticationService() {
        userRepository = UserRepository.getInstance();
    }

    public static synchronized AuthenticationService getInstance() {
        if (authenticationService == null) {
            authenticationService = new AuthenticationService();
        }
        return authenticationService;
    }

    public static HashMap<String, String> userTokens = new HashMap<>();


    public void createUser(String name, String email, String password) {
        if (userRepository.checkIfEmailExists(email)) {
            throw new IllegalArgumentException("the user has already registered");
        }
        User user = new User(name, email, password);
        userRepository.createUser(user);
    }

    public String logIn(String email, String password) {
        String id = userRepository.getIdByEmail(email);
        String token = createToken();
        userTokens.put(token, id);
        return token;
    }

    public boolean authUser(String token) {
        if (userTokens.get(token) != null) {
            return true;
        }
//        for (HashMap.Entry<String, String> entry : userTokens.entrySet()) {
//            if (entry.getKey().equals(id)) {
//                return entry.getValue().equals(token);
//            }
//        }
        return false;
    }

    public String getId(String token) {
        return userTokens.get(token);
    }

    public void deleteUserFromMap(String id) {
        userTokens.remove(id);
    }

    private static String getSaltString(int stringLength) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        while (salt.length() < stringLength) {
            int index = (int) (ThreadLocalRandom.current().nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }

        return salt.toString();

    }

    public boolean checkIfEmailExists(String email) {
        return userRepository.checkIfEmailExists(email);
    }

    public boolean checkIfUserExists(String email, String password) {
        return userRepository.checkIfUserExists(email, password);
    }

    public static String createToken() {
        return getSaltString(18);
    }

}
