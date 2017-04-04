package ml.littleapp.pojo;

import javax.persistence.*;

@Table(name = "sys_role_office")
public class SysRoleOffice extends BaseEntity {
    /**
     * 角色编号
     */
    @Id
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 机构编号
     */
    @Id
    @Column(name = "office_id")
    private Long officeId;

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

    /**
     * 获取机构编号
     *
     * @return office_id - 机构编号
     */
    public Long getOfficeId() {
        return officeId;
    }

    /**
     * 设置机构编号
     *
     * @param officeId 机构编号
     */
    public void setOfficeId(Long officeId) {
        this.officeId = officeId;
    }
}