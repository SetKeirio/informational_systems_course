package informational_systems.course.controllers;

import informational_systems.course.items.Item;
import informational_systems.course.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // Получить все предметы
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    // Получить предмет по ID
    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Integer id) {
        return itemService.getItemById(id);
    }

    @PostMapping
    public Item addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }
}