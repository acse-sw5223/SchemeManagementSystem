package com.so.commons.enums;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 角色枚举信息
 * @author democxy
 * @version 2021/7/18
 */
public enum RoleEnum {

    /**
     * 管理员
     */
    SUPER("1", "技术人员"),

    ADMIN("2", "管理员"),

    /**
     * 普通用户
     */
    COMMON("3", "普通用户"),

    ;

    private String roleId;

    private String roleName;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    RoleEnum(String roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    /**
     * 根据角色ID获取角色名称
     *
     * @param roleId
     * @return
     */
    public static String getRoleName(String roleId) {
        List<RoleEnum> roles = getRoles();
        List<RoleEnum> collect = roles.stream().filter(roleEnum -> roleId.equals(roleEnum.getRoleId())).collect(Collectors.toList());
        if (Objects.nonNull(collect) && collect.size() > 0) {
            return collect.get(0).getRoleName();
        } else {
            return "";
        }
    }

    public static List<RoleEnum> getRoles() {
        RoleEnum[] values = RoleEnum.values();
        return Arrays.asList(values);
    }

    public static void main(String[] args) {
        List<RoleEnum> roles = getRoles();
        for (RoleEnum role : roles) {
            System.out.println(role.getRoleId() + ":" + role.getRoleName());
        }
        System.out.println(getRoleName("2"));
    }
}
