package bluetop_nms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: bluetop</p>
 * @author carrett
 * @version 1.0
 */
//添加设备窗体
public class AddDeviceDialog
    extends JDialog
    implements ActionListener, MouseListener {
  FontType font;
  JLabel DeviceNameLabel, DeviceIPLabel, InputNumberLabel;
  JTextField DeviceNameText, DeviceIPText, InputNumberText;
  JButton okButton, cancelButton;
  JPanel addDevicePanel;
  String Title;
  ImageIcon imgOk1,imgOk2,imgOk3;
  ImageIcon imgCancel1,imgCancel2,imgCancel3;
  ImageIcon sysImg;

  public AddDeviceDialog() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void jbInit() throws Exception {
    Title = new String("添加设备");
    addDevicePanel = new JPanel();
//    addDevicePanel.setBackground(font.BACK_COLOR);
    addDevicePanel.setLayout(null);
    //addDevicePanel.setBackground(font.BACK_COLOR);
    addDevicePanel.setBorder(new TitledBorder(new EtchedBorder(), "添加设备信息",
                                              TitledBorder.
                                              DEFAULT_JUSTIFICATION,
                                              TitledBorder.DEFAULT_POSITION,
                                              new Font("宋体", Font.PLAIN,12),
                                              Color.BLACK));
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    DeviceNameLabel = new JLabel("用户名 :");
    DeviceNameLabel.setFont(font.TextFont);
    DeviceNameLabel.setBounds(new Rectangle(20, 20, 80, 20));
//    DeviceNameLabel.setForeground(font.TextForeColor);
    DeviceIPLabel = new JLabel("设备IP :");
    DeviceIPLabel.setFont(font.TextFont);
    DeviceIPLabel.setBounds(new Rectangle(20, 50, 80, 20));
//    DeviceIPLabel.setForeground(font.TextForeColor);
    InputNumberLabel = new JLabel("端口号 :");
    InputNumberLabel.setFont(font.TextFont);
    InputNumberLabel.setBounds(new Rectangle(20, 80, 80, 20));
//    InputNumberLabel.setForeground(font.TextForeColor);
    InputNumberLabel.setEnabled(false); //
    DeviceNameText = new JTextField("北京");
    DeviceNameText.setFont(font.TextFont);
    DeviceNameText.setBounds(new Rectangle(110, 20, 100, 20));
//    DeviceNameText.setForeground(font.TextForeColor);
    DeviceNameText.addKeyListener(new KeyListener() {
      public void keyPressed(KeyEvent event) {}

      public void keyReleased(KeyEvent event) {}

      public void keyTyped(KeyEvent event) {
        char keyChar = event.getKeyChar();
        keyChar = Character.toLowerCase(keyChar);
        if (keyChar == KeyEvent.VK_ENTER) {
          isTextFieldEmpty();
          addValueOver();
        }
      }
    });
    DeviceIPText = new JTextField("192.168.3.21");
    DeviceIPText.setFont(font.TextFont);
    DeviceIPText.setBounds(new Rectangle(110, 50, 100, 20));
//    DeviceIPText.setForeground(font.TextForeColor);
    DeviceIPText.addKeyListener(new KeyListener() {
      public void keyPressed(KeyEvent event) {}

      public void keyReleased(KeyEvent event) {}

      public void keyTyped(KeyEvent event) {
        char keyChar = event.getKeyChar();
        keyChar = Character.toLowerCase(keyChar);
        if (keyChar == KeyEvent.VK_ENTER) {
          isTextFieldEmpty();
          addValueOver();
        }
      }
    });
    InputNumberText = new JTextField();
    InputNumberText.setFont(font.TextFont);
    InputNumberText.setBounds(new Rectangle(110, 80, 100, 20));
//    InputNumberText.setForeground(font.BACK_COLOR);
    InputNumberText.setEnabled(false); //
    InputNumberText.addKeyListener(new KeyListener() {
      public void keyPressed(KeyEvent event) {}

      public void keyReleased(KeyEvent event) {}

      public void keyTyped(KeyEvent event) {
        char keyChar = event.getKeyChar();
        keyChar = Character.toLowerCase(keyChar);
        if (keyChar == KeyEvent.VK_ENTER) {
          isTextFieldEmpty();
          addValueOver();
        }
      }
    });
    imgOk1 = new ImageIcon("image/ok1.jpg");
    imgOk2 = new ImageIcon("image/ok2.jpg");
    imgOk3 = new ImageIcon("image/ok3.jpg");
    imgCancel1 = new ImageIcon("image/cancel1.jpg");
    imgCancel2 = new ImageIcon("image/cancel2.jpg");
    imgCancel3 = new ImageIcon("image/cancel3.jpg");
    okButton = new JButton();
    okButton.setIcon(imgOk1);
    okButton.setBorderPainted(false);
    okButton.setMnemonic('O');
    okButton.setFont(font.TextFont);
    //OkButton.setBackground(font.BACK_COLOR);
//    okButton.setForeground(font.TextForeColor);
    okButton.setBounds(new Rectangle(36, 120, imgOk1.getIconWidth(),imgOk1.getIconHeight()));
    okButton.addActionListener(this);
    okButton.addMouseListener(this);

    cancelButton = new JButton();
    cancelButton.setIcon(imgCancel1);
    cancelButton.setBorderPainted(false);
    cancelButton.setMnemonic('C');
    cancelButton.setFont(font.TextFont);
//    cancelButton.setForeground(font.TextForeColor);
    cancelButton.setBounds(new Rectangle(120, 120, imgCancel1.getIconWidth(),imgCancel1.getIconHeight()));
    cancelButton.addActionListener(this);
    cancelButton.addMouseListener(this);

    addDevicePanel.add(DeviceNameLabel);
    addDevicePanel.add(DeviceIPLabel);
    addDevicePanel.add(InputNumberLabel);
    addDevicePanel.add(DeviceNameText);
    addDevicePanel.add(DeviceIPText);
    addDevicePanel.add(InputNumberText);
    addDevicePanel.add(cancelButton);
    addDevicePanel.add(okButton);
    sysImg = new ImageIcon("image/system.jpg");


    this.setTitle(Title);
    this.getContentPane().add(addDevicePanel);
//    this.setBackground(font.BACK_COLOR);

  }

  public void isTextFieldEmpty() {
    if (DeviceNameText.getText() == "") {
      JOptionPane.showMessageDialog(null, "请输入设备名称!");
      DeviceNameText.setFocusable(true);
    }
    if (DeviceIPText.getText().equalsIgnoreCase("")) {
      JOptionPane.showMessageDialog(null, "请输入IP地址！");
      DeviceIPText.setFocusable(true);
    }
    if (InputNumberText.getText() == "") {
      JOptionPane.showMessageDialog(null, "请输入设备输入口号!");
      InputNumberText.setFocusable(true);
    }
  }

  public void addValueOver() {
    addDevice(DeviceNameText.getText(), DeviceIPText.getText(),
              InputNumberText.getText());
    dispose();
  }

  public void addDevice(String name, String deviceIP, String inputNumber) {
    Application_NMS.magInfo.AddDev(deviceIP, 5055, 0, name);
    NMS_Main.m_devicepanel.updateDevicePanel(Application_NMS.magInfo,
                                             Application_NMS.cDevList);
    NMS_Main.m_statuspanel.updateStatusPanel(Application_NMS.magInfo,
                                             Application_NMS.cDevList);
  }

  protected void processWindowEvent(WindowEvent e) {
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      cancel();
    }
    super.processWindowEvent(e);
  }

  //Close the dialog
  void cancel() {
    dispose();
  }

  //Close the dialog on a button event
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == okButton) {
      isTextFieldEmpty();
      addValueOver();
    }
    if (e.getSource() == cancelButton) {
      cancel();
    }
  }
  public void mouseExited( MouseEvent mouseEvent ){
    if(mouseEvent.getSource() == okButton){
      okButton.setIcon(imgOk1);
    }
    if(mouseEvent.getSource() ==cancelButton){
      cancelButton.setIcon(imgCancel1);
    }

  }
  public void mouseClicked(MouseEvent mouseEvent) {
    if (mouseEvent.getClickCount() > 0) {
      if(mouseEvent.getSource() == okButton){
        okButton.setIcon(imgOk3);
      }
      if(mouseEvent.getSource() == cancelButton){
        cancelButton.setIcon(imgCancel3);
      }
    }
  }
  public void mouseEntered(MouseEvent mouseEvent) {
    if(mouseEvent.getSource() == okButton){
      okButton.setIcon(imgOk2);
    }
    if(mouseEvent.getSource() ==cancelButton){
      cancelButton.setIcon(imgCancel2);
    }
  }
  public void mouseReleased( MouseEvent mouseEvent ){

  }
  public void mousePressed( MouseEvent mouseEvent ){
    if(mouseEvent.getSource() == okButton){
        okButton.setIcon(imgOk3);
      }
      if(mouseEvent.getSource() == cancelButton){
        cancelButton.setIcon(imgCancel3);
      }
  }
}
