package com.infosys.taskinfomanager.repository;

import com.infosys.taskinfomanager.models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Tasks, String> {

    @Query(value = "select t from Tasks t where t.incidentId = :keyword or t.appName = :keyword or t.groupId = :keyword or t.empId = :keywordNum" )
    List<Tasks> findTasksByKeyword(@Param("keyword") String keyword, @Param("keywordNum") Integer keywordNum );

}
