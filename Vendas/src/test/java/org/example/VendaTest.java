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
        venda = new Venda("Cliente Teste");
        item1 = new Item("Produto1", 2, 10.0); // Total: 20.0
        item2 = new Item("Produto2", 4, 5.0);  // Total: 20.0
    }

    @Test
    void testGetValor() {
        venda.vender("Produto1", 10.0, 2);
        venda.vender("Produto2", 5.0, 4);
        double totalVenda = venda.getValor();
        assertEquals(40.0, totalVenda, "O total da venda deve ser 40.0");
    }

    @Test
    void testAplicarDesconto() {
        venda.vender("Produto1", 10.0, 2);
        venda.vender("Produto2", 5.0, 4);
        assertTrue(venda.aplicarDesconto(10), "Desconto deve ser aplicado com sucesso");
        assertEquals(36.0, venda.getValor(), 0.01, "O total da venda com desconto de 10% deve ser 36.0");
    }

    @Test
    void testAplicarDescontoInvalido() {
        venda.vender("Produto1", 10.0, 2);
        venda.vender("Produto2", 5.0, 4);
        assertFalse(venda.aplicarDesconto(80), "Desconto acima do limite deve falhar");
        assertEquals(40.0, venda.getValor(), 0.01, "O total da venda deve permanecer 40.0");
    }

    @Test
    void testSituacaoVenda() {
        assertEquals(Venda.SITUACAO_NAO_INICIADA, venda.getSituacao(), "Inicialmente, a situação deve ser NÃO INICIADA");
        venda.vender("Produto1", 10.0, 2);
        assertEquals(Venda.SITUACAO_EM_ANDAMENTO, venda.getSituacao(), "Após adicionar item, a situação deve ser EM ANDAMENTO");
        venda.finalizar();
        assertEquals(Venda.SITUACAO_ENCERRADA, venda.getSituacao(), "Após finalizar, a situação deve ser ENCERRADA");
    }

    @Test
    void testFinalizarVendaNaoIniciada() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            venda.finalizar();
        });
        assertEquals("venda não iniciada", exception.getMessage(), "Deve lançar exceção de venda não iniciada");
    }

    @Test
    void testVendaEncerrada() {
        venda.vender("Produto1", 10.0, 2);
        venda.finalizar();
        Exception exception = assertThrows(RuntimeException.class, () -> {
            venda.vender("Produto2", 5.0, 4);
        });
        assertEquals("venda encerrada", exception.getMessage(), "Deve lançar exceção de venda encerrada");
    }
}