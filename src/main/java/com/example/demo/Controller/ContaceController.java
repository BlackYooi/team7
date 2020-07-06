package com.example.demo.Controller;

import com.example.demo.Service.ContaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 通讯录的控制层
 */
@RestController
@RequestMapping("/contace")
@CrossOrigin
public class ContaceController {
    @Autowired
    ContaceService contaceService;
}
