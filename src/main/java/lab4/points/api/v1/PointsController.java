package lab4.points.api.v1;

import lab4.area.AreaService;
import lab4.points.PointEntity;
import lab4.points.PointsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/points")
public class PointsController {

    private final PointsService service;
    private final AreaService areaService;

    public PointsController(PointsService service, AreaService areaService) {
        this.service = service;
        this.areaService = areaService;
    }

    @CrossOrigin
    @GetMapping("/get")
    public List<PointDto> getPoints(Principal principal) {
        List<PointEntity> points = service.getPoints(principal.getName());

        return points.parallelStream().map(PointDto::new).collect(Collectors.toList());
    }

    @CrossOrigin
    @GetMapping("/get/{r}")
    public List<PointDto> allPointsRecalculation(@PathVariable Double r, Principal principal) {
        List<PointEntity> points = service.getPoints(principal.getName());

        return points.parallelStream()
                .filter(pointEntity -> pointEntity.getR().equals(r))
                .map(PointDto::new)
                .collect(Collectors.toList());
    }

    @CrossOrigin
    @PostMapping("/add")
    public ResponseEntity<?> addPoint(
            @RequestParam double x,
            @RequestParam double y,
            @RequestParam double r,
            Principal principal
    ) {
        final boolean hit = areaService.contains(x, y, r);

        service.addPoint(x, y, r, hit, principal.getName());

        return new ResponseEntity<>(hit, HttpStatus.CREATED);
    }
}
