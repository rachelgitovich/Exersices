package org.example.repository;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import org.example.entity.User;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;

@Repository
public class UserRepository {
    private final String path = "../AuthenticationSpring/src/main/java/org/example/repository/users/";
    private final Gson gson = new Gson();
    private static UserRepository userRepository;

    private UserRepository() {
    }

    public static synchronized UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    private User fetchUser(String filePath) {
        JsonReader reader = null;
        User data = null;
        Type USER_TYPE = User.class;
        try {
            reader = new JsonReader(new FileReader(filePath));
            data = gson.fromJson(reader, USER_TYPE); // contains the whole users list
            reader.close();
            if (data == null) {
                throw new RuntimeException("user not found");
            }
        } catch (IOException e) {
            throw new RuntimeException("user's file not found");
        }
        return data;
    }


    public void createUser(User user) {
        PrintWriter writer = null;
        String usersJson = gson.toJson(user);
        System.out.println(usersJson);
        try {
            File file = new File(path);
            writer = new PrintWriter(path + user.getId() + ".json", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            throw new RuntimeException("failed to create user");
        }
        writer.print(usersJson);
        writer.close();
    }


    public boolean checkIfEmailExists(String email) {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (fetchUser(file.getPath()).getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfUserExists(String email, String password) {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                User user = fetchUser(file.getPath());
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getIdByEmail(String email) {
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (File file :
                listOfFiles) {
            User user = fetchUser(file.getPath());
            if (user.getEmail().equals(email)) {
                return user.getId();
            }
        }
        throw new IllegalArgumentException("user not found");
    }

    public void updateEmail(String id, String email) {
        User user = fetchUser(path + id + ".json");
        user.setEmail(email);
        PrintWriter writer = null;
        String usersJson = gson.toJson(user);
        try {
            writer = new PrintWriter(path + id + ".json", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            throw new RuntimeException("failed to update user");
        }
        writer.print(usersJson);
        writer.close();
    }

    public void updateName(String id, String name) {
        User user = fetchUser(path + id + ".json");
        user.setName(name);
        PrintWriter writer = null;
        String usersJson = gson.toJson(user);
        try {
            writer = new PrintWriter(path + id + ".json", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            throw new RuntimeException("failed to update user");
        }
        writer.print(usersJson);
        writer.close();
    }

    public void updatePassword(String id, String password) {
        User user = fetchUser(path + id + ".json");
        user.setPassword(password);
        PrintWriter writer = null;
        String usersJson = gson.toJson(user);
        try {
            writer = new PrintWriter(path + id + ".json", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            throw new RuntimeException("failed to update user");
        }
        writer.print(usersJson);
        writer.close();
    }

    public void deleteUser(String id) {
        try {
            Files.delete(Paths.get(path + id + ".json"));
        } catch (IOException e) {
            throw new RuntimeException("failed to delete user");
        }

    }


}
