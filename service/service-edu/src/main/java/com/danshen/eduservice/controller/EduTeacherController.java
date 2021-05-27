package com.danshen.eduservice.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.danshen.eduservice.entity.EduTeacher;
import com.danshen.eduservice.service.EduTeacherService;
import com.danshen.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Api(tags = "讲师管理")
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {
    @Autowired
    private EduTeacherService eduTeacherService;

    @ApiOperation(value = "查询所有讲师")
    @GetMapping("/getAll")
    public Result selectAll() {
        List<EduTeacher> list = eduTeacherService.list(null);
        return Result.ok().data("items",list);
    }

    @ApiOperation(value = "根据ID查询讲师")
    @GetMapping("/getOne/{id}")
    public Result selectById(@ApiParam(name = "id",value = "讲师ID",required = true) @PathVariable String id) {
        EduTeacher eduTeacher = eduTeacherService.getById(id);
        if (eduTeacher != null)
            return Result.ok().data("items",eduTeacher);
        else
            return Result.error().message("未获取到相关信息");
    }

    @ApiOperation(value = "分页查询讲师信息")
    @GetMapping("/page/{start}/{limit}")
    public Result pageList(
            @ApiParam(name = "start", value = "当前页", required = true) @PathVariable Long start,
            @ApiParam(name = "limit",value = "每页数据量",required = true) @PathVariable Long limit) {
        Page<EduTeacher> page = new Page<>(start, limit);
        IPage<EduTeacher> iPage = eduTeacherService.page(page, null);
        return Result.ok().data("total",iPage.getTotal()).data("rows",iPage.getRecords());
    }

    @ApiOperation(value = "条件查询且分页")
    @PostMapping("/search")
    public Result search() {

        return Result.ok();
    }


}

