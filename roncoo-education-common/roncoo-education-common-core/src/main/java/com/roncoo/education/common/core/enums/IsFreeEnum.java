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
public enum IsFreeEnum {

    FREE(1, "免费", ""), CHARGE(0, "收费", "green");

    private Integer code;

    private String desc;

    private String color;

}
