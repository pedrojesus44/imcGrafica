/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package imcgrafica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Admin
 */
public class IMC extends JFrame {
    
    JLabel titulo, rotulo1, rotulo2, exibir;
    JTextField texto1, texto2;
    JButton calcular, limpar;
    
    public IMC() {
        super("Calcular IMC");
        Container tela = getContentPane();
        setLayout(null);
        titulo = new JLabel("Digite os dados: ");
        rotulo1 = new JLabel("Peso: ");
        rotulo2 = new JLabel("Altura: ");
        texto1 = new JTextField(5);
        texto2 = new JTextField(5);
        calcular = new JButton("Calcular");
        exibir = new JLabel("");
        limpar = new JButton("Limpar");
        
        titulo.setBounds(50,20,100,20); rotulo1.setBounds(50,60,100,20);
        rotulo2.setBounds(50, 100, 100, 20); texto1.setBounds(90, 60, 100, 20);
        texto2.setBounds(95, 100, 100, 20); exibir.setBounds(50, 150, 300, 20); 
        calcular.setBounds(130, 300, 120, 20); limpar.setBounds(130, 330, 120, 20);
        
        calcular.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    double peso, altura, res;
                    res = 0;
                    peso = Double.parseDouble(texto1.getText());
                    altura = Double.parseDouble(texto2.getText());
                    res = peso / (altura * altura);
                    double ps = Math.round(res*100.0)/100.0;
                    if (ps < 18) {
                        exibir.setVisible(true);
                        exibir.setText("O seu IMC é de: " + ps + " e você está abaixo do peso.");
                    }
                    else if ((ps >= 18.5) && (ps <= 29.99)) {
                        exibir.setVisible(true);
                        exibir.setText("O seu IMC é de: " + ps + " e você está no seu peso ideal.");
                    }
                    else if (ps >= 25) {
                        exibir.setVisible(true);
                        exibir.setText("O seu IMC é de: " + ps + " e você está acima do peso.");
                    }
                    else {
                        exibir.setVisible(true);
                        exibir.setText("Inválido!");
                    }
                    
                }
            });
        limpar.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        texto1.setText(null);
                        texto2.setText(null);
                        exibir.setText(null);
                        texto1.requestFocus();
                    }
                }
            );
        exibir.setVisible(false);
        
        tela.add(titulo); tela.add(rotulo1);
        tela.add(texto1); tela.add(texto2);
        tela.add(rotulo2); tela.add(exibir); 
        tela.add(calcular); tela.add(limpar);
        
        setSize(400, 500);
        setVisible(true);
    }
}


