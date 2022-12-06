package com.lytech.flow.app.transcation.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.lytech.flow.app.transcation.entity.*;

@Repository
public interface TranscationRepository extends JpaRepository<Transcations, Long> {

}
