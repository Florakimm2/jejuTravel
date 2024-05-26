// 5/25 이주원 (상단바 메인페이지처럼 추가)
// 5/26 이현정 (상단바 수정)
// 5/27 이주원 (여행 일정표 삽입)

package exam;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mypage extends JFrame {
    private DefaultTableModel model;
    private JTable table;
    private JTextField dateField, placeField, memoField;

    public mypage() {
        setTitle("My Page");
        setSize(1280, 832);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createMenu(); // 상단바 생성
        createScheduleTable(); // 여행 일정 테이블 생성
        createEditPanel(); // 수정 패널 생성

        setVisible(true);
    }

    private void createMenu() {
        // 메뉴 생성 코드
    }

    private void createScheduleTable() {
        String[] columns = {"날짜", "장소", "메모"};
        Object[][] data = {
                {"2024-05-28", "카페 바다다", "아메리카노 맛집"},
                {"2024-05-28", "주상절리", "사진 스팟 알아가기"},
                {"2024-05-28", "성산일출봉", "일몰 보기"}
                // 여기에 나머지 일정 추가
        };

        model = new DefaultTableModel(data, columns);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    private void createEditPanel() {
        JPanel editPanel = new JPanel(new GridLayout(4, 2));

        JLabel dateLabel = new JLabel("날짜:");
        dateField = new JTextField();
        JLabel placeLabel = new JLabel("장소:");
        placeField = new JTextField();
        JLabel memoLabel = new JLabel("메모:");
        memoField = new JTextField();

        JButton editButton = new JButton("수정");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    model.setValueAt(dateField.getText(), selectedRow, 0);
                    model.setValueAt(placeField.getText(), selectedRow, 1);
                    model.setValueAt(memoField.getText(), selectedRow, 2);
                    clearFields();
                } else {
                    JOptionPane.showMessageDialog(mypage.this, "수정할 행을 선택하세요.", "오류", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        editPanel.add(dateLabel);
        editPanel.add(dateField);
        editPanel.add(placeLabel);
        editPanel.add(placeField);
        editPanel.add(memoLabel);
        editPanel.add(memoField);
        editPanel.add(new JLabel());
        editPanel.add(editButton);

        getContentPane().add(editPanel, BorderLayout.SOUTH);
    }

    private void clearFields() {
        dateField.setText("");
        placeField.setText("");
        memoField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(mypage::new);
    }
}
