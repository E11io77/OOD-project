package com.myApp.application;
import com.myApp.domain.MaterialRepository;
import com.myApp.domain.Material;
import java.util.List;
import java.util.Optional;
public class MaterialService {

    private MaterialRepository materialRepository; // programming to an interface, not an implementation - proto nedostane Local třídu

    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
}
 

  public List<Material> listMaterials() {
        return materialRepository.findAll();
    }

     public Optional<Material> getMaterial(String name) {
        return materialRepository.findByName(name);
    }
}