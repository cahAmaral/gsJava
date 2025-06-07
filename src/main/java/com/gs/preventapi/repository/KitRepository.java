package com.gs.preventapi.repository;

import com.gs.preventapi.model.Kit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KitRepository extends JpaRepository<Kit, Integer> {
}
