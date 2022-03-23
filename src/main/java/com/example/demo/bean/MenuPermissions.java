package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 菜单权限对象 permissions
 *
 * @author Rewrite
 */
@Entity
@Table(name = "t_menu")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MenuPermissions {

    /**
     * 菜单/按钮ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long menu_id;

    /**
     * 上级菜单ID
     */
    @Column(name = "parent_id")
    private String parent_id;

    /**
     * 菜单/按钮名称
     */
    @Column(name = "menu_name")
    private String menu_name;

    /**
     * 菜单URL
     */
    @Column(name = "rul")
    private String url;

    /**
     * 权限标识
     */
    @Column(name = "perms")
    private String perms;

    /**
     * 图标
     */
    @Column(name = "icon")
    private String icon;

    /**
     * 类型 0菜单 1按钮
     */
    @Column(name = "type")
    private String type;

    /**
     * 排序
     */
    @Column(name = "order_num")
    private String order_num;

    /**
     * 创建时间
     */
    @Column(name = "creat_time")
    private String creat_time;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private String modify_time;
}
