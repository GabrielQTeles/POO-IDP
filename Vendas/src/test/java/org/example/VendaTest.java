package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class VendaTest {
    private Venda venda;
    private Item item1;
    private Item item2;

    @BeforeEach
    void setUp() {
        venda = new Venda();
        item1 = new Item("Item1", 10.0, 2); // Total: 20.0
        item2 = new Item("Item2", 5.0, 4);  // Total: 20.0
    }

    @Test
    void testAdicionarItem() {
        venda.adicionarItem(item1);
        venda.adicionarItem(item2);
        List<Item> itens = venda.getItens();
        assertEquals(2, itens.size(), "A venda deve ter 2 itens");
    }

    @Test
    void testGetTotalVenda() {
        venda.adicionarItem(item1);
        venda.adicionarItem(item2);
        double totalVenda = venda.getTotalVenda();
        assertEquals(40.0, totalVenda, "O total da venda deve ser 40.0");
    }

    @Test
    void testAdicionarItemQuantidadeZero() {
        Item itemZero = new Item("ItemZero", 10.0, 0);
        venda.adicionarItem(itemZero);
        assertEquals(1, venda.getItens().size(), "A venda deve aceitar itens com quantidade zero");
        assertEquals(0.0, venda.getTotalVenda(), "O total da venda deve ser 0.0 para item com quantidade zero");
    }

    @Test
    void testAdicionarItemQuantidadeNegativa() {
        Item itemNegativo = new Item("ItemNegativo", 10.0, -1);
        venda.adicionarItem(itemNegativo);
        assertTrue(venda.getItens().isEmpty(), "A venda não deve aceitar itens com quantidade negativa");
    }

    @Test
    void testGetItens() {
        venda.adicionarItem(item1);
        venda.adicionarItem(item2);
        List<Item> itens = venda.getItens();
        assertEquals("Item1", itens.get(0).getNome());
        assertEquals("Item2", itens.get(1).getNome());
    }

    @Test
    void testVendaVazia() {
        assertEquals(0, venda.getItens().size(), "Inicialmente, a venda deve estar vazia");
        assertEquals(0.0, venda.getTotalVenda(), "Inicialmente, o total da venda deve ser 0.0");
    }
}