package com.mahbub.hellomvc.controller;


import com.mahbub.hellomvc.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeCont {

  static   List<User> list;

    static {
        list = new ArrayList<>();
        list.add(new User(1L, "Sakl", "01722928984"));
        list.add(new User(2L, "Mahbub", "01722928989"));
        list.add(new User(3L, "m", "01722928988"));
        list.add(new User(4L, "B", "01722928987"));
    }

    @GetMapping(value = "/")
    public String hello() {
        return "Hello World";

    }


    @GetMapping(value = "/user")
    public User getByObject() {

        return new User(1L, "Mahbub", "01683715092");
    }


    @GetMapping("/list")
    public List<User> getList() {


        return this.list;
    }

    @GetMapping(value = "/user/{id}/{mobile}")
    public User getUserById(@PathVariable("id") Long userid, @PathVariable("mobile") String mob) {
        User user = null;
        for (User u : this.list) {
            if (userid == u.getId() && mob.equalsIgnoreCase(u.getMobile())) {
                user = new User();
                user = new User(u.getId(), u.getUserName(), u.getMobile());
                break;
            }

        }

        return user;
    }


    @GetMapping(value = "/addUser")
    public List<User> addUserToList(){
        list.add(new User(5L,"Nazmul", "01722711081"));
        return list;
    }


long id=list.size();
    @GetMapping(value = "/add/{userName}/{mobile}")
    public List<User> addUserToListDynamically(@PathVariable("userName") String name, @PathVariable("mobile") String mob){
        id++;
        list.add(new User(id, name, mob));
        return list;
    }


    @GetMapping(value = "/del/{id}")
    public List<User> deleteUserToListDynamically(@PathVariable("id") String name){

        list.remove(new User(id));
        --id;
        return list;
    }
}
