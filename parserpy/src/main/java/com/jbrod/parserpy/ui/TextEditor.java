/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.jbrod.parserpy.ui;

import com.jbrod.parserpy.app.analizer.MainClasss;
import com.jbrod.parserpy.app.analizer.lexicon.TokenTypeEnum;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author Jorge
 */
public class TextEditor extends javax.swing.JPanel {

    private MainClasss mainClass; 
    
    //para estilos
    private StyledDocument styledDocument;
    
    Style defaultStyle, blueStyle, purpleStyle, redStyle, greyStyle, greenStyle, orangeStyle; 
    
    
    
    /**
     * Creates new form TextEditor
     */
    public TextEditor() {
        initComponents();
        styledDocument = textPaneCode.getStyledDocument();
        defaultStyle = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
        
        blueStyle = styledDocument.addStyle("Blue", defaultStyle);
        StyleConstants.setForeground(blueStyle, Color.BLUE);
        
        purpleStyle = styledDocument.addStyle("Purple", defaultStyle);
        StyleConstants.setForeground(purpleStyle, Color.MAGENTA);
        
        redStyle = styledDocument.addStyle("Red", defaultStyle);
        StyleConstants.setForeground(redStyle, Color.RED);
        
        greyStyle = styledDocument.addStyle("Grey", defaultStyle);
        StyleConstants.setForeground(greyStyle, Color.GRAY);
        
        greenStyle = styledDocument.addStyle("Green", defaultStyle);
        StyleConstants.setForeground(greenStyle, Color.GREEN);
        
        orangeStyle = styledDocument.addStyle("Orange", defaultStyle);
        StyleConstants.setForeground(orangeStyle, Color.ORANGE);
        
    }
    
    /**
     * Agrega un texto indicado al text editor en base a un color.
     * @param text: texto a insertar.
     * @param color: 1. normal | 2. Azul | 3. Morado | 4. Rojo | 5. Gris | 6. Verde | def Naranja
     **/
    public void addText(String text, String tokenType){
        int i = 0; 
        
        if(tokenType.equals(TokenTypeEnum.IDENTIFIER.toString())){
            i = 1; 
        }else if(tokenType.equals(TokenTypeEnum.ARITHMETIC.toString()) || tokenType.equals(TokenTypeEnum.LOGICAL.toString()) || tokenType.equals(TokenTypeEnum.ASSIGNAMENT.toString())){
            i = 2;
        }else if(tokenType.equals(TokenTypeEnum.KEYWORD.toString())){
            i = 3;
        }else if(tokenType.equals(TokenTypeEnum.CONSTANT.toString())){
            i = 4;
        }else if(tokenType.equals(TokenTypeEnum.COMMENT)){
            i = 5;
        }else if(tokenType.equals(TokenTypeEnum.OTHERS.toString())){
            i = 6;
        }else{
            i = -1; 
        }
          
        addText(text, i);
    }
    public void addText(String text, int color){

        Style toUse = switch (color) {
            case  1 -> defaultStyle ;
            case  2 -> blueStyle    ;
            case  3 -> purpleStyle  ; 
            case  4 -> redStyle     ;
            case  5 -> greyStyle    ; 
            case  6 -> greenStyle   ; 
            default -> orangeStyle  ;
        };
        try {
            styledDocument.insertString(styledDocument.getLength(),text, toUse);
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    public StyledDocument getStyledDocument(){
        StyledDocument doc =  textPaneCode.getStyledDocument();
        return doc; 
    }
    
    public void setMainClass(MainClasss mainClass) {
        this.mainClass = mainClass;
    }
    
    public String getInputToAnalize(){
        return textPaneCode.getText();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textPaneCode = new javax.swing.JTextPane();

        jScrollPane1.setViewportView(textPaneCode);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane textPaneCode;
    // End of variables declaration//GEN-END:variables

    public void setText(String read) {
       textPaneCode.setText(read);
    }
}