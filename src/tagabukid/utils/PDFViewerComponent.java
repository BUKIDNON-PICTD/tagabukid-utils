/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package tagabukid.utils;

import com.rameses.rcp.common.MsgBox;
import com.rameses.rcp.common.PropertySupport;
import com.rameses.rcp.framework.Binding;
import com.rameses.rcp.ui.UIControl;
import com.rameses.rcp.util.UIControlUtil;
import java.awt.BorderLayout;
import java.io.InputStream;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import com.rameses.rcp.common.DocViewModel;

/**
 *
 * @author rufino
 */
public class PDFViewerComponent extends JPanel implements UIControl {
    private Binding binding;
    private String[] depends;
    private int index;
    private int stretchWidth;
    private int stretchHeight;
    /**
     * Creates new form PDFViewerComponent
     */
    
    private JPanel viewerComponentPanel = new JPanel();
    private SwingController controller = new SwingController();
    private final JPanel panel = new JPanel(new BorderLayout());
    private DocViewModel docModel;
    
    public PDFViewerComponent() {
        initComponents();
        //String filePath = "C:\\Users\\rufino\\Desktop\\training.pdf";
        createViewer();
        
        //kani dayon siya is ako siya gi butang sa jpanel
        
        panel.add(viewerComponentPanel, BorderLayout.CENTER);
        setLayout(new BorderLayout());
        add(panel, BorderLayout.CENTER);
//        controller.openDocument(filePath);
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void createViewer(){
        SwingViewBuilder factory = new SwingViewBuilder(controller);
        viewerComponentPanel = factory.buildViewerPanel();
        ComponentKeyBinding.install(controller, viewerComponentPanel);
        controller.getDocumentViewController().setAnnotationCallback(
                new org.icepdf.ri.common.MyAnnotationCallback(
                        controller.getDocumentViewController()));
        
        //bali mao ni ang pag himo niya sa katong viewer
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    
    @Override
    public void load() {
        
    }
    
    
    @Override
    public void refresh() {
        //kani diri mao ni ang binding niya 
        //ang mahitabo kay gikan sa controller kani iya tawagon
        //after niya mag initilize
        //after ma init sa constructor niya diritso siya diri
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                getPDF();
            }
        });
    }
    
    private void getPDF(){
//         DocViewModel newModel = null;
        try{
            
            //kani mao ni ang binding
            //UIControlUtil.getBeanValue(this); kani mao ni ang katong value nga gi pasa gikan sa controller
            
            Object value = UIControlUtil.getBeanValue(this);
            controller.openDocument(value.toString()); //then gamiton nako ang value i.bahog sa ako gi himo nga component
        }
        catch (Exception ex)
        {
            //MsgBox.err(ex);
        }
    }
    
    @Override
    public Binding getBinding() {
        return this.binding; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void setBinding(Binding binding) {
        this.binding = binding; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public String[] getDepends() {
        return this.depends = depends; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public int getIndex() {
        return this.index = index; //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setPropertyInfo(PropertySupport.PropertyInfo info) {
        
    }
    
    
    public int getStretchWidth() {
        return this.stretchWidth; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void setStretchWidth(int stretchWidth) {
        this.stretchWidth = stretchWidth; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public int getStretchHeight() {
        return this.stretchHeight; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public void setStretchHeight(int stretchHeight) {
        this.stretchHeight = stretchHeight; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public int compareTo(Object o) {
        return UIControlUtil.compare(this, o); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getVisibleWhen() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setVisibleWhen(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}