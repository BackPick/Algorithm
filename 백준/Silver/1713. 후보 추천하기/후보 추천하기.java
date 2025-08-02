import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 메인 클래스
public class Main {

    // 사진(후보) 정보를 담기 위한 helper 클래스
    static class Photo {
        int student;      // 학생 번호
        int recommend;    // 추천 횟수
        int time;         // 게시된 시간 (타임스탬프)

        public Photo(int student, int recommend, int time) {
            this.student = student;
            this.recommend = recommend;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 사진틀 개수
        int totalRecommendations = sc.nextInt(); // 전체 추천 횟수

        List<Photo> photos = new ArrayList<>(); // 현재 사진틀에 게시 중인 후보 리스트
        int currentTime = 0; // 사진이 게시된 순서를 추적하기 위한 타임스탬프
        
        // 추천받은 학생 번호들을 순서대로 처리
        for (int i = 0; i < totalRecommendations; i++) {
            int student = sc.nextInt();
            boolean found = false;
            
            // 후보가 이미 사진틀에 게시되어 있는지 확인
            for (Photo photo : photos) {
                if (photo.student == student) {
                    photo.recommend++; // 이미 게시되어있다면 추천 횟수 증가
                    found = true;
                    break;
                }
            }
            
            // 후보가 사진틀에 없는 경우 처리
            if (!found) {
                // 사진틀에 빈 공간이 있는 경우 바로 추가
                if (photos.size() < N) {
                    photos.add(new Photo(student, 1, currentTime));
                    currentTime++;
                } else {
                    // 사진틀에 빈 공간이 없으므로, 삭제할 후보를 선정
                    // 가장 추천 횟수가 적은 후보를 찾기 (추천 횟수가 같다면, 오래전에 게시된 후보 우선)
                    int minRecommend = Integer.MAX_VALUE;
                    int oldestTime = Integer.MAX_VALUE;
                    int removeIndex = -1;
                    
                    for (int j = 0; j < photos.size(); j++) {
                        Photo candidate = photos.get(j);
                        if (candidate.recommend < minRecommend) {
                            minRecommend = candidate.recommend;
                            oldestTime = candidate.time;
                            removeIndex = j;
                        } else if (candidate.recommend == minRecommend) {
                            // 추천 횟수가 같으면 게시 시간이 더 오래된 것을 선택
                            if (candidate.time < oldestTime) {
                                oldestTime = candidate.time;
                                removeIndex = j;
                            }
                        }
                    }
                    
                    // 선택된 후보 삭제 (삭제 시 추천 횟수를 0으로 변경하지만, 삭제된 후보는 재사용 안 함)
                    photos.remove(removeIndex);
                    
                    // 새로운 후보 사진 게시
                    photos.add(new Photo(student, 1, currentTime));
                    currentTime++;
                }
            }
        }
        
        // 최종 사진틀에 남은 후보의 학생 번호 추출 후 오름차순으로 정렬
        List<Integer> result = new ArrayList<>();
        for (Photo photo : photos) {
            result.add(photo.student);
        }
        Collections.sort(result);
        
        // 결과 출력
        for (int num : result) {
            System.out.print(num + " ");
        }
        
        sc.close();
    }
}
