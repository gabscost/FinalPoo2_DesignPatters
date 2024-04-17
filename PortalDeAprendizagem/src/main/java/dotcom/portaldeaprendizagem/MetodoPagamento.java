/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dotcom.portaldeaprendizagem;

/**
 *
 * @author Gabriel
 */
import Strategy.EstrategiaPagamento;
import Strategy.PagamentoBoleto;
import Strategy.PagamentoCartao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MetodoPagamento extends JFrame {
    private JRadioButton cartaoRadio;
    private JRadioButton boletoRadio;
    private JButton pagarButton;

    public MetodoPagamento(){
        super("Forma de Pagamento");

        // Configuração do layout
        setLayout(new GridLayout(3, 1));

        // Componentes da interface
        cartaoRadio = new JRadioButton("Cartão de Crédito");
        boletoRadio = new JRadioButton("Boleto Bancário");
        pagarButton = new JButton("Pagar");

        // Agrupando os botões de rádio para que apenas um possa ser selecionado
        ButtonGroup grupoBotoes = new ButtonGroup();
        grupoBotoes.add(cartaoRadio);
        grupoBotoes.add(boletoRadio);

        // Adicionando os componentes à janela
        add(cartaoRadio);
        add(boletoRadio);
        add(pagarButton);

        // Configurando o evento de clique para o botão "Pagar"
        pagarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pagar();
               setVisible(false);
 JOptionPane.showMessageDialog(rootPane, "Pagamento realizado com Sucesso!!");
            }
        });

        // Configuração da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setVisible(true);
    }

    private void pagar() {
        EstrategiaPagamento estrategia = null;
        if (cartaoRadio.isSelected()) {
            estrategia = new PagamentoCartao();
        } else if (boletoRadio.isSelected()) {
            estrategia = new PagamentoBoleto();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma forma de pagamento!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Simula um pagamento de R$ 100,00
        double valor = 100.00;
        estrategia.pagar(valor);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MetodoPagamento();
            }
        });
    }
}
