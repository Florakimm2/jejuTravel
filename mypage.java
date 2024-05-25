// 5/25 이주원 (상단바 메인페이지처럼 추가)

package exam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class mypage extends JFrame {
    public mypage() {
        setTitle("mypage");
        setBounds(200, 200, 300, 250);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 832);

        createMenu(); // 상단바 함수 실행

        setVisible(true);
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JLabel leftLabel = new JLabel("myJeju");
        leftLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        menuBar.add(leftLabel);

        JMenuItem mainPageItem = new JMenuItem("mainpage");
        JMenuItem communityItem = new JMenuItem("community");

        mainPageItem.addActionListener(new mainPageActionListener());
        communityItem.addActionListener(new communityActionListener());

        menuBar.add(Box.createHorizontalGlue());

        menuBar.add(mainPageItem);
        menuBar.add(communityItem);

        setJMenuBar(menuBar);
    }

    private class mainPageActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new MainScreen();
            dispose();
        }
    }

    private class communityActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new community();
            dispose();
        }
    }
}

