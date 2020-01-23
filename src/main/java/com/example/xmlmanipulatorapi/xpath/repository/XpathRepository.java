package com.example.xmlmanipulatorapi.xpath.repository;

import com.example.xmlmanipulatorapi.xpath.entity.Xpath;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface XpathRepository extends MongoRepository<Xpath, Integer> {
}
