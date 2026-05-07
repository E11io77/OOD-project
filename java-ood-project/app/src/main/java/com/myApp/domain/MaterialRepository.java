package com.myApp.domain;

import java.util.List;
import java.util.Optional;

public interface MaterialRepository { //umožní udělat template, seznam "slibů"
    List<Material> findAll();
    Optional<Material> findByName(String name);
    void addMaterial(Material material); 
}
