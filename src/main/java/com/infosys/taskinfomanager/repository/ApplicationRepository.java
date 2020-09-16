package com.infosys.taskinfomanager.repository;


import com.infosys.taskinfomanager.models.Applications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository extends JpaRepository<Applications, String>{

}
