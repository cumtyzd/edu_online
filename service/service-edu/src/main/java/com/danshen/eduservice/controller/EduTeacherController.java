package com.danshen.eduservice.controller;


import com.danshen.eduservice.entity.EduTeacher;
import com.danshen.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.events.Event;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author danshen
 * @since 2021-05-26
 */
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    @PostMapping("/add ")
    public String addTeacher() {
        return "";
    }

    /**
     * 查询所有讲师信息
     * @return
     */
    @GetMapping("/getAll")
    public String selectAll() {
        List<EduTeacher> list = eduTeacherService.list(null);
        return list.toString();
    }
    @GetMapping("/update/{id}")
    public Boolean updateById(@PathParam("id") String id) {
        EduTeacher eduTeacher = new EduTeacher();
        eduTeacher.setId(id);
        eduTeacher.setName("李四");
        return eduTeacherService.updateById(eduTeacher);
    }

}

