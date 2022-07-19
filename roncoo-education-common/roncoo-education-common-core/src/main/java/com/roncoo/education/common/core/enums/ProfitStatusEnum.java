/**
 * Copyright 2015-现在 广州市领课网络科技有限公司
 */
package com.roncoo.education.common.core.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author LHR
 */
@Getter
@AllArgsConstructor
public enum ProfitStatusEnum {

    CONFIRMING(1, "确认中"), SUCCESS(2, "成功"), FAIL(3, "失败");

    private Integer code;

    private String desc;
}
