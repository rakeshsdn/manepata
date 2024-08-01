package in.manepata.security.usermanager.services;

import in.manepata.security.usermanager.Mapper.CenterMapper;
import in.manepata.security.usermanager.dto.CenterDto;
import in.manepata.security.usermanager.entities.Center;
import in.manepata.security.usermanager.repository.interfaces.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CenterService {

    @Autowired
    private CenterRepository centerRepository;

    public CenterDto createCenter(CenterDto centerDto) {
        Center center = CenterMapper.mapToCenter(centerDto);
        Center savedCenter = centerRepository.save(center);
        return CenterMapper.mapToCenterDto(savedCenter);
    }

    public CenterDto getCenterById(Long id) {
        Optional<Center> center = centerRepository.findById(id);
        return center.map(CenterMapper::mapToCenterDto).orElse(null);
    }

    public List<CenterDto> getAllCenters() {
        List<Center> centers = centerRepository.findAll();
        return CenterMapper.mapToCenterDtoList(centers);
    }

    public CenterDto updateCenter(Long id, CenterDto centerDto) {
        if (!centerRepository.existsById(id)) {
            return null;
        }

        Center center = CenterMapper.mapToCenter(centerDto);
        center.setId(id); // Ensure the entity has the correct ID
        Center updatedCenter = centerRepository.save(center);
        return CenterMapper.mapToCenterDto(updatedCenter);
    }

    public void deleteCenter(Long id) {
        centerRepository.deleteById(id);
    }
}
