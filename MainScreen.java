// 5/24 이주원 (조건선택화면 - 조건배치 2행3열로 바꿈) (결과화면 - 새로운창 생성, 피그마처럼 사진3개 나타나게, 하단에 select 버튼 생성, 버튼 누르면 다음 창 넘어가게 만듬)
// 5/25 이현정 (상단바 구성 - 왼쪽 myJeju 글씨, 옆에 mypage, community 메뉴 구성 크기는 나중에 조정.., mypage, community 누르면 창 넘어감.)
// 5/25 이주원 (결과화면 - 사진4개한묶음 x 3개 나타나게 구현) (select 버튼 없애고 사진 누르면 창 열리게 설정) (추천코스 제목 추가, 각 묶음별 제목 추가)
// 5/25 18:40 김민경 (달력 넣음) (달력 삽입을 실행시키려면 'jdatepicker'파일을 다운받아 project lib에 추가해야 함!) (초반 import net.~ 3줄과 이름 뒤에 'CAL'이 붙어있는 변수들이 있는 줄은 모두 수정된 줄!)
// 5/26 이주원 (남부 사진 저장,이름,설명 일부만 일단 추가) (결과화면 사진 제목 글씨 크기 줄임, 사진 안잘리고 나오게 코딩) (사진 누르면 나오는 창 - 좌측에 사진 나오게, 우측에 설명 나오게 코딩)

package exam;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;


public class MainScreen extends JFrame {

