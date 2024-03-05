package practice;

import java.util.*;
import java.util.stream.Collectors;

// https://school.programmers.co.kr/learn/courses/30/lessons/42579
public class algorithm16 {

    public static void main(String[] args) {

        System.out.println(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500}));
    }

    public static int[] solution(String[] genres, int[] plays) {
        List<PlayData> list = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            list.add(new PlayData(genres[i], plays[i], i));
        }

        // 장르별 플레이 횟수 합산
        Map<String, Integer> sumMap = list.stream()
                .collect(Collectors.groupingBy(PlayData::getGenre, Collectors.summingInt(PlayData::getPlays)));

        // 각 장르별 최대값 2개 선택
        List<Map.Entry<String, Integer>> sortedSumList = sumMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toList());

        List<PlayData> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedSumList) {
            List<PlayData> genreList = list.stream()
                    .filter(playData -> playData.getGenre().equals(entry.getKey()))
                    .sorted(Comparator.comparing(PlayData::getPlays).reversed().thenComparing(PlayData::getId))
                    .limit(2) // 각 장르별 최대값 2개만 선택
                    .collect(Collectors.toList());
            result.addAll(genreList);
        }

        // 정렬된 PlayData의 id 배열로 반환
        return result.stream().mapToInt(PlayData::getId).toArray();
    }

    static class PlayData{
        String genre;
        Integer plays;
        Integer id;

        public PlayData(String genre, Integer plays, Integer id) {
            this.genre = genre;
            this.plays = plays;
            this.id = id;
        }

        public String getGenre() {
            return genre;
        }

        public Integer getPlays() {
            return plays;
        }

        public Integer getId() {
            return id;
        }
    }
}
