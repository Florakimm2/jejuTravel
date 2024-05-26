// 5/25 이주원 (상단바 메인페이지처럼 추가)
// 5/26 이현정 (상단바 수정)

package exam;

import java.awt.Color;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class mypage extends JFrame {
    public mypage() {
        setTitle("mypage");
        setBounds(200, 200, 300, 250);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 832);
        setBackground(Color.WHITE);

        createMenu(); // 상단바 함수 실행

        setVisible(true);
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JLabel leftLabel = new JLabel("myJeju");
        leftLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        leftLabel.setForeground(new Color(255, 255, 255));
        menuBar.add(leftLabel);

        JMenuItem myPageItem = new JMenuItem("mypage");
        JMenuItem communityItem = new JMenuItem("community");
        myPageItem.setBackground(new Color(247, 125, 12));
        myPageItem.setForeground(new Color(255, 255, 255));
        communityItem.setBackground(new Color(247, 125, 12));
        communityItem.setForeground(new Color(255, 255, 255));

        leftLabel.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		new MainScreen();
        	}
        });
        myPageItem.addActionListener(new myPageActionListener());
        communityItem.addActionListener(new communityActionListener());

        menuBar.add(Box.createHorizontalGlue());

        menuBar.add(myPageItem);
        menuBar.add(communityItem);
        menuBar.setBackground(new Color(247, 125, 12));

        setJMenuBar(menuBar);
    }

    private class myPageActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new mypage();
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
