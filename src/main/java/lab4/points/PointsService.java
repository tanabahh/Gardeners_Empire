package lab4.points;

import lab4.users.UserEntity;
import lab4.users.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PointsService {

    private final PointRepository repository;
    private final UsersRepository usersRepository;

    PointsService(PointRepository repository, UsersRepository usersRepository) {
        this.repository = repository;
        this.usersRepository = usersRepository;
    }

    public PointEntity addPoint(PointEntity point) {
        return repository.save(point);
    }

    public List<PointEntity> getPoints(String username) {
        final UserEntity userEntity = usersRepository.getOne(username);
        return repository.findByUserOrderByCreatedDesc(userEntity);
    }
}
