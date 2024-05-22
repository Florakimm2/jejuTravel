package exam;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainScreen extends JFrame {
    
    public MainScreen() {
        setTitle("제주도 관광코스 추천");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 콤보 박스 생성
        String[] personOptions = {"1명", "2명", "3명 이상"};
        String[] dateOptions = {"오늘", "내일", "이번 주", "이번 주말"};
        String[] vehicleOptions = {"차량 있음", "차량 없음"};
        String[] conceptOptions = {"자연", "문화", "레저", "음식"};
        String[] locationOptions = {"시내", "해변", "산책로"};
        String[] udoOptions = {"우도 여행 포함", "우도 여행 미포함"};
        
        JComboBox<String> personComboBox = new JComboBox<>(personOptions);
        JComboBox<String> dateComboBox = new JComboBox<>(dateOptions);
        JComboBox<String> vehicleComboBox = new JComboBox<>(vehicleOptions);
        JComboBox<String> conceptComboBox = new JComboBox<>(conceptOptions);
        JComboBox<String> locationComboBox = new JComboBox<>(locationOptions);
        JComboBox<String> udoComboBox = new JComboBox<>(udoOptions);
        
        // 레이블 생성
        JLabel personLabel = new JLabel("인원: ");
        JLabel dateLabel = new JLabel("날짜: ");
        JLabel vehicleLabel = new JLabel("차량 유무: ");
        JLabel conceptLabel = new JLabel("Concept: ");
        JLabel locationLabel = new JLabel("숙소 위치: ");
        JLabel udoLabel = new JLabel("우도 여행: ");
        
        // 버튼 생성
        JButton showResultButton = new JButton("결과 보기");
        
        // 메인 패널 생성
        JPanel mainPanel = new JPanel(new GridLayout(6, 2));
        mainPanel.add(personLabel);
        mainPanel.add(personComboBox);
        mainPanel.add(dateLabel);
        mainPanel.add(dateComboBox);
        mainPanel.add(vehicleLabel);
        mainPanel.add(vehicleComboBox);
        mainPanel.add(conceptLabel);
        mainPanel.add(conceptComboBox);
        mainPanel.add(locationLabel);
        mainPanel.add(locationComboBox);
        mainPanel.add(udoLabel);
        mainPanel.add(udoComboBox);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(showResultButton);
        
        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        
        // 결과 보기 버튼에 대한 이벤트 처리
        showResultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 여기에 결과 화면을 표시하는 코드를 작성하세요.
                // 선택된 조건들을 사용하여 결과를 생성하고 새로운 화면에 표시합니다.
                // 예를 들어, 사용자가 선택한 조건들을 가져오는 방법은
                // String selectedPerson = (String) personComboBox.getSelectedItem();
                // 와 같이 사용할 수 있습니다.
            }
        });
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainScreen();
            }
        });
    }
}
