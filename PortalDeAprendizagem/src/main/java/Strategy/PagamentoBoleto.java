/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strategy;

/**
 *
 * @author Gabriel
 */
public class PagamentoBoleto implements EstrategiaPagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$ " + valor + " realizado com boleto bancário.");
    }
}
