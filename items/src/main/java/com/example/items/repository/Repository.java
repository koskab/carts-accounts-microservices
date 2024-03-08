package com.example.items.repository;

import com.example.items.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Item, Long> {
}
