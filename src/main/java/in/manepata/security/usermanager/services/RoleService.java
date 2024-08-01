package in.manepata.security.usermanager.services;

import in.manepata.security.usermanager.dto.RoleDto;
import in.manepata.security.usermanager.entities.Role;
import in.manepata.security.usermanager.entities.Permission;
import in.manepata.security.usermanager.entities.Center;
import in.manepata.security.usermanager.Mapper.RoleMapper;
import in.manepata.security.usermanager.repository.interfaces.CenterRepository;
import in.manepata.security.usermanager.repository.interfaces.PermissionRepository;
import in.manepata.security.usermanager.repository.interfaces.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private CenterRepository centerRepository;

    public RoleDto createRole(RoleDto roleDto) {
        Set<Permission> permissions = roleDto.getPermissionIds().stream()
                .map(id -> permissionRepository.findById(id).orElseThrow(() -> new RuntimeException("Permission not found")))
                .collect(Collectors.toSet());

        Center center = centerRepository.findById(roleDto.getCenterId())
                .orElseThrow(() -> new RuntimeException("Center not found"));

        Role role = RoleMapper.toEntity(roleDto, permissions, center);
        Role savedRole = roleRepository.save(role);
        return RoleMapper.toDto(savedRole);
    }

    public RoleDto updateRole(Long id, RoleDto roleDto) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));

        Set<Permission> permissions = roleDto.getPermissionIds().stream()
                .map(permissionId -> permissionRepository.findById(permissionId)
                        .orElseThrow(() -> new RuntimeException("Permission not found")))
                .collect(Collectors.toSet());

        Center center = centerRepository.findById(roleDto.getCenterId())
                .orElseThrow(() -> new RuntimeException("Center not found"));

        role.setName(roleDto.getName());
        role.setPermissions(permissions);
        role.setCenter(center);

        Role updatedRole = roleRepository.save(role);
        return RoleMapper.toDto(updatedRole);
    }

    public RoleDto getRoleById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        return RoleMapper.toDto(role);
    }

    public void deleteRole(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        roleRepository.delete(role);
    }
}
