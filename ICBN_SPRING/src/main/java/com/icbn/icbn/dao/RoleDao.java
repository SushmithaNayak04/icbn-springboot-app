package com.icbn.icbn.dao;

import com.icbn.icbn.domain.security.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleDao extends CrudRepository<Role, Integer> {
    
    Role findByName(String name);
}
