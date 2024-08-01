package in.manepata.security.usermanager.controllers;

import in.manepata.security.usermanager.dto.CenterDto;
import in.manepata.security.usermanager.services.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/centers")
public class CenterController {

    @Autowired
    private CenterService centerService;

    @PostMapping
    public ResponseEntity<CenterDto> createCenter(@RequestBody CenterDto centerDto) {
        CenterDto createdCenter = centerService.createCenter(centerDto);
        return ResponseEntity.ok(createdCenter);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CenterDto> getCenterById(@PathVariable Long id) {
        CenterDto centerDto = centerService.getCenterById(id);
        if (centerDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(centerDto);
    }

    @GetMapping
    public ResponseEntity<List<CenterDto>> getAllCenters() {
        List<CenterDto> centers = centerService.getAllCenters();
        return ResponseEntity.ok(centers);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CenterDto> updateCenter(@PathVariable Long id, @RequestBody CenterDto centerDto) {
        CenterDto updatedCenter = centerService.updateCenter(id, centerDto);
        if (updatedCenter == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCenter);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCenter(@PathVariable Long id) {
        centerService.deleteCenter(id);
        return ResponseEntity.noContent().build();
    }
}
