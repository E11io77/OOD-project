package com.myApp.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
public class LocalMaterialRepository implements MaterialRepository {
    private List <Material> materials = new ArrayList<>();
    
    public void addMaterial (Material material) {
        materials.add(material);
    }
    @Override
    public List<Material> findAll() {
        return materials;
    }
    @Override
    public Optional<Material> findByName (String name) {
        for (Material material: materials) {
            if (material.getName().equals (name)) {
                return Optional.of(material); // pokud jsme našli
            }
        }
        return Optional.empty(); //pokud se nic nenajde
    }
   
    }