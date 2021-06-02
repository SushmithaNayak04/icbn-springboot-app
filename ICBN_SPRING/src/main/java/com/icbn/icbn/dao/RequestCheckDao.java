package com.icbn.icbn.dao;

import java.util.List;
import com.icbn.icbn.domain.RequestCheck;
import org.springframework.data.repository.CrudRepository;

public interface RequestCheckDao extends CrudRepository<RequestCheck, Long> {

    List<RequestCheck> findAll();
}
