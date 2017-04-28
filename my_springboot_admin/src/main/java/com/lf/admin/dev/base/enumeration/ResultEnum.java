package com.lf.admin.dev.base.enumeration;

/**
 * @Title: ResultEnum.java
 * @Description: 结果状态相应码
 * @author Liangfeng
 * @date 2017/4/26 0026 22:49
 * @version 1.0
 */
public class ResultEnum {

    /**
     * 后台result状态枚举  成功 0000;异常 9999;失败 9998;其他
     */
    public enum AdminResultStatus{
        /** 成功 */
        SUCCESS("0000"),
        /** 异常 */
        EXCEPTION("9999"),
        /** 其他 */
        OTHER("6666");

        private final String value;

        private AdminResultStatus(String value) {
            this.value = value;
        }
        public String value() {
            return value;
        }
    }

    /**
     * APP移动端result状态枚举  成功 0000;异常 9999;失败 9998;其他
     */
    public enum APPResultStatus{
        /** 成功 */
        SUCCESS("0000"),
        /** 异常 */
        EXCEPTION("9999"),
        /** 其他 */
        OTHER("6666");

        private final String value;

        private APPResultStatus(String value) {
            this.value = value;
        }
        public String value() {
            return value;
        }
    }


}
