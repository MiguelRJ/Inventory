package com.example.inventoryFragmentBD.data.db.repository;

import com.example.inventoryFragmentBD.data.db.model.User;

import java.util.ArrayList;

/**
 * Created by usuario on 8/11/17.
 */

public class UserRepository {
    private static UserRepository userRepository;
    private ArrayList<User> users;

    private UserRepository() {
        users = new ArrayList<>();
        initialice();
    }

    private void initialice() {
        saveUser(new User(1,"Migue1","123","Miguel Rodriguez Jimenez", "miguel1@gmail.com",false,false));
        saveUser(new User(2,"Migue2","123","Miguel Rodriguez Jimenez", "miguel2@gmail.com",true,false));
        saveUser(new User(3,"Migue3","123","Miguel Rodriguez Jimenez", "miguel3@gmail.com",false,true));
        saveUser(new User(4,"Migue4","123","Miguel Rodriguez Jimenez", "miguel4@gmail.com",true,true));
    }

    private void saveUser(User user){
        users.add(user);
    }

    public static UserRepository getInstance(){
        if(userRepository == null) {
            userRepository = new UserRepository();
        }
        return userRepository;
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    /**
     * Metodo que comprueba si el usuario existe en la base de datos
     * @return
     */
    public boolean isUserExists(User user){
        return true;
    }

}
