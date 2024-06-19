package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemTest {
    private Item item;

    @BeforeEach
    void setUp() {
        item = new Item("Produto1", 2, 10.0); // Total: 20.0
    }

    @Test
    void testGetValorUnitario() {
        assertEquals(20.0, item.getValorUnitario(), 0.01, "O valor unitário deve ser 20.0");
    }

    @Test
    void testAplicarDesconto() {
        assertTrue(item.aplicarDesconto(10), "Desconto deve ser aplicado com sucesso");
        assertEquals(2.0, item.getPrecoUnitario(), 0.01, "O preço unitário com desconto de 10% deve ser 2.0");
    }

    @Test
    void testAplicarDescontoInvalido() {
        assertFalse(item.aplicarDesconto(80), "Desconto acima do limite deve falhar");
        assertEquals(10.0, item.getPrecoUnitario(), 0.01, "O preço unitário deve permanecer 10.0");
    }
}
