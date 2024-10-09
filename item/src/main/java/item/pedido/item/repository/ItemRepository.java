package item.pedido.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import item.pedido.item.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    
}
