// 5/24 이주원 (로그인 버튼 눌러도 다음 창으로 넘어가게 수정)
// 5/25 13:04 권희재 (디자인 수정 - 배경 색, 글자 색, 폰토, ID/PW 영어로)
// 5/25 17:44 김민경 (디자인 수정 - 입력창이 더 왼쪽으로 배치되도록 레이아웃 갈아엎음, 컴포넌트 전체적으로 크기 키우고 간격도 넓힘)

package exam;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.border.Border;

public class LoginScreen extends JFrame {

    public LoginScreen() {

        setTitle("myJEJU");

        JPanel title = new JPanel();
        JLabel login = new JLabel("My Jeju");
        login.setForeground(new Color(255, 255, 255));
        title.add(login);
        ////
        title.setBorder(BorderFactory.createEmptyBorder(200, 0, 30, 0)); // 20px top and bottom padding

        JPanel jp1 = new JPanel();
        jp1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 20, 20, 10); // Add padding
        gbc.fill = GridBagConstraints.BOTH;

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel jlb1 = new JLabel("ID : ", JLabel.CENTER);
        idPanel.add(jlb1);

        JPanel idPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField jtf1 = new JTextField(15);

        idPanel2.add(jtf1);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.WEST;
        jp1.add(idPanel, gbc);


        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        jp1.add(idPanel2, gbc);

        JPanel pwdPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JLabel jlb2 = new JLabel("PW: ", JLabel.CENTER);
        pwdPanel.add(jlb2);

        JPanel pwdPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPasswordField jtf2 = new JPasswordField(15);
        pwdPanel2.add(jtf2);



        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.WEST;
        jp1.add(pwdPanel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        jp1.add(pwdPanel2, gbc);


        JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton jLogin = new JButton("로그인");

        JPanel joinPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton join = new JButton("회원가입");

        loginPanel.add(jLogin); joinPanel.add(join);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        jp1.add(loginPanel, gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        jp1.add(joinPanel, gbc);

        pack();
        setLocationRelativeTo(null);

        JPanel jp2 = new JPanel();
        jp2.setLayout(new FlowLayout());
        jp2.add(jp1);
        /////
        jp2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40)); // Center align and add vertical padding


        setLayout(new BorderLayout());
        add(title, BorderLayout.NORTH);
        add(jp2, BorderLayout.CENTER);

        setBounds(100, 100, 40, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(1200, 830);

        title.setBackground(new Color(247, 125, 12)); // title 패널의 배경색 설정
        jp1.setBackground(new Color(247, 125, 12)); // jp1 패널의 배경색 설정
        idPanel.setBackground(new Color(247, 125, 12)); // idPanel 패널의 배경색 설정
        idPanel2.setBackground(new Color(247, 125, 12)); // idPanel2 패널의 배경색 설정
        pwdPanel.setBackground(new Color(247, 125, 12)); // pwdPanel 패널의 배경색 설정
        pwdPanel2.setBackground(new Color(247, 125, 12)); // pwdPanel2 패널의 배경색 설정
        loginPanel.setBackground(new Color(247, 125, 12)); // loginPanel 패널의 배경색 설정
        joinPanel.setBackground(new Color(247, 125, 12)); // joinPanel 패널의 배경색 설정
        jp2.setBackground(new Color(247, 125, 12)); // jp2 패널의 배경색 설정

        login.setFont(new Font("SansSerif", Font.BOLD, 40));
        jlb1.setFont(new Font("나눔스퀘어", Font.BOLD, 20));
        jlb2.setFont(new Font("나눔스퀘어", Font.BOLD, 20));
        jtf1.setFont(new Font("나눔스퀘어", Font.BOLD, 20));
        jtf2.setFont(new Font("나눔스퀘어", Font.BOLD, 20));
        jLogin.setFont(new Font("배달의민족 한나체 Air", Font.BOLD, 20));
        join.setFont(new Font("나눔스퀘어", Font.BOLD, 20));

        //배달의민족 한나체 Air Pro

        jtf1.setPreferredSize(new Dimension(200, 40));
        jtf2.setPreferredSize(new Dimension(200, 40));
        jLogin.setPreferredSize(new Dimension(140, 40));
        join.setPreferredSize(new Dimension(140, 40));




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
