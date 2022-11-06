package org.example;

import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        User user = new User("morpheus", "leader");
        HttpClient httpClient = HttpClient.getInstance();
        Response listUsers = httpClient.request(Method.GET,"https://reqres.in/api/users?page=2", new HashMap<>(), "");
        Response singleUser = httpClient.request(Method.GET,"https://reqres.in/api/users/2", new HashMap<>(), "");
        Response createUser = httpClient.request(Method.POST,"https://reqres.in/api/users", new HashMap<>(), user);
        user.setJob("teacher");
        Response updateUser = httpClient.request(Method.PUT,"https://reqres.in/api/users/2", new HashMap<>(), user);
        user.setName("moshe");
        Response updatePatchUser = httpClient.request(Method.PATCH,"https://reqres.in/api/users/2", new HashMap<>(), user);
//        Response deleteUser = httpClient.delete("https://reqres.in/api/users/2", new HashMap<>(), "");
        System.out.println(listUsers);
        System.out.println(singleUser);
        System.out.println(createUser);
        System.out.println(updateUser);
        System.out.println(updatePatchUser);
//        System.out.println(deleteUser);

    }
}