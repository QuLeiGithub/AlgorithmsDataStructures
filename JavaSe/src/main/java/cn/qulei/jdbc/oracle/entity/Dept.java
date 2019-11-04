package cn.qulei.jdbc.oracle.entity;

import lombok.*;

/**
 * @author QuLei
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Dept {
    private Integer deptno;
    private String dname;
    private String loc;
}
