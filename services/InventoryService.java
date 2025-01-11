package informational_systems.course.services;

import informational_systems.course.items.Inventory;
import informational_systems.course.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    // Получить все инвентари
    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }

    // Получить инвентарь по ID
    public Inventory getInventoryById(Integer id) {
        return inventoryRepository.findById(id).orElse(null);
    }

    // Создать новый инвентарь
    public Inventory createInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    // Обновить инвентарь
    public Inventory updateInventory(Integer id, Inventory inventoryDetails) {
        Inventory inventory = inventoryRepository.findById(id).orElse(null);
        if (inventory != null) {
            inventory.setItem1(inventoryDetails.getItem1());
            inventory.setItem2(inventoryDetails.getItem2());
            inventory.setItem3(inventoryDetails.getItem3());
            inventory.setItem4(inventoryDetails.getItem4());
            inventory.setItem5(inventoryDetails.getItem5());
            inventory.setItem6(inventoryDetails.getItem6());
            return inventoryRepository.save(inventory);
        }
        return null;
    }

    public void deleteInventory(Integer id) {
        inventoryRepository.deleteById(id);
    }
}