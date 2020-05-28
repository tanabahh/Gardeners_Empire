package lab4.points;

import lab4.users.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository extends JpaRepository<PointEntity, Long> {

    List<PointEntity> findByUserOrderByCreatedDesc(UserEntity userEntity);
}
