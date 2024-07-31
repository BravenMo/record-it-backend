package com.example.backendWebAppTest.repository;

import com.example.backendWebAppTest.model.GameData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameDataRepository extends JpaRepository<GameData,Long> {
}
