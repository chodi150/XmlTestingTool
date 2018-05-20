package com.example.projektpik.database;

import com.example.projektpik.domain.XmlDocument;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Piotr on 20.05.2018.
 */


public interface XmlDocumentRepository extends CrudRepository<XmlDocument, Long>{

    Optional<XmlDocument> findById(Long id);
    List<XmlDocument> findAll();
}
