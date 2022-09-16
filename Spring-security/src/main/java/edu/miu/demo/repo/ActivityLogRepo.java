package edu.miu.demo.repo;

import edu.miu.demo.model.ActivityLog;
import org.springframework.data.repository.CrudRepository;

public interface ActivityLogRepo  extends CrudRepository<ActivityLog, Integer> {
}
