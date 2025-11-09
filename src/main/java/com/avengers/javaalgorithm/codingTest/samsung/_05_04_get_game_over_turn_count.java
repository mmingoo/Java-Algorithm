package com.avengers.javaalgorithm.codingTest.samsung;
import java.sql.Array;
import java.util.*;
import java.io.*;
import java.util.*;

class _05_04_get_game_over_turn_count {
    static int k = 4;  // 말의 개수

    static int[][] chessMap = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    };
    static int[][] startHorseLocationAndDirections = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 2, 0},
            {2, 2, 2}
    };

    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    public static int getDIndexWhenGoBack(int d) {
        if (d % 2 == 0) {
            return d + 1;
        } else {
            return d - 1;
        }
    }


    public static int getGameOverTurnCount(int horseCount, int[][] gameMap, int[][] horseLocationAndDirections) {
        int n = gameMap.length;
        int turnCount = 1;
        List<List<List<Integer>>> currentStackedHorseMap = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            currentStackedHorseMap.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                currentStackedHorseMap.get(i).add(new ArrayList<>());
            }
        }
        for (int i = 0; i < horseCount; i++) {
            int r = horseLocationAndDirections[i][0];
            int c = horseLocationAndDirections[i][1];
            currentStackedHorseMap.get(r).get(c).add(i); // current_stacked_horse_map[0][0] = [0]
        }

        while (turnCount <= 1000) {
            for (int horseIndex = 0; horseIndex < horseCount; horseIndex++) {
                int r = horseLocationAndDirections[horseIndex][0];
                int c = horseLocationAndDirections[horseIndex][1];
                int d = horseLocationAndDirections[horseIndex][2];
                int newR = r + dr[d];
                int newC = c + dc[d];

                if (!(0 <= newR && newR < n) || !(0 <= newC && newC < n) || gameMap[newR][newC] == 2) {
                    int newD = getDIndexWhenGoBack(d);

                    // 이동 방향을 반대로 하고 한 칸 이동한다. 방향을 반대로 바꾼 후에 이동하려는 칸이 파란색인 경우에는 이동하지 않고 가만히 있는다.
                    newR = r + dr[newD];
                    newC = c + dc[newD];
                    horseLocationAndDirections[horseIndex][2] = newD;
                    // 방향을 반대로 바꾼 후에 이동하려는 칸이 파란색이거나 체스판을 벗어나는 경우에는 이동하지 않고 가만히 있는다.
                    if (!(0 <= newR && newR < n) || !(0 <= newC && newC < n) || gameMap[newR][newC] == 2) {
                        continue;
                    }
                }


                List<Integer> movingHorseIndexArray = new ArrayList<>();
                List<Integer> currentCell = currentStackedHorseMap.get(r).get(c);
                for (int i = 0; i < currentCell.size(); i++) {
                    int currentStackedHorseIndex = currentCell.get(i);

                    if (horseIndex == currentStackedHorseIndex) {
                        movingHorseIndexArray = new ArrayList<>(currentCell.subList(i, currentCell.size()));
                        currentStackedHorseMap.get(r).set(c, new ArrayList<>(currentCell.subList(0, i)));
                        break;
                    }
                }
                if (gameMap[newR][newC] == 1) {
                    Collections.reverse(movingHorseIndexArray);
                }

                for (int movingHorseIndex : movingHorseIndexArray) {
                    currentStackedHorseMap.get(newR).get(newC).add(movingHorseIndex);
                    horseLocationAndDirections[movingHorseIndex][0] = newR;
                    horseLocationAndDirections[movingHorseIndex][1] = newC;
                }
                if (currentStackedHorseMap.get(newR).get(newC).size() >= 4) {
                    return turnCount;
                }
            }

            turnCount += 1;
        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(getGameOverTurnCount(k, chessMap, startHorseLocationAndDirections));  // 2가 반환 되어야합니다

        int[][] startHorseLocationAndDirections2 = {
                {0, 1, 0},
                {1, 1, 0},
                {0, 2, 0},
                {2, 2, 2}
        };
        System.out.println("정답 = 9 / 현재 풀이 값 = " + getGameOverTurnCount(k, chessMap, startHorseLocationAndDirections2));

        int[][] startHorseLocationAndDirections3 = {
                {0, 1, 0},
                {0, 1, 1},
                {0, 1, 0},
                {2, 1, 2}
        };
        System.out.println("정답 = 3 / 현재 풀이 값 = " + getGameOverTurnCount(k, chessMap, startHorseLocationAndDirections3));
    }
}