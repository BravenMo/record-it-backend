package com.example.backendWebAppTest.repository;

import com.example.backendWebAppTest.model.ShowData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowDataRepository extends JpaRepository<ShowData,Long> {
}
