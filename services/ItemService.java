package informational_systems.course.services;

import informational_systems.course.items.Item;
import informational_systems.course.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    // Получить все предметы
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Получить предмет по ID
    public Item getItemById(Integer id) {
        return itemRepository.findById(id).orElse(null);
    }

    // Создать новый предмет
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    // Обновить предмет
    public Item updateItem(Integer id, Item itemDetails) {
        Item item = itemRepository.findById(id).orElse(null);
        if (item != null) {
            item.setName(itemDetails.getName());
            return itemRepository.save(item);
        }
        return null;
    }

    // Удалить предмет
    public void deleteItem(Integer id) {
        itemRepository.deleteById(id);
    }

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }
}