package in.manepata.security.usermanager.Mapper;

import in.manepata.security.usermanager.dto.CenterDto;
import in.manepata.security.usermanager.entities.Center;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CenterMapper {

    // Method to map CenterDto to Center with null checks
    public static Center mapToCenter(CenterDto centerDto) {
        if (centerDto == null) {
            return null;
        }

        Center center = new Center();

        Optional.ofNullable(centerDto.getId()).ifPresent(center::setId);
        Optional.ofNullable(centerDto.getName()).ifPresent(center::setName);
        Optional.ofNullable(centerDto.getAddress()).ifPresent(center::setAddress);
        Optional.ofNullable(centerDto.getCreatedDateTime()).ifPresent(center::setCreatedDateTime);

        return center;
    }

    // Method to map Center to CenterDto with null checks
    public static CenterDto mapToCenterDto(Center center) {
        if (center == null) {
            return null;
        }

        CenterDto centerDto = new CenterDto();

        Optional.ofNullable(center.getId()).ifPresent(centerDto::setId);
        Optional.ofNullable(center.getName()).ifPresent(centerDto::setName);
        Optional.ofNullable(center.getAddress()).ifPresent(centerDto::setAddress);
        Optional.ofNullable(center.getCreatedDateTime()).ifPresent(centerDto::setCreatedDateTime);

        return centerDto;
    }

    // Method to map a list of Center entities to a list of CenterDto objects
    public static List<CenterDto> mapToCenterDtoList(List<Center> centers) {
        if (centers == null) {
            return null;
        }

        return centers.stream()
                .map(CenterMapper::mapToCenterDto)
                .collect(Collectors.toList());
    }
}
