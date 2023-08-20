
package com.jbrod.parserpy.app.analizer;

import com.jbrod.parserpy.app.analizer.lexicon.Analizer;
import com.jbrod.parserpy.app.analizer.lexicon.Token;
import com.jbrod.parserpy.app.analizer.lexicon.TokenPlotter;
import com.jbrod.parserpy.ui.GraphViewer;
import com.jbrod.parserpy.ui.PrincipalFrame;
import com.jbrod.parserpy.ui.ReportViewer;
import com.jbrod.parserpy.ui.TextEditor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase principal.
 * @author Jorge
 */
public class MainClass {

    //Elementos graficos
    private TextEditor textEditor; 
    private GraphViewer graphViewer;
    private ReportViewer reportViewer; 
    
    private PrincipalFrame principalFrame; 
    
    //Analizador
    private Analizer lexiconAnalizer;
    
    public MainClass(){
        principalFrame  = new PrincipalFrame(); 
        
        textEditor      = new TextEditor    (); 
        graphViewer     = new GraphViewer   (); 
        reportViewer    = new ReportViewer  (); 
        
        lexiconAnalizer = new Analizer(); 
        
    }
    
    public void assignRel(){
        principalFrame.setMainClass(this);
        textEditor    .setMainClass(this);
        graphViewer   .setMainClass(this);
        reportViewer  .setMainClass(this);
        
        principalFrame.addPanel(textEditor, "Editor de texto");
        principalFrame.addPanel(graphViewer, "Visor de grafos");
        principalFrame.addPanel(reportViewer, "Visor de reportes");
    }
    
    public void analize(){
        String inputToAnalize; 
        inputToAnalize = textEditor.getInputToAnalize();
        
        lexiconAnalizer.searchMatches(inputToAnalize);
        lexiconAnalizer.generateAnalysisReport();
        reportViewer.addReport(lexiconAnalizer.getReport());
        
        
        //------------------ Agregar grafos ----------------
        graphViewer.clearGraphs();
        
        
        List<Token> lsToken = lexiconAnalizer.getListToken();
        TokenPlotter tokenPlotter = new TokenPlotter();
        tokenPlotter.removeAllPlots();
        for (int i = 0; i < lsToken.size(); i ++) {
            tokenPlotter.plot(lsToken.get(i), i + "_Plot");
            
        }
        
        
        
        /*
        TokenPlotter tokenPlotter = new TokenPlotter();
        for (int i = 0; i < lsToken.size(); i++) {
            
            try {
                tokenPlotter.plot(lsToken.get(i), "Plot");
                Thread.sleep(2000);
                graphViewer.addGraph("Plot.png");
            } catch (InterruptedException ex) {
                Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }*/
        
        
        
    }
    
}
