package item.pedido.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import item.pedido.item.dto.ItemDto;
import item.pedido.item.service.ItemService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@CrossOrigin("*")
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/save")
    public ResponseEntity<ItemDto> postMethodName(@RequestBody ItemDto itemDto)  {
        return ResponseEntity.ok(itemService.saveItem(itemDto));
    }

    @GetMapping("/getAll")
    public List<ItemDto> getAllItens(@RequestParam Long id) {
        return itemService.findAllItems();
       
    }

    @DeleteMapping("/update")
    public ResponseEntity<ItemDto> update(@RequestParam Long id, @RequestBody ItemDto itemDto) {
        return ResponseEntity.ok(itemService.updateItem(id, itemDto));
    }

    @GetMapping("/byId")
    public ResponseEntity<ItemDto> getItemById(@RequestParam Long id) {
        ItemDto item = itemService.findById(id);
        if (item != null) {
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}
