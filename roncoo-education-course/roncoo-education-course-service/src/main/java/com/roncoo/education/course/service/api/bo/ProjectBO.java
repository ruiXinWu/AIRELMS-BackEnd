package com.roncoo.education.course.service.api.bo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class ProjectBO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * project ID
     */
    private long projectId;

    public Long getProjectId(){
        System.out.println("测试BO有没有拿到projectId: "+projectId);
        return projectId;
    }

}
