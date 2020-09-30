package com.infosys.taskinfomanager.repository;

import com.infosys.taskinfomanager.models.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupsRepository extends JpaRepository<Groups, String> {
}
