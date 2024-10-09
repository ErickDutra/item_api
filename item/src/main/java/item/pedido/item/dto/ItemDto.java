package item.pedido.item.dto;

import java.util.Date;

public record ItemDto(Long id, String nome, Long quantidade, Double valor, String descricao, String urlImagem, Long id_categoria, Date dataCadastro) {
    
}
