package com.example.activitispringbootjpademo.controller;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author anyang
 * @CreateTime 2018/10/17
 * @Des
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByUsername(String username);

}
