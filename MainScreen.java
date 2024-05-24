# 5/24 이주원 (조건선택화면 - 조건배치 2행3열로 바꿈) (결과화면 - 새로운창 생성, 피그마처럼 사진3개 나타나게, 하단에 select 버튼 생성, 버튼 누르면 다음 창 넘어가게 만듬)

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

        // 각 레이블과 콤보박스를 패널로 묶기
        JPanel personPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        personPanel.add(personLabel);
        personPanel.add(personComboBox);

        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        datePanel.add(dateLabel);
        datePanel.add(dateComboBox);

        JPanel vehiclePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        vehiclePanel.add(vehicleLabel);
        vehiclePanel.add(vehicleComboBox);

        JPanel conceptPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        conceptPanel.add(conceptLabel);
        conceptPanel.add(conceptComboBox);

        JPanel locationPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        locationPanel.add(locationLabel);
        locationPanel.add(locationComboBox);

        JPanel udoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        udoPanel.add(udoLabel);
        udoPanel.add(udoComboBox);

        // 메인 패널 생성
        JPanel mainPanel = new JPanel(new GridLayout(2, 3));
        mainPanel.add(personPanel);
        mainPanel.add(datePanel);
        mainPanel.add(vehiclePanel);
        mainPanel.add(conceptPanel);
        mainPanel.add(locationPanel);
        mainPanel.add(udoPanel);

        JButton showResultButton = new JButton("결과 보기");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(showResultButton);

        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // 창 크기 설정
        setSize(1280, 830);
        setLocationRelativeTo(null);
        setVisible(true);

        // 결과 보기 버튼에 대한 이벤트 처리
        showResultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 선택된 숙소 위치 가져오기
                String selectedLocation = (String) locationComboBox.getSelectedItem();

                // 위치에 따른 이미지 및 설명 배열 설정
                String[][] images = {
                    {"north_image1.jpg", "north_image2.jpg", "north_image3.jpg"},
                    {"south_image1.jpg", "south_image2.jpg", "south_image3.jpg"},
                    {"west_image1.jpg", "west_image2.jpg", "west_image3.jpg"},
                    {"east_image1.jpg", "east_image2.jpg", "east_image3.jpg"},
                    {"center_image1.jpg", "center_image2.jpg", "center_image3.jpg"}
                };
                String[][] descriptions = {
                    {"북부 지역 이미지 1", "북부 지역 이미지 2", "북부 지역 이미지 3"},
                    {"남부 지역 이미지 1", "남부 지역 이미지 2", "남부 지역 이미지 3"},
                    {"서부 지역 이미지 1", "서부 지역 이미지 2", "서부 지역 이미지 3"},
                    {"동부 지역 이미지 1", "동부 지역 이미지 2", "동부 지역 이미지 3"},
                    {"중부 지역 이미지 1", "중부 지역 이미지 2", "중부 지역 이미지 3"}
                };

                int index;
                switch (selectedLocation) {
                    case "북부":
                        index = 0;
                        break;
                    case "남부":
                        index = 1;
                        break;
                    case "서부":
                        index = 2;
                        break;
                    case "동부":
                        index = 3;
                        break;
                    case "중부":
                        index = 4;
                        break;
                    default:
                        index = 0;
                        break;
                }

                // 결과 화면을 생성
                JFrame resultFrame = new JFrame("추천 관광 코스");
                resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 메인 창은 유지하되 결과 창은 닫기

                // 결과 화면에 이미지와 설명을 표시할 패널 생성
                JPanel resultPanel = new JPanel(new GridLayout(1, 3));

                // 이미지와 선택 버튼을 포함하는 패널 생성 및 추가
                for (int i = 0; i < 3; i++) {
                    addImageWithButton(resultPanel, images[index][i], descriptions[index][i], resultFrame);
                }

                resultFrame.add(resultPanel);
                resultFrame.setSize(1280, 830);
                resultFrame.setLocationRelativeTo(null);
                resultFrame.setVisible(true);
            }
        });
    }

    private void addImageWithButton(JPanel panel, String imagePath, String description, JFrame resultFrame) {
        // 이미지와 설명을 포함하는 패널 생성
        JPanel imagePanel = new JPanel(new BorderLayout());
        
        // 이미지를 표시할 라벨 생성
        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(imagePath);
        imageLabel.setIcon(imageIcon);

        // 설명을 표시할 라벨 생성
        JLabel descriptionLabel = new JLabel(description);
        descriptionLabel.setHorizontalAlignment(JLabel.CENTER);
        descriptionLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        descriptionLabel.setFont(new Font("맑은고딕", Font.BOLD, 18));

        // 선택 버튼 생성
        JButton selectButton = new JButton("Select");
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 선택한 이미지 경로를 저장하고 다음 페이지로 이동
                String selectedImagePath = imagePath;
                new NextPage(selectedImagePath);
                resultFrame.dispose();
            }
        });

        // 이미지, 설명, 선택 버튼을 패널에 추가
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        imagePanel.add(descriptionLabel, BorderLayout.SOUTH);
        imagePanel.add(selectButton, BorderLayout.NORTH);

        panel.add(imagePanel);
    }
}

class NextPage extends JFrame {
    public NextPage(String imagePath) {
        setTitle("다음 페이지");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 이미지와 설명을 표시할 패널 생성
        JPanel panel = new JPanel(new BorderLayout());

        // 이미지를 표시할 라벨 생성
        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon(imagePath);
        imageLabel.setIcon(imageIcon);

        // 패널에 이미지 라벨 추가
        panel.add(imageLabel, BorderLayout.CENTER);

        add(panel);
        setSize(1280, 830);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