    public MainScreen() {
        setTitle("제주도 관광코스 추천");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createMenu(); // 상단바 함수 실행

        UtilDateModel modelCAL = new UtilDateModel();
        JDatePanelImpl datePanelCAL = new JDatePanelImpl(modelCAL);
        JDatePickerImpl datePickerCAL = new JDatePickerImpl(datePanelCAL);

        // 콤보 박스 생성
        String[] personOptions = {"1", "2", "3", "4", "5", "6+"};
        String[] vehicleOptions = {"O", "X"};
        String[] conceptOptions = {"힐링", "올레길", "인스타", "맛집", "드라이브"};
        String[] locationOptions = {"북부", "남부", "서부", "동부", "중부"};
        String[] udoOptions = {"우도 여행 포함", "우도 여행 미포함"};

        JComboBox<String> personComboBox = new JComboBox<>(personOptions);
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
        datePanel.add(datePickerCAL); // 달력 삽입

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
                String[][][] images = {
                        {
                                {"north_image1_!.jpg", "north_image1_2.jpg", "north_image1_3.jpg", "north_image1_4.jpg"},
                                {"north_image2_1.jpg", "north_image2_2.jpg", "north_image2_3.jpg", "north_image2_4.jpg"},
                                {"north_image3_1.jpg", "north_image3_2.jpg", "north_image3_3.jpg", "north_image3_4.jpg"}
                        },
                        {
                                {"s_res1.jpg", "s_cafe1.jpg", "s_land1.jpg", "s_land2.jpg"},
                                {"s_res2.jpg", "s_cafe2.jpg", "s_land3.jpg", "s_land4.jpg"},
                                {"s_res3.jpg", "s_cafe3.jpg", "s_land3.jpg", "s_land1.jpg"}
                        },
                        {
                                {"west_image1_1.jpg", "west_image1_2.jpg", "west_image1_3.jpg", "west_image1_4.jpg"},
                                {"west_image2_1.jpg", "west_image2_2.jpg", "west_image2_3.jpg", "west_image2_4.jpg"},
                                {"west_image3_1.jpg", "west_image3_2.jpg", "west_image3_3.jpg", "west_image3_4.jpg"}
                        },
                        {
                                {"east_image1_1.jpg", "east_image1_2.jpg", "east_image1_3.jpg", "east_image1_4.jpg"},
                                {"east_image2_1.jpg", "east_image2_2.jpg", "east_image2_3.jpg", "east_image2_4.jpg"},
                                {"east_image3_1.jpg", "east_image3_2.jpg", "east_image3_3.jpg", "east_image3_4.jpg"}
                        },
                        {
                                {"center_image1_1.jpg", "center_image1_2.jpg", "center_image1_3.jpg", "center_image1_4.jpg"},
                                {"center_image2_1.jpg", "center_image2_2.jpg", "center_image2_3.jpg", "center_image2_4.jpg"},
                                {"center_image3_1.jpg", "center_image3_2.jpg", "center_image3_3.jpg", "center_image3_4.jpg"}
                        }
                };

                String[][][] descriptions = {
                        {
                                {"북부 지역 이미지 1-1", "북부 지역 이미지 1-2", "북부 지역 이미지 1-3", "북부 지역 이미지 1-4"},
                                {"북부 지역 이미지 2-1", "북부 지역 이미지 2-2", "북부 지역 이미지 2-3", "북부 지역 이미지 2-4"},
                                {"북부 지역 이미지 3-1", "북부 지역 이미지 3-2", "북부 지역 이미지 3-3", "북부 지역 이미지 3-4"}
                        },
                        {
                                {"큰갯물횟집 중문본점", "제주카페스르륵", "주상절리대(중문대포해안)", "엉덩물계곡"},
                                {"화고 흑돼지 신시가지점", "카페 허니문하우스", "중문색달해수욕장", "약천사"},
                                {"강정해녀의 집", "카페 바다다", "중문색달해수욕장", "주상절리대(중문대포해안)"}
                        },
                        {
                                {"서부 지역 이미지 1-1", "서부 지역 이미지 1-2", "서부 지역 이미지 1-3", "서부 지역 이미지 1-4"},
                                {"서부 지역 이미지 2-1", "서부 지역 이미지 2-2", "서부 지역 이미지 2-3", "서부 지역 이미지 2-4"},
                                {"서부 지역 이미지 3-1", "서부 지역 이미지 3-2", "서부 지역 이미지 3-3", "서부 지역 이미지 3-4"}
                        },
                        {
                                {"동부 지역 이미지 1-1", "동부 지역 이미지 1-2", "동부 지역 이미지 1-3", "동부 지역 이미지 1-4"},
                                {"동부 지역 이미지 2-1", "동부 지역 이미지 2-2", "동부 지역 이미지 2-3", "동부 지역 이미지 2-4"},
                                {"동부 지역 이미지 3-1", "동부 지역 이미지 3-2", "동부 지역 이미지 3-3", "동부 지역 이미지 3-4"}
                        },
                        {
                                {"중부 지역 이미지 1-1", "중부 지역 이미지 1-2", "중부 지역 이미지 1-3", "중부 지역 이미지 1-4"},
                                {"중부 지역 이미지 2-1", "중부 지역 이미지 2-2", "중부 지역 이미지 2-3", "중부 지역 이미지 2-4"},
                                {"중부 지역 이미지 3-1", "중부 지역 이미지 3-2", "중부 지역 이미지 3-3", "중부 지역 이미지 3-4"}
                        }
                };

                String[][][] comments = {
                        {
                                {"북부 이미지 1-1의 코멘트", "북부 이미지 1-2의 코멘트", "북부 이미지 1-3의 코멘트", "북부 이미지 1-4의 코멘트"},
                                {"북부 이미지 2-1의 코멘트", "북부 이미지 2-2의 코멘트", "북부 이미지 2-3의 코멘트", "북부 이미지 2-4의 코멘트"},
                                {"북부 이미지 3-1의 코멘트", "북부 이미지 3-2의 코멘트", "북부 이미지 3-3의 코멘트", "북부 이미지 3-4의 코멘트"}
                        },
                        {
                                {"-대포항 앞 바다뷰 횟집\n-고깃배를 보유 사장님이 직접잡은 자연산회", "제주카페스르륵 코멘트", "주상절리대(중문대포해안) 코멘트", "엉덩물계곡 코멘트"},
                                {"화고 흑돼지 신시가지점 코멘트", "카페 허니문하우스 코멘트", "중문색달해수욕장 코멘트", "약천사 코멘트"},
                                {"강정해녀의 집 코멘트", "카페 바다다 코멘트", "중문색달해수욕장 코멘트", "주상절리대(중문대포해안) 코멘트"}
                        },
                        {
                                {"서부 이미지 1-1의 코멘트", "서부 이미지 1-2의 코멘트", "서부 이미지 1-3의 코멘트", "서부 이미지 1-4의 코멘트"},
                                {"서부 이미지 2-1의 코멘트", "서부 이미지 2-2의 코멘트", "서부 이미지 2-3의 코멘트", "서부 이미지 2-4의 코멘트"},
                                {"서부 이미지 3-1의 코멘트", "서부 이미지 3-2의 코멘트", "서부 이미지 3-3의 코멘트", "서부 이미지 3-4의 코멘트"}
                        },
                        {
                                {"동부 이미지 1-1의 코멘트", "동부 이미지 1-2의 코멘트", "동부 이미지 1-3의 코멘트", "동부 이미지 1-4의 코멘트"},
                                {"동부 이미지 2-1의 코멘트", "동부 이미지 2-2의 코멘트", "동부 이미지 2-3의 코멘트", "동부 이미지 2-4의 코멘트"},
                                {"동부 이미지 3-1의 코멘트", "동부 이미지 3-2의 코멘트", "동부 이미지 3-3의 코멘트", "동부 이미지 3-4의 코멘트"}
                        },
                        {
                                {"중부 이미지 1-1의 코멘트", "중부 이미지 1-2의 코멘트", "중부 이미지 1-3의 코멘트", "중부 이미지 1-4의 코멘트"},
                                {"중부 이미지 2-1의 코멘트", "중부 이미지 2-2의 코멘트", "중부 이미지 2-3의 코멘트", "중부 이미지 2-4의 코멘트"},
                                {"중부 이미지 3-1의 코멘트", "중부 이미지 3-2의 코멘트", "중부 이미지 3-3의 코멘트", "중부 이미지 3-4의 코멘트"}
                        }
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
                    addImageGroup(resultPanel, images[index][i], descriptions[index][i], comments[index][i], resultFrame, i); // 수정된 부분
                }

                resultFrame.add(resultPanel);
                resultFrame.setSize(1280, 830);
                resultFrame.setLocationRelativeTo(null);
                resultFrame.setVisible(true);

                // 결과 패널에 제목 라벨 추가
                JLabel titleLabel = new JLabel("추천 관광 코스");
                titleLabel.setHorizontalAlignment(JLabel.CENTER);
                titleLabel.setFont(new Font("맑은고딕", Font.BOLD, 24));
                resultFrame.add(titleLabel, BorderLayout.NORTH);
            }
        });
    }

    private void addImageGroup(JPanel panel, String[] imagePaths, String[] descriptions, String[] comments, JFrame resultFrame, int groupIndex) {
        // 각 그룹을 포함하는 패널 생성
        JPanel groupPanel = new JPanel(new BorderLayout());

        // 그룹 제목 라벨 생성
        JLabel titleLabel = new JLabel("추천 " + (groupIndex + 1));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("맑은고딕", Font.BOLD, 20));
        groupPanel.add(titleLabel, BorderLayout.NORTH); // 수정된 부분

        JPanel innerPanel = new JPanel(new GridLayout(2, 2));
        groupPanel.add(innerPanel, BorderLayout.CENTER);

        for (int i = 0; i < imagePaths.length; i++) {
            addImageWithButton(innerPanel, imagePaths[i], descriptions[i], comments[i], resultFrame);
        }
        groupPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // 테두리 추가

        panel.add(groupPanel);
    }

    private void addImageWithButton(JPanel panel, String imagePath, String description, String comment, JFrame resultFrame) {
        // 이미지와 설명을 포함하는 패널 생성
        JPanel imagePanel = new JPanel(new BorderLayout());

        // 이미지를 표시할 라벨 생성
        JLabel imageLabel = new JLabel();
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image originalImage = originalIcon.getImage();
        
        // 패널 크기에 맞게 이미지 조정
        int panelWidth = 300;  // 원하는 패널 너비
        int panelHeight = 200; // 원하는 패널 높이
        Image scaledImage = originalImage.getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        imageLabel.setIcon(scaledIcon);

        // 설명을 표시할 라벨 생성
        JLabel descriptionLabel = new JLabel(description);
        descriptionLabel.setHorizontalAlignment(JLabel.CENTER);
        descriptionLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        descriptionLabel.setFont(new Font("맑은고딕", Font.BOLD, 15));

        // 이미지 라벨에 마우스 리스너 추가
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 선택한 이미지 경로를 저장하고 다음 페이지로 이동
                new NextPage(imagePath, comment);
                resultFrame.dispose();
            }
        });

        // 이미지와 설명을 패널에 추가
        imagePanel.add(imageLabel, BorderLayout.CENTER);
        imagePanel.add(descriptionLabel, BorderLayout.SOUTH);

        panel.add(imagePanel);
    }

    private void createMenu() { // 상단바 함수
        JMenuBar menuBar = new JMenuBar();

        JLabel leftLabel = new JLabel("myJeju");
        leftLabel.setBorder(new EmptyBorder(0, 10, 0, 0));
        menuBar.add(leftLabel);

        JMenuItem mypageItem = new JMenuItem("mypage");
        JMenuItem communityItem = new JMenuItem("community");
        mypageItem.addActionListener(new mypageActionListner());
        communityItem.addActionListener(new communityActionListner());

        menuBar.add(Box.createHorizontalGlue());

        menuBar.add(mypageItem);
        menuBar.add(communityItem);

        setJMenuBar(menuBar);
    }

    private class mypageActionListner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new mypage();
            dispose();
        }
    }

    private class communityActionListner implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new community();
            dispose();
        }
    }
}

