package edu.miu.demo.repo;

import edu.miu.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends CrudRepository<User, Integer> {

}
