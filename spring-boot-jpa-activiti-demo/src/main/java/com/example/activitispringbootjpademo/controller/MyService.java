package com.example.activitispringbootjpademo.controller;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author anyang
 * @CreateTime 2018/10/17
 * @Des
 */
@Service
@Transactional
public class MyService {
//    @Autowired
//    private RuntimeService runtimeService;
//
//    @Autowired
//    private TaskService taskService;
//
//    @Autowired
//    private PersonRepository personRepository;
//
//    public void startProcess(String assignee) {
//
//        Person person = personRepository.findByUsername(assignee);
//
//        Map<String, Object> variables = new HashMap<String, Object>();
//        variables.put("person", person);
//        runtimeService.startProcessInstanceByKey("oneTaskProcess", variables);
//    }
//
//    public List<Task> getTasks(String assignee) {
//        return taskService.createTaskQuery().taskAssignee(assignee).list();
//    }
//
//    public void createDemoUsers() {
//        if (personRepository.findAll().size() == 0) {
//            personRepository.save(new Person("jbarrez", "Joram", "Barrez", new Date()));
//            personRepository.save(new Person("trademakers", "Tijs", "Rademakers", new Date()));
//        }
//    }
}
