package com.roncoo.education.system.service.pc.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 底部导航-查看
 */
@Data
@Accessors(chain = true)
public class WebsiteNavViewREQ implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 主键ID
     */
    @ApiModelProperty(value = "主键ID", required = true)
    private Long id;

}
