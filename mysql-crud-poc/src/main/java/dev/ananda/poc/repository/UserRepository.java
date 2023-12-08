package dev.ananda.poc.repository;

import dev.ananda.poc.mysql.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
