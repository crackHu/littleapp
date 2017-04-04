package ml.littleapp.pojo;

import javax.persistence.*;

@Table(name = "sys_role_menu")
public class SysRoleMenu extends BaseEntity {
    /**
     * 角色编号
     */
    @Id
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 菜单编号
     */
    @Id
    @Column(name = "menu_id")
    private Long menuId;

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
     * 获取菜单编号
     *
     * @return menu_id - 菜单编号
     */
    public Long getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单编号
     *
     * @param menuId 菜单编号
     */
    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}