class NextPage extends JFrame {
    public NextPage(String imagePath, String comment) {
        setTitle("다음 페이지");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 패널을 생성하여 좌측에는 이미지, 우측에는 코멘트를 배치
        JPanel panel = new JPanel(new GridLayout(1, 2));

        // 이미지를 표시할 라벨 생성
        JLabel imageLabel = new JLabel();
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image originalImage = originalIcon.getImage();
        
        // 패널 크기에 맞게 이미지 조정
        int panelWidth = 640;  // 패널 너비 (창 너비의 절반)
        int panelHeight = 830; // 패널 높이
        Image scaledImage = originalImage.getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        
        imageLabel.setIcon(scaledIcon);

        // 코멘트를 표시할 라벨 생성
        JLabel commentLabel = new JLabel("<html>" + comment.replaceAll("\n", "<br>") + "</html>");
        commentLabel.setHorizontalAlignment(JLabel.CENTER);
        commentLabel.setFont(new Font("맑은고딕", Font.PLAIN, 20));
        commentLabel.setVerticalAlignment(JLabel.TOP); // 코멘트를 상단에 정렬

        // 패널에 이미지 라벨과 코멘트 라벨 추가
        panel.add(imageLabel);
        panel.add(commentLabel);

        add(panel);
        setSize(1280, 830);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}







