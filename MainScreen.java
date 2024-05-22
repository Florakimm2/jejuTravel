// 이주원 5/22 21:48 북부 사진 팝업창 확인완료

package exam;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainScreen extends JFrame {
    
    public MainScreen() {
        setTitle("제주도 관광코스 추천");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // 콤보 박스 생성
        String[] personOptions = {"1", "2", "3", "4", "5", "6+"};
        String[] dateOptions = {"오늘", "내일", "이번 주", "이번 주말"};
        String[] vehicleOptions = {"O", "X"};
        String[] conceptOptions = {"힐링", "올레길", "인스타", "맛집", "드라이브"};
        String[] locationOptions = {"북부", "남부", "서부", "동부", "중부"};
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
                // 선택된 숙소 위치 가져오기
                String selectedLocation = (String) locationComboBox.getSelectedItem();
                
                // 숙소 위치에 따른 이미지 경로 설정
                String imagePath;
                switch (selectedLocation) {
                    case "북부":
                        imagePath = "NORTH.jpg"; // 북부 지역 이미지 경로 설정
                        break;
                    case "남부":
                        imagePath = "path_to_south_image.jpg"; // 남부 지역 이미지 경로 설정
                        break;
                    case "동부":
                        imagePath = "path_to_east_image.jpg"; // 동부 지역 이미지 경로 설정
                        break;
                    case "서부":
                        imagePath = "path_to_west_image.jpg"; // 서부 지역 이미지 경로 설정
                        break;
                    case "중부":
                        imagePath = "path_to_center_image.jpg"; // 중부 지역 이미지 경로 설정
                        break;
                    default:
                        imagePath = "default_image.jpg"; // 기본 이미지 경로 설정
                }
                
                // 결과 화면을 생성
                JFrame resultFrame = new JFrame("추천 관광 코스");
                resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 메인 창은 유지하되 결과 창은 닫기
                
                // 이미지를 표시할 라벨 생성
                JLabel imageLabel = new JLabel();
                
                // 이미지 라벨에 이미지 설정
                ImageIcon imageIcon = new ImageIcon(imagePath);
                imageLabel.setIcon(imageIcon);
                
                // 결과 화면에 이미지 라벨 추가
                resultFrame.add(imageLabel, BorderLayout.CENTER);
                
                // 결과 화면 크기 설정
                resultFrame.setSize(1280, 830);
                resultFrame.setLocationRelativeTo(null);
                resultFrame.setVisible(true);
            }
        });


    }
}
