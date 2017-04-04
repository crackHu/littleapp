package ml.littleapp.pojo;

import javax.persistence.*;

@Table(name = "sys_user_role")
public class SysUserRole extends BaseEntity {
    /**
     * 用户编号
     */
    @Id
    @Column(name = "user_id")
    private Long userId;

    /**
     * 角色编号
     */
    @Id
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 获取用户编号
     *
     * @return user_id - 用户编号
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户编号
     *
     * @param userId 用户编号
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取角色编号
     *
     * @return role_id - 角色编号
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置角色编号
     *
     * @param roleId 角色编号
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}