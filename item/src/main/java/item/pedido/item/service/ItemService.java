package item.pedido.item.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import item.pedido.item.dto.ItemDto;
import item.pedido.item.model.Item;
import item.pedido.item.repository.ItemRepository;

@Service
public class ItemService {


    @Autowired
    private ItemRepository itemRepository;

    public ItemDto saveItem(ItemDto itemDto) {
        Item item = new Item();
        item.setNome(itemDto.nome());
        item.setQuantidade(itemDto.quantidade());
        item.setDataCadastro(itemDto.dataCadastro());
        item.setDescricao(itemDto.descricao());
        item.setUrlImagem(itemDto.urlImagem());
        item.setValor(itemDto.valor());
        item.setId_categoria(itemDto.id_categoria());
        itemRepository.save(item);
        return new ItemDto(item.getId(), item.getNome(), item.getQuantidade(), item.getValor(), item.getDescricao(), item.getUrlImagem(), item.getId_categoria(), item.getDataCadastro());
    }

    public List<ItemDto> findAllItems() {
        return itemRepository.findAll().stream().map(item -> new ItemDto(item.getId(), item.getNome(), item.getQuantidade(), item.getValor(), item.getDescricao(), item.getUrlImagem(), item.getId_categoria(), item.getDataCadastro())).collect(Collectors.toList());
    }

    public ItemDto findById(Long id) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        return itemOptional.map(item -> new ItemDto(item.getId(), item.getNome(), item.getQuantidade(), item.getValor(), item.getDescricao(), item.getUrlImagem(), item.getId_categoria(), item.getDataCadastro())).orElse(null);
    }

    public ItemDto updateItem(Long id, ItemDto itemDto) {
        Optional<Item> itemOptional = itemRepository.findById(id);
        if (itemOptional.isPresent()) {
            Item item = itemOptional.get();
            item.setNome(itemDto.nome());
            item.setQuantidade(itemDto.quantidade());
            item.setDataCadastro(itemDto.dataCadastro());
            item.setDescricao(itemDto.descricao());
            item.setUrlImagem(itemDto.urlImagem());
            item.setValor(itemDto.valor());
            item.setId_categoria(itemDto.id_categoria());
            itemRepository.save(item);
            return new ItemDto(item.getId(), item.getNome(), item.getQuantidade(), item.getValor(), item.getDescricao(), item.getUrlImagem(), item.getId_categoria(), item.getDataCadastro());
        }
        return null;
    }

    public void deleteById(Long id) {
        itemRepository.deleteById(id);
    }
}
