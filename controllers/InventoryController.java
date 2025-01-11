package informational_systems.course.controllers;

import informational_systems.course.items.Inventory;
import informational_systems.course.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    // Получить все инвентари
    @GetMapping
    public List<Inventory> getAllInventories() {
        return inventoryService.getAllInventories();
    }

    // Получить инвентарь по ID
    @GetMapping("/{id}")
    public Inventory getInventoryById(@PathVariable Integer id) {
        return inventoryService.getInventoryById(id);
    }
}
