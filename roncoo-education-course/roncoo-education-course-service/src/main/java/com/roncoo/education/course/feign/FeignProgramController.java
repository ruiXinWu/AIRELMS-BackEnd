package com.roncoo.education.course.feign;

import com.roncoo.education.common.core.base.BaseController;
import com.roncoo.education.course.feign.biz.FeignProgramBiz;
import com.roncoo.education.course.feign.interfaces.IFeignProgram;
import com.roncoo.education.course.feign.interfaces.vo.ProgramVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignProgramController extends BaseController implements IFeignProgram {
    @Autowired
    private FeignProgramBiz biz;

    @Override
    public ProgramVO getById(@PathVariable(value = "id") Long id){
        System.out.println("FeignProgramController success");
        return biz.getById(id);
    }
}
