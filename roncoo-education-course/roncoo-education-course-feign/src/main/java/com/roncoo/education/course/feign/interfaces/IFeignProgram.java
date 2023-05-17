package com.roncoo.education.course.feign.interfaces;

import com.roncoo.education.course.feign.interfaces.vo.ProgramVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "roncoo-education-course-service")
public interface IFeignProgram {
    @RequestMapping(value = "/feign/course/program/get/{id}", method = RequestMethod.GET)
    ProgramVO getById(@PathVariable(value = "id") Long id);
}
