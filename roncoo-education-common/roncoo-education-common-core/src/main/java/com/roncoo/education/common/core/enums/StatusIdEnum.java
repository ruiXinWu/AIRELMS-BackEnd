/**
 * Copyright 2015-现在 广州市领课网络科技有限公司
 */
package com.roncoo.education.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author wujing
 */
@Getter
@AllArgsConstructor
public enum StatusIdEnum {

    YES(1, "正常", ""), NO(0, "禁用", "red");

    private Integer code;

    private String desc;

    private String color;

}
