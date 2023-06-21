package com.roncoo.education.course.feign.interfaces;

import com.roncoo.education.course.feign.interfaces.vo.OfficeHourVO;
import com.roncoo.education.course.feign.interfaces.vo.ProgramVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "roncoo-education-course-service")
public interface IFeignOfficeHour {
    @RequestMapping(value = "/feign/course/officeHour/getByProgramId/{id}", method = RequestMethod.GET)
    OfficeHourVO getByProgramId(@PathVariable(value = "id") Long id);
}
