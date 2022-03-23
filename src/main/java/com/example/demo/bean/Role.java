package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 角色对象 Role
 */
@Entity
@Table(name = "t_role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    /**
     * 角色ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long role_id;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private Long role_name;

    /**
     * 角色描述
     */
    @Column(name = "remark")
    private Long remark;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Long create_time;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Long modify_time;
}
