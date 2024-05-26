// 5/24 이주원 (회원가입 창 크기도 동일하게 맞춤)
// 5/25 13:02 권희재 (디자인 수정 - 배경색, 글자색, 폰트 변경)
// 5/27 00:14 김민경 (성별 선택 라이오박스 생성, 레이아웃 살짝 변형-emptypanel, 이벤틑 같이 추가함)

package exam;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.KeyRep;

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

        JRadioButton boy = new JRadioButton("남자");
        JRadioButton girl = new JRadioButton("여자");
        JRadioButton etc = new JRadioButton("기타성별");

        ButtonGroup bg = new ButtonGroup();
        bg.add(client); bg.add(manager);

        ButtonGroup gender = new ButtonGroup();
        gender.add(boy); gender.add(girl); gender.add(etc);

        // radio panel
        JPanel radioPanel = new JPanel();
        radioPanel.add(client);
        radioPanel.add(manager);

        JPanel radioPanel2 = new JPanel();
        radioPanel2.add(boy);
        radioPanel2.add(girl);
        radioPanel2.add(etc);

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

        JPanel emptypanel = new JPanel();

        JPanel radioformPanel = new JPanel();
        radioformPanel.setLayout(new GridLayout(3, 1));
        radioformPanel.add(radioPanel);
        radioformPanel.add(emptypanel);
        radioformPanel.add(radioPanel2);

        // radio + form panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout());
        contentPanel.add(radioformPanel);
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

        //배경색 설정
        radioPanel.setBackground(new Color(247, 125, 12));
        radioPanel2.setBackground(new Color(247, 125, 12));
        emptypanel.setBackground(new Color(247, 125, 12));
        idPanel.setBackground(new Color(247, 125, 12));
        pwdPanel.setBackground(new Color(247, 125, 12));
        namePanel.setBackground(new Color(247, 125, 12));
        phonePanel.setBackground(new Color(247, 125, 12));
        formPanel.setBackground(new Color(247, 125, 12));
        contentPanel.setBackground(new Color(247, 125, 12));
        panel.setBackground(new Color(247, 125, 12));
        getContentPane().setBackground(new Color(247, 125, 12));




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
                }

                if(boy.isSelected()) {
                    choice = boy.getText();
                }else if(girl.isSelected()) {
                    choice = girl.getText();
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
