package com.roncoo.education.user.service.api.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class UserInfoBO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long userId;

    public Long getId() {
        return id;
    }

    public Long getUserId(){
        return userId;
    }
}