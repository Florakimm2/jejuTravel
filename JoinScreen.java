// 5/24 이주원 (회원가입 창 크기도 동일하게 맞춤)
// 5/25 12:38 권희재 (디자인 수정 - 배경색, 글자색, 폰트 변경)

package exam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JoinScreen extends JFrame {

    String choice = null;
    
    public JoinScreen() {
        
        setTitle("myJEJU");
        
        // 1. 컴포넌트들을 만들어 보자.
        JLabel title = 
            new JLabel("회원가입", JLabel.CENTER);
        
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("나눔 스퀘어", Font.BOLD, 30));
        
        JButton join = new JButton("회원가입");
        JButton cancel = new JButton("취소");
        
        JTextField id = new JTextField(10);
        JPasswordField pwd = new JPasswordField(10);
        JTextField name = new JTextField(10);
        JTextField phone = new JTextField(10);
        
        JRadioButton client = new JRadioButton("고객");
        JRadioButton manager = new JRadioButton("관리자");
        JRadioButton etc = new JRadioButton("기타");
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(client); bg.add(manager); bg.add(etc);
        
        // radio panel
        JPanel radioPanel = new JPanel();
        radioPanel.add(client);
        radioPanel.add(manager);
        radioPanel.add(etc);
        
        // form panel
        JPanel idPanel = new JPanel();
        idPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        idPanel.add(new JLabel("아이디 : "));
        idPanel.add(id);
        
        
        JPanel pwdPanel = new JPanel();
        pwdPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        pwdPanel.add(new JLabel("비밀번호 : "));
        pwdPanel.add(pwd);
        
        
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        namePanel.add(new JLabel("이    름 : "));
        namePanel.add(name);
        
        
        JPanel phonePanel = new JPanel();
        phonePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        phonePanel.add(new JLabel("연 락 처 : "));
        phonePanel.add(phone);
        
        
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 1));
        formPanel.add(idPanel);
        formPanel.add(pwdPanel);
        formPanel.add(namePanel);
        formPanel.add(phonePanel);
        
        // radio + form panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout());
        contentPanel.add(radioPanel);
        contentPanel.add(formPanel);
        
        // button panel
        JPanel panel = new JPanel();
        panel.add(join);
        panel.add(cancel);
        
        
        add(title, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        
        
        setSize(1280, 830);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
        
        radioPanel.setBackground(new Color(230, 121, 0));
        idPanel.setBackground(new Color(230, 121, 0));
        pwdPanel.setBackground(new Color(230, 121, 0));
        namePanel.setBackground(new Color(230, 121, 0));
        phonePanel.setBackground(new Color(230, 121, 0));
        formPanel.setBackground(new Color(230, 121, 0));
        contentPanel.setBackground(new Color(230, 121, 0));
        panel.setBackground(new Color(230, 121, 0));
        getContentPane().setBackground(new Color(230, 121, 0));

        
        
        // 이벤트 처리
        join.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String myId = id.getText();
                String myPwd = new String(pwd.getPassword());
                String myName = name.getText();
                String myPhone = phone.getText();
                
                if(client.isSelected()) {
                    choice = client.getText();
                }else if(manager.isSelected()) {
                    choice = manager.getText();
                }else if(etc.isSelected()) {
                    choice = etc.getText();
                }
                
                // 회원가입이 성공했을 때
                // 메인 화면을 열고 현재 창을 닫습니다.
                new MainScreen();
                dispose();
            }
        });
        
        
        // 취소 버튼을 클릭했을 때 이벤트 처리
        cancel.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                new LoginScreen();
                dispose();
                
            }
        });
    }
}
