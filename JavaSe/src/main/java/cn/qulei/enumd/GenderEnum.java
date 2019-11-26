package cn.qulei.enumd;

import lombok.NoArgsConstructor;

/**
 * 测试枚举类
 *
 * @author QuLei
 */
@NoArgsConstructor
public enum GenderEnum {
    LAUNCH("launch"),
    PAGVIEW("pageview"),
    EVENT("event");
    private String name;

    GenderEnum(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println(this.name);
    }
}
