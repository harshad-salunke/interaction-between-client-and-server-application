
//@author HARSHAD SALUNKE

package chatting.application;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.swing.*;
import java.net.*;
/**
 *
 * @author Harshad
 */
public class Server  extends JFrame implements ActionListener{
    JPanel p1;
static JTextField textField;
    JButton button;
    JScrollPane scrollPane;
static JTextArea textArea;
 static ServerSocket stk;
  static Socket st;
  static DataInputStream in;
  static DataOutputStream outstrem;
    public Server() throws HeadlessException {
        p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(7,94,84));
        p1.setBounds(0, 0, 450, 70);
        add(p1);
        
        textArea=new JTextArea();
        textArea.setBounds(5, 75, 420, 510);
        textArea.setFont(new Font("SAN_SERIF",Font.PLAIN,18));
        textArea.setForeground(Color.gray);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
textArea.setWrapStyleWord(true);
        add(textArea);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("chatting/application/Icons/3.png"));
        Image i2=i1.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT );
        ImageIcon arrow=new ImageIcon(i2);
        JLabel l1=new JLabel(arrow);
        setLayout(null);
        l1.setBounds(5,20,30,30);
        l1.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent me){
            System.exit(0);
        }
        });
        p1.add(l1);
        
         ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("chatting/application/Icons/user1.png"));
        Image i5=i4.getImage().getScaledInstance(70, 70,Image.SCALE_DEFAULT );
        ImageIcon userImage=new ImageIcon(i5);
        JLabel l2=new JLabel(userImage);
        setLayout(null);
        l2.setBounds(50,5,60,60);
       
        p1.add(l2);
        
        JLabel name=new JLabel("Harshad ");
        name.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        name.setForeground(Color.WHITE);
        name.setBounds(120,10,100,18);
        p1.add(name);
        
        JLabel active=new JLabel("Active Now");
        active.setFont(new Font("SAN_SERIF",Font.PLAIN,13));
        active.setForeground(Color.WHITE);
        active.setBounds(120,33,100,10);
        p1.add(active);
        
        ImageIcon vidIcon= new ImageIcon(ClassLoader.getSystemResource("chatting/application/Icons/video.png"));
        Image vidImage=vidIcon.getImage().getScaledInstance(30, 30,Image.SCALE_DEFAULT );
        ImageIcon video=new ImageIcon(vidImage);
        JLabel videolaJLabel=new JLabel(video);
        setLayout(null);
        videolaJLabel.setBounds(290,22,50,20);
        p1.add(videolaJLabel);
//        
         ImageIcon phon= new ImageIcon(ClassLoader.getSystemResource("chatting/application/Icons/phone.png"));
        Image phoImage=phon.getImage().getScaledInstance(30,30 ,Image.SCALE_DEFAULT );
        ImageIcon phoneIcon=new ImageIcon(phoImage);
        JLabel phoneL=new JLabel(phoneIcon);
        setLayout(null);
        phoneL.setBounds(350,10,30,50);
        p1.add(phoneL);
//        
        
        ImageIcon menu= new ImageIcon(ClassLoader.getSystemResource("chatting/application/Icons/3icon.png"));
        Image menuImage=menu.getImage().getScaledInstance(13, 20,Image.SCALE_DEFAULT );
        ImageIcon menuIcon=new ImageIcon(menuImage);
        JLabel menuL=new JLabel(menuIcon);
        setLayout(null);
        menuL.setBounds(400,20,13,25);
        p1.add(menuL);
        
        textField=new JTextField();
        textField.setBounds(5, 600, 310, 40);
        textField.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        add(textField);
        
        button=new JButton("Send");
        button.setBounds(330, 600, 70, 40);
        button.setBackground(new Color(7,94,84));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("SAN_SERIF",Font.BOLD,14));
        add(button);
        
        button.addActionListener(this);
        setSize(450,700);
        setLocation(150,5);
        setVisible(true);
    }
    
       @Override
    public void actionPerformed(ActionEvent e) {
    String text = textField.getText();
        try {
            if (!text.equals("")) {
                textArea.append("\n\t\t\t" + text);
                textField.setText("");

                outstrem.writeUTF(text);
                textField.setText("");
            }
        } catch (Exception ex) {
        }                                                  
     
    }
    
    public static void main(String [] args){
        new Server().setVisible(true);
        String msgin="";
        try {
            stk=new ServerSocket(6001);
            st=stk.accept();
            in = new DataInputStream(st.getInputStream());
            outstrem = new DataOutputStream(st.getOutputStream());
            while(true){
            msgin = in.readUTF();
            textArea.append("\n     "+msgin);
            }
           
        } catch (Exception e) {
        }
    }

 


    
}
