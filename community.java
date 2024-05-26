// 5/25 이주원 (상단바 메인페이지처럼 추가)
// 5/26 이현정 (상단바 수정)
// 5/27 이주원 (미완 - 글 올려보기 기능 추가)

package exam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class community extends JFrame {
    private JTextArea postTextArea;
    private DefaultListModel<String> postListModel;
    private JList<String> postList;

    public community() {
        setTitle("Community");
        setSize(1280, 830); // 창 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        createMenu(); // 상단바 생성

        // 여행 후기를 올리는 텍스트 영역과 버튼
        postTextArea = new JTextArea(5, 30);
        postTextArea.setLineWrap(true);
        JScrollPane postScrollPane = new JScrollPane(postTextArea);
        JButton postButton = new JButton("등록");
        postButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String post = postTextArea.getText();
                if (!post.isEmpty()) {
                    postListModel.addElement(post);
                    postTextArea.setText("");
                } else {
                    JOptionPane.showMessageDialog(community.this, "한 글자 이상 작성하세요", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel postPanel = new JPanel(new BorderLayout());
        postPanel.add(new JLabel("여행 후기 :"), BorderLayout.NORTH);
        postPanel.add(postScrollPane, BorderLayout.CENTER);
        postPanel.add(postButton, BorderLayout.SOUTH);

        // 후기 목록
        postListModel = new DefaultListModel<>();
        postList = new JList<>(postListModel);
        postList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(postList);

        postList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // 더블 클릭 시
                    String selectedPost = postList.getSelectedValue();
                    if (selectedPost != null) {
                        JFrame detailFrame = new NextPage(selectedPost, "", null);
                        detailFrame.setVisible(true);
                    }
                }
            }
        });

        add(postPanel, BorderLayout.NORTH);
        add(listScrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();

        JLabel leftLabel = new JLabel("myJeju");
        leftLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        leftLabel.setForeground(new Color(255, 255, 255));
        menuBar.add(leftLabel);

        JMenuItem myPageItem = new JMenuItem("My Page");
        JMenuItem communityItem = new JMenuItem("Community");
        myPageItem.setBackground(new Color(247, 125, 12));
        myPageItem.setForeground(new Color(255, 255, 255));
        communityItem.setBackground(new Color(247, 125, 12));
        communityItem.setForeground(new Color(255, 255, 255));

        leftLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new MainScreen();
                dispose();
            }
        });
        myPageItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new mypage();
                dispose();
            }
        });
        communityItem.setEnabled(false); // 현재 페이지이므로 비활성화

        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(myPageItem);
        menuBar.add(communityItem);
        menuBar.setBackground(new Color(247, 125, 12));

        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new community();
            }
        });
    }
}
