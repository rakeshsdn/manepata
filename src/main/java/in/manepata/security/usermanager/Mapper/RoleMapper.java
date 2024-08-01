package in.manepata.security.usermanager.Mapper;

import in.manepata.security.usermanager.dto.RoleDto;
import in.manepata.security.usermanager.entities.Role;
import in.manepata.security.usermanager.entities.Permission;
import in.manepata.security.usermanager.entities.Center;
import java.util.Set;
import java.util.stream.Collectors;

public class RoleMapper {
    public static RoleDto toDto(Role role) {
        RoleDto dto = new RoleDto();
        dto.setId(role.getId());
        dto.setName(role.getName());
        dto.setPermissionIds(role.getPermissions().stream().map(Permission::getId).collect(Collectors.toSet()));
        if (role.getCenter() != null) {
            dto.setCenterId(role.getCenter().getId());
        }
        return dto;
    }

    public static Role toEntity(RoleDto roleDto, Set<Permission> permissions, Center center) {
        Role role = new Role(roleDto.getName());
        role.setId(roleDto.getId());
        role.setPermissions(permissions);
        role.setCenter(center);
        return role;
    }
}
