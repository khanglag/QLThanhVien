/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author pc
 */
public class Controller {
    private JPanel root;
    private String kindSelected="";
    private List<BeanRegistry> listItem = null;
    
    public Controller(JPanel jpnRoot) {
        this.root = jpnRoot;
    }
    public void setView(JPanel jpnItem, JLabel jlbItem) throws SQLException{
        
    }
    class LabelEvent implements MouseListener{
        private JPanel node;
        private String kind;

        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent( String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            
//            switch (kind) {
//                case "Course":
//                {
//                    try {
//                        node = new CourseManager();
//                    } catch (SQLException ex) {
//                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                    break;
//
//                case "Person":
//                {
//                    try {
//                        node = new AddUser();
//                    } catch (SQLException ex) {
//                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                    break;
//
//                case "OfficeAssignment":
//                {
//                    try {
//                        node = new Assignment();
//                    } catch (SQLException ex) {
//                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                    break;
//
//                case "CourseInstructor":
//                    //node =  new CourseInstructor();
//                    break;
//                case "StudentGrade":
//                {
//                    try {
//                        node = new ManageGrade();
//                    } catch (SQLException ex) {
//                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                    break;
//
//                case "Department":
//                {
//                    try {
//                        node = new DepartmentForm();
//                    } catch (SQLException ex) {
//                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                    break;
//
//                // more
//                default:
//                    break;
//           }
           root.removeAll();
           root.setLayout(new BorderLayout());
           root.add(node);
           root.validate();
           root.repaint();
           setChangeBackGround(kind);
        }


         @Override
      public void mousePressed(MouseEvent e) {
           kindSelected = kind;
//           jpnItem.setBackground(new Color(0,0,0));
//           jlbItem.setBackground(new Color(0,0,0));
      }

      @Override
      public void mouseReleased(MouseEvent e) {
         
      }

      @Override
      public void mouseEntered(MouseEvent e) {
//          jpnItem.setBackground(new Color(38,84,108));
//          jlbItem.setBackground(new Color(38,84,108));
      }

      @Override
      public void mouseExited(MouseEvent e) {
          if (!kindSelected.equalsIgnoreCase(kind)) {
//                jpnItem.setBackground(new Color(67,138,174));
//                jlbItem.setBackground(new Color(67,138,174));
          }
      }
        
    }
    public void setEvent(List<BeanRegistry> listItem){
        this.listItem = listItem;
        for(BeanRegistry item: listItem){
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
    
        }
        
    }
     private void setChangeBackGround(String kind){
        for(BeanRegistry item: listItem){
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(38,84,108));
                item.getJlb().setBackground(new Color(38,84,108));
            } else{
                item.getJpn().setBackground(new Color(67,138,174));
                item.getJlb().setBackground(new Color(67,138,174));
            }
            
        }
        
    }
}
