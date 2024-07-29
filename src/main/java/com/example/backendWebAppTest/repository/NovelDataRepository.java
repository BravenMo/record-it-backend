package com.example.backendWebAppTest.repository;

import com.example.backendWebAppTest.model.NovelData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NovelDataRepository extends JpaRepository<NovelData,Long> {
}
