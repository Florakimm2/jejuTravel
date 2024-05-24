# 5/24 이주원 (로그인 버튼 눌러도 다음 창으로 넘어가게 수정)

package exam;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginScreen extends JFrame {

    public LoginScreen() {
        
        setTitle("myJEJU");
        
        JPanel title = new JPanel();
        JLabel login = new JLabel("My Jeju");
        login.setForeground(new Color(5, 0, 153));
        login.setFont(new Font("맑은고딕", Font.BOLD, 25));
        title.add(login);
        
        JPanel jp1 = new JPanel();
        jp1.setLayout(new GridLayout(3, 2));
        
        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel jlb1 = new JLabel("아이디 : ", JLabel.CENTER);
        idPanel.add(jlb1);
        
        JPanel idPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField jtf1 = new JTextField(10);
        idPanel2.add(jtf1);
        
        jp1.add(idPanel); jp1.add(idPanel2);
        
        JPanel pwdPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel jlb2 = new JLabel("비밀번호 : ", JLabel.CENTER);
        pwdPanel.add(jlb2); 
        
        JPanel pwdPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPasswordField jtf2 = new JPasswordField(10);
        pwdPanel2.add(jtf2);
        
        jp1.add(pwdPanel); jp1.add(pwdPanel2);
        
        JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton jLogin = new JButton("로그인");
        
        JPanel joinPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton join = new JButton("회원가입");
        
        loginPanel.add(jLogin); joinPanel.add(join);
        jp1.add(loginPanel); jp1.add(joinPanel);
        
        JPanel jp2 = new JPanel();
        jp2.setLayout(new FlowLayout());
        jp2.add(jp1);
        
        setLayout(new BorderLayout());
        add(title, BorderLayout.NORTH);
        add(jp2, BorderLayout.CENTER);
        
        setBounds(200, 200, 300, 250);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1280, 832);
        
        // 로그인 버튼에 대한 ActionListener 설정
        jLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 아이디와 비밀번호를 가져옴
                String myId = jtf1.getText();
                String myPwd = new String(jtf2.getPassword());
                
                // 로그인 성공 여부를 간단히 확인 (임시로 항상 로그인 성공으로 가정)
                boolean loginSuccess = true; 
                
                if (loginSuccess) {
                    // 로그인 성공 시 메인 화면으로 이동
                    new MainScreen();
                    dispose(); // 로그인 화면 닫기
                } else {
                    // 로그인 실패 시 메시지 표시
                    JOptionPane.showMessageDialog(null, "로그인에 실패했습니다. 다시 시도해주세요.");
                }
            }
        });
        
        // 회원가입 버튼에 대한 ActionListener 설정
        join.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 회원가입 화면으로 이동
                new JoinScreen();
                dispose(); // 현재 창 닫기
            }
        });
    }
}
