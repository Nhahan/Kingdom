package org.example.Kingdom;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static int loyalist = 10; //충신 수, 0이 되면 패배합니다
    static int traitor = 5; //반역자 수, 반역자 수가 충신 수보다 많아지면 패배합니다.
    static int popularity = 5; //민심, 0이 되면 패배합니다.
    static int money = 5; //재정, 0이 되면 패배합니다.
    static int merchant = 0;
    static int event = 0;

    public static void main(String[] args) {
        Main game = new Main();

        game.gameStart();
    }

    public void gameStart() {
        Scanner scan = new Scanner(System.in);

        System.out.println("\n\n시작하려면 Enter키를 눌러주세요.");
        String enter = scan.nextLine();

        for (int i = 0; i < 5; ) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
            i++;
        }

        Main game = new Main();

        System.out.println("\n◈\n당신은 한 나라의 왕입니다."); game.loading();

        System.out.println("그러나 당신은 일부 세력이 반역을 꾀하고 있다는 사실을 알았습니다."); game.loading();
        System.out.println("각각의 상황에 맞게 올바른 선택을 하여 왕국을 잘 다스려 살아남으세요."); game.loading();
        System.out.println("정의로운 선택만이 정답이 아닙니다. 통치엔 희생 또한 필요할 것입니다."); game.loading();
        System.out.println("\n게임 방법 : 선택지를 입력하고, 진행은 Enter키를 눌러주세요.\n"); game.loading();
        String enter2 = scan.nextLine();
        game.beforeDay1_1();
    } // 게임 첫 부분
    public void gameChecker() { //승패 조건
        Scanner scan = new Scanner(System.in);
        Main game = new Main();
        if (loyalist <= 0) {
            System.out.println("충신들조차 당신의 무능함에 고개를 돌렸습니다."); game.loading();game.loading();
            System.out.println("반역자들의 손에 왕국이 넘어갔습니다."); game.loading();

            String enter = scan.nextLine();

            gameStatus(); //게임리셋

            game.gameStart(); //메인으로
        }
        else if (traitor > loyalist) {
            System.out.println("반역자들이 충신들을 모두 죽였습니다."); game.loading();game.loading();
            System.out.println("반역자들의 손에 왕국이 넘어갔습니다."); game.loading();

            String enter = scan.nextLine();

            gameStatus();

            game.gameStart();
        }
        else if (popularity <=0) {
            System.out.println("백성들이 당신의 횡포에 반란을 일으켰습니다."); game.loading();game.loading();
            System.out.println("당신은 분노한 농민의 갈퀴에 맞아죽었습니다."); game.loading();

            String enter = scan.nextLine();

            gameStatus();

            game.gameStart();
        } else if (money <= 0) {
            System.out.println("왕국의 재정이 말랐습니다.");
            System.out.println("당신은 당신의 무능함에 치를 떤 누군가에게 살해당했습니다.");

            String enter = scan.nextLine();

            gameStatus();

            game.gameStart();
        }
    } // 승패 체크
    public void gameStatus() { // 게임 리셋
        loyalist = 10;
        traitor = 5;
        popularity = 5;
        money = 5;
    }
    public static void loading() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    } // 1초 로딩
    public void beforeDay1_1() {
        Scanner scan = new Scanner(System.in);
        Main game = new Main();

        game.loading();
        System.out.println("\n당신은 어떤 왕인가요?"); game.loading();
        System.out.println("1. 정의로운 왕");
        System.out.println("2. 지혜로운 왕");
        System.out.println("3. 공정한 왕");
        System.out.println("4. 폭군");
        int kingType = scan.nextInt();
        if (kingType == 1) {
            loyalist = 11;
            traitor = 5;
            popularity = 6;
        }
        else if (kingType == 2) {
            loyalist = 10;
            traitor = 4;
            popularity = 6;
        }
        else if(kingType == 3) {
            loyalist = 10;
            traitor = 5;
            popularity = 5;
        }
        else if (kingType == 4) {
            loyalist = 9;
            traitor = 6;
            popularity = 4;
        }
        else {
            game.beforeDay1_1();
        }
        for (int i=0; i<5;) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
            i++;
        }
        game.beforeDay1_2();
    } // 당신은 어떤 왕인가요?
    public void beforeDay1_2() {
        Scanner scan = new Scanner(System.in);
        Main game = new Main();

        System.out.println("\n\n당신은 전생에 어떤 사람이었습니까?"); game.loading();
        System.out.println("1. 연금술사");
        System.out.println("2. 양치기");
        System.out.println("3. 귀족");
        System.out.println("4. 왕");
        int pastType = scan.nextInt();
        if (pastType == 1) {
            loyalist += 0;
            traitor += 0;
            popularity += 0;
            money += 1;
        }
        else if (pastType == 2) {
            loyalist += 0;
            traitor += 0;
            popularity += 1;
        }
        else if (pastType == 3) {
            loyalist += 0;
            traitor += 1;
            popularity += 0;
        }
        else if (pastType == 4) {
            loyalist += 1;
            traitor += 0;
            popularity += 0;
        }
        else {
            game.beforeDay1_2();
        }

        for (int i=0; i<5;) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
            i++;
        }

        game.day1_1();
    } // 당신은 전생에 어떤 사람이었습니까?
    public void day1_1() {
        Scanner scan = new Scanner(System.in);
        Main game = new Main();

        System.out.println("\n\n◈ Day1_10시 / 재정 : " + money + "\n"); game.loading();game.loading();

        System.out.println("상인이 찾아와 물었습니다."); game.loading();
        System.out.println("\"왕이시여, 수도에 새로운 상인길드가 생길 것입니다.");
        System.out.println("그런데 당장 자금이 부족하여 계획에 차질이 생겼습니다.");
        System.out.println("혹시, 수도의 발전을 위해 자금 마련을 도와주실 수 있으신지요?");
        System.out.println("분명 미래에 큰 복으로 돌아올 것입니다.\""); game.loading();

        System.out.println("1. 좋다. 도와주겠다");
        System.out.println("2. 썩 물러가라!");
        System.out.println("3. 건방지군. 저놈의 목을 쳐내라!");
        System.out.println("4. 생각해보겠다. 나중에 다시 오거라");

        int f = 0;
        for (f = 0; f<1;) {
            int answerMerchant = scan.nextInt();
            if (answerMerchant == 1) {
                loyalist += 1; // +1
                traitor += 0;
                popularity += 0;
                money -= 2; //-2
                f += 1;
                merchant = 1; // 상인길드 이벤트 활성화
            } else if (answerMerchant == 2) {
                loyalist -= 1; // -1
                traitor += 1; // +1
                popularity += 0;
                money += 0;
                f += 1;
            } else if (answerMerchant == 3) {
                loyalist -= 2; // -2
                traitor += 1; // +1
                popularity -= 1; //-1
                money += 1; // +1
                f += 1;
            } else if (answerMerchant == 4) {
                loyalist += 1; // +1
                traitor += 0;
                popularity += 0;
                money += 0;
                f += 1;
            } else {
                continue;
            }
        }

        for (int i=0; i<5;) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
            i++;
        }

        game.gameChecker(); //승패 조건 체크
        game.day1_2();

    } // 상인길드 건설
    public void day1_2() {
        Scanner scan = new Scanner(System.in);
        Main game = new Main();

        System.out.println("\n\n◈ Day1_14시 / 재정 : " + money + "\n"); game.loading();game.loading();

        System.out.println("신하가 머리를 조아리며 아룁니다."); game.loading();
        System.out.println("\"왕이시여, 새로운 달을 맞아 행사를 기획하는게 어떠신지요.");
        System.out.println("작은 행사든, 큰 행사든 간에 왕국의 번영에 도움이 될 것입니다.");
        System.out.println("여기 제가 생각해본 행사들입니다.\""); game.loading();

        System.out.println("1. 일주일 뒤, 지방 귀족들까지 모두 불러 왕궁에서 사치스러운 연회");
        System.out.println("2. 오늘 밤, 왕궁에 있는 귀족들만 즐기는 파티");
        System.out.println("3. 백성들을 위한 무료 배식");
        System.out.println("4. 왕궁의 재정이 모자르다. 다음 기회에 열겠다");

        int f = 0;
        for (f = 0; f<1;) {
            int answerDay1_2 = scan.nextInt();
            if (answerDay1_2 == 1) {
                loyalist += 1; // +1
                traitor -= 1; // -1
                popularity -= 2; // -2
                money -= 3; // -3
                f += 1;
            } else if (answerDay1_2 == 2) {
                loyalist += 0;
                traitor += 1; // +1
                popularity -= 1; // -1
                money -= 1; // -1
                f += 1;
            } else if (answerDay1_2 == 3) {
                loyalist -= 1; // -1
                traitor += 0;
                popularity += 2; // +2
                money -= 2; // -2
                f += 1;
            } else if (answerDay1_2 == 4) {
                loyalist -= 1; // -1
                traitor = 0;
                popularity = 0;
                money += 0;
                f += 1;
            } else {
                continue;
            }
        }

        for (int i=0; i<5;) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
            i++;
        }

        game.gameChecker(); //승패 조건 체크
        day1_3();
    } // 신하 잔치
    public void day1_3() {
        Scanner scan = new Scanner(System.in);
        Main game = new Main();

        System.out.println("\n\n◈ Day1_16시 / 재정 : " + money + "\n");
        game.loading();
        game.loading();

        System.out.println("신하가 조용하게 아룁니다.");
        game.loading();
        System.out.println("\"왕이시여, 동쪽의 마녀라는 자가 왕을 뵙고 싶다고 합니다");
        System.out.println("조심하십시오. 마녀는 예로부터 불길하다고 여겨져 왔습니다.\"");
        game.loading();

        System.out.println("1. 마녀를 왕궁에 들인다");
        System.out.println("2. 마녀를 내쫓는다");
        System.out.println("3. 병사들에게 마녀에게 욕설을 하라고 지시한다");
        System.out.println("4. 감히 왕궁에 겁도 없이 찾아오다니. 당장 더러운 마녀를 죽여라!");

        int f = 0;
        event = 0;
        for (f = 0; f < 1; ) {
            int answerDay1_3 = scan.nextInt();
            if (answerDay1_3 == 1) {
                loyalist -= 1; // -1
                traitor += 1; // +1
                popularity -= -1; // -1
                money -= 0;
                f += 1;
                event = 1; // 마녀이벤트 활성화
            } else if (answerDay1_3 == 2) {
                loyalist += 1; // +1
                traitor += 1; // +1
                popularity -= 0;
                money -= 0;
                f += 1;
            } else if (answerDay1_3 == 3) {
                loyalist += 0;
                traitor += 0;
                popularity += 1; // +1
                money -= 0;
                f += 1;
            } else if (answerDay1_3 == 4) {
                loyalist += 1; // +1
                traitor += 0;
                popularity += 0;
                money += 1; // +1
                f += 1;
            } else {
                continue;
            }
        } // 마녀 선택지
        int g = 0; // 마녀를 만남
        int witch_cantsayit = 0;
        if (event == 1) {
            System.out.println("꾀죄죄한 마녀가 온몸을 비틀며 다가온다.");
            System.out.println("마녀는 검버섯과 주름이 가득한 얼굴을 일그러뜨리며 힘겹게 입을 연다."); game.loading();

            System.out.println("\"왕이시여, 저는 동쪽의 마녀 그레텔이라고 합니다.");
            System.out.println("궁으로부터 심상치 기운이 느껴져 이렇게 찾아왔습니다.");
            System.out.println("저를 오늘밤 궁에서 재워주신다면 왕과 나라에 필요한 2가지를 드리겠습니다.");
            System.out.println("단, 모든 것은 댓가가 필요하기 마련입니다.\""); game.loading();

            System.out.println("1. 좋다. 재워주마. 시녀들이 너를 안내할 것이다");
            System.out.println("2. 왕과 나라에 필요한 2가지와 댓가가 무엇이냐?");
            System.out.println("3. 필요없다. 목숨은 살려줄테니 썩 꺼지거라");
            System.out.println("4. 여기가 어느 안전이라고! 당장 이 마녀를 죽여라!");
            for (g = 0; g < 1;) {
                int answerDay1_31 = scan.nextInt();
                if (answerDay1_31 == 1) {
                    loyalist -= 1; // -1
                    traitor += 1; // +1
                    popularity -= 0;
                    money -= 0;
                    g += 1;
                } else if (answerDay1_31 == 2) {
                    loyalist += 0;
                    traitor += 0;
                    popularity -= 0;
                    money -= 0;
                    if (witch_cantsayit == 0) {
                        System.out.println("......");
                        game.loading();
                        System.out.println("알려드릴 수 없습니다. 어떻게 하시겠습니까?");
                        witch_cantsayit = 1;
                    }
                    continue;
                } else if (answerDay1_31 == 3) {
                    loyalist += 0;
                    traitor += 0;
                    popularity += 1; // +1
                    money -= 0;
                    event = 0;
                    g += 1;
                } else if (answerDay1_31 == 4) {
                    loyalist += 0;
                    traitor -= 1; // -1
                    popularity += 1; // +1
                    money += 1; // +1
                    g += 1;
                    event = 0;
                } else {
                    continue;
                }
            }
        }

        for (int i = 0; i < 5; ) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
            i++;
        }

        game.gameChecker(); //승패 조건 체크
        day1_4();
    } // 마녀
    public void day1_4() {
        Scanner scan = new Scanner(System.in);
        Main game = new Main();

        System.out.println("\n\n◈ Day1_16시 / 재정 : " + money + "\n"); game.loading();game.loading();

        System.out.println("신하가 머리를 조아리며 아룁니다."); game.loading();
        System.out.println("\"지하 감옥 확장공사 중 수상한 궤짝이 하나 발견되었습니다.");
        System.out.println("이 궤짝을 어떻게 하시겠습니까? 고대의 물건처럼 보입니다.\""); game.loading();

        System.out.println("1. 궤짝을 열어라");
        System.out.println("2. 수상하다. 열지 말고 멀리 내다버려라");

        int f = 0;
        for (f = 0; f < 1;) {
            int answerDay1_4 = scan.nextInt();
            if (answerDay1_4 == 1) {
                loyalist += 0;
                traitor -= 0;
                popularity -= 0;
                money += 2; // +2
                System.out.println("궤짝을 열자 막대한 양의 금덩어리가 나왔습니다.");
                f += 1;
            } else if (answerDay1_4 == 2) {
                loyalist += 0;
                traitor += 0;
                popularity += 1; // +1
                money -= 0;
                f += 1;
            } else {
                continue;
            }
        }

        for (int i=0; i<5;) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
            i++;
        }

        game.gameChecker(); //승패 조건 체크
        day2_1();
    } // 궤짝
    public void day2_1() {
        Scanner scan = new Scanner(System.in);
        Main game = new Main();
        Random randomMoney = new Random();

        System.out.println("\n\n◈ Day2_09시 / 재정 : " + money + "\n"); game.loading();game.loading();

        System.out.println("세금이 들어왔습니다"); game.loading();
        System.out.println("1. 확인한다");
        System.out.println("2. 확인하지 않는다");

        int f = 0;
        for (f = 0; f < 1;) {
            int answerDay2_1 = scan.nextInt();
            if (answerDay2_1 == 1) {
                loyalist += 0;
                traitor -= 0;
                popularity -= 0;
                int tax = randomMoney.nextInt(2)+1;
                money += tax;
                System.out.println("세금으로 재정이 " + tax + " 늘어났습니다.");
                f += 1;
            } else if (answerDay2_1 == 2) {
                loyalist += 0;
                traitor += 0;
                popularity -= 0;
                int tax = randomMoney.nextInt(2)+1;
                money += randomMoney.nextInt(2)+1;;
                f += 1;
            } else {
                continue;
            }
        }

        for (int i=0; i<5;) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
            i++;
        }

        game.gameChecker(); //승패 조건 체크

        if (event == 1) {
            day2_2();
        } else {
            day2_3();
        }
    } // 세금
    public void day2_2() {
        Scanner scan = new Scanner(System.in);
        Main game = new Main();
        Random randomMoney = new Random();

        System.out.println("\n\n◈ Day2_10시 / 재정 : " + money + "\n"); game.loading(); game.loading();

        if (event == 1) {
            System.out.println("왕궁 전체에 신비하면서도 불길한 기운이 감돕니다."); game.loading();
            System.out.println("그리고 왕궁 멀리서 다급한 병사의 외침이 들립니다.");
            System.out.println("\n마녀가 사라졌다!\n");
            System.out.println("이윽고 신비하면서도 불길한 기운이 사라졌습니다."); game.loading();
            System.out.println("마녀가 말한 일들이 벌어진 것 같습니다.");
            loyalist += 1;
            popularity += 1;
            money += 1;
            event = 0;
        }

        for (int i = 0; i < 5; ) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
            i++;
        }

        game.gameChecker(); //승패 조건 체크
        day2_3();
    } // 사라진 마녀
    public void day2_3() {
        Scanner scan = new Scanner(System.in);
        Main game = new Main();
        Random randomMoney = new Random();

        System.out.println("\n\n◈ Day2_11시 / 재정 : " + money + "\n"); game.loading(); game.loading();

        System.out.println("신하가 머뭇거리며 이야기합니다."); game.loading();
        System.out.println("\"지하 감옥 공사 중, 혼란한 틈을 타 죄수 1명이 탈출한 것으로 보입니다.");
        System.out.println("어떻게 하는게 좋겠습니까?");
        System.out.println("탈출한 죄수는 반역 죄인 크리스토퍼 입니다.\""); game.loading();

        System.out.println("1. 얼른 뒤를 쫓아라");
        System.out.println("2. 이런 멍청한. 내가 꼭 말을 해야 알겠느냐? 당장 쫓아가라!");
        System.out.println("3. 내버려둬라");
        System.out.println("4. 네 놈도 한패로구나. 이 놈을 끌어내라! (재산몰수)");

        int f = 0;
        for (f = 0; f < 1;) {
            int answerDay2_3 = scan.nextInt();
            if (answerDay2_3 == 1) {
                loyalist += 1; // +1
                traitor -= 0;
                popularity -= 1; // -1
                money -= 1; // -1
                f += 1;
                event = 2; // 탈출한 죄인 이벤트
            } else if (answerDay2_3 == 2) {
                loyalist += 0;
                traitor += 0;
                popularity -= 1; // -1
                money -= 1; // -1
                f += 1;
                event = 2; // 탈출한 죄인 이벤트
            } else if (answerDay2_3 == 3) {
                loyalist -= -1;
                traitor += 1;
                popularity -= 1; // -1
                money -= 0;
                f += 1;
            } else if (answerDay2_3 == 4) {
                loyalist -= 2; // -2
                traitor -= 0;
                popularity += 0;
                money += 1;
                f += 1;
            } else {
                continue;
            }
        }

        for (int i = 0; i < 5; ) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
            i++;
        }

        game.gameChecker(); //승패 조건 체크
        day2_4();
    } // 감옥 탈출
    public void day2_4() {
        Scanner scan = new Scanner(System.in);
        Main game = new Main();
        Random randomMoney = new Random();

        System.out.println("\n\n◈ Day2_14시 / 재정 : " + money + "\n");
        game.loading();
        game.loading();

        System.out.println("신하가 이야기합니다.");
        game.loading();
        System.out.println("\"왕이시여, 북부에 곧 겨울이 찾아옵니다.");
        System.out.println("북부에 살고 있는 오랑캐들이 식량을 찾아 왕국을 약탈할 것입니다.");
        System.out.println("군비를 늘려 이에 대한 방비를 철저히 해야합니다.\"");
        game.loading();

        System.out.println("1. 징병과 함께 병기를 정비하여 만반의 태세를 갖추어라");
        System.out.println("2. 병기를 정비하라");
        System.out.println("3. 이미 왕국은 안전하다. 소란피우지 말아라");
        System.out.println("4. 네 이놈! 헛소문을 퍼뜨리는구나! 썩 물러가라");

        int f = 0;
        for (f = 0; f < 1; ) {
            int answerDay2_3 = scan.nextInt();
            if (answerDay2_3 == 1) {
                loyalist += 2; // +2
                traitor -= 0;
                popularity -= 2; // -2
                money -= 2; // -2
                f += 1;
            } else if (answerDay2_3 == 2) {
                loyalist += 1; // +1
                traitor += 0;
                popularity -= 0;
                money -= 1; // -1
                f += 1;
            } else if (answerDay2_3 == 3) {
                loyalist -= 0;
                traitor += 0;
                popularity += 0;
                money -= 0;
                f += 1;
            } else if (answerDay2_3 == 4) {
                loyalist -= 1; // -1
                traitor += 1; // +1
                popularity += 0;
                money -= 0;
                f += 1;
            } else {
                continue;
            }
        }

        for (int i = 0; i < 5; ) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
            i++;
        }

        game.gameChecker(); //승패 조건 체크
        day2_5();
    } // 북부의 겨울
    public void day2_5() {
        Scanner scan = new Scanner(System.in);
        Main game = new Main();
        Random randomMoney = new Random();

        System.out.println("\n\n◈ Day2_16시 / 재정 : " + money + "\n");
        game.loading();
        game.loading();

        System.out.println("당신은 머리가 아파 잠시 산책을 나왔습니다.");
        game.loading();
        System.out.println("그런데 산책길에 떨어져있는 찢어진 종이 하나가 눈에 들어옵니다.");

        System.out.println("1. 종이를 읽는다");
        System.out.println("2. 종이를 무시하고 그냥 가던 길을 간다");
        System.out.println("3. 청소를 제대로 하지 않은 시녀들을 나무란다");
        System.out.println("4. 청소를 제대로 하지 않은 시녀들을 사형한다");

        int f = 0;
        for (f = 0; f < 1; ) {
            int answerDay2_5 = scan.nextInt();
            if (answerDay2_5 == 1) {
                System.out.println("현재의 왕은 무능하다");
                System.out.println("......적인 귀족들은 처형당하고, 백성들의 ...... 민심은 흉흉하다");
                System.out.println("......");
                System.out.println("이제 새로운 왕을 ......");
                System.out.println("반드시 ......\n");
                game.loading();
                System.out.println("당신은 두리번거렸지만 주변엔 아무도 없었습니다.");
                game.loading();

                System.out.println("머리를 식히려고 산책을 나왔건만 오히려 머리가 더 복잡해집니다.");
                game.loading();
                System.out.println("반역자가 있는 것은 확실하지만 누군지 알 수가 없습니다.");
                System.out.println("쪽지를 쥔 손에 힘이 들어갑니다.");
                System.out.println("1. 일단 화를 참는다");
                System.out.println("2. 차오르는 화를 다스리기 위해 술파티를 연다");
                System.out.println("3. 청소를 제대로 하지 않은 시녀들을 나무란다");
                System.out.println("4. 청소를 제대로 하지 않은 시녀들을 사형한다");
                for (f = 0; f < 1; ) {
                    int answerDay2_51 = scan.nextInt();
                    if (answerDay2_51 == 1) {
                        loyalist += 0;
                        traitor += 0;
                        popularity -= 0;
                        money -= 0;
                        f += 1;
                    } else if (answerDay2_51 == 2) {
                        loyalist += 0;
                        traitor -= 1; // -1
                        popularity -= 0;
                        money -= 1; // -1
                        f += 1;
                    } else if (answerDay2_51 == 3) {
                        loyalist -= 0;
                        traitor -= 0;
                        popularity -= -1; // -1
                        money -= 0;
                        f += 1;
                    } else if (answerDay2_51 == 4) {
                        loyalist -= 1; // -1
                        traitor += 1; // +1
                        popularity -= -1; // -1
                        money -= 0;
                        f += 1;
                    } else {
                        continue;
                    }
                }
            } else if (answerDay2_5 == 2) {
                loyalist += 0;
                traitor += 0;
                popularity -= 0;
                money -= 0;
                f += 1;
            } else if (answerDay2_5 == 3) {
                loyalist -= 0;
                traitor += 0;
                popularity += 0;
                money -= 0;
                f += 1;
            } else if (answerDay2_5 == 4) {
                loyalist -= 1; // -1
                traitor += 1; // +1
                popularity += 0;
                money -= 0;
                f += 1;
            } else {
                continue;
            }
        }

        for (int i = 0; i < 5; ) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            System.out.print(".");
            i++;
        }

        game.gameChecker(); //승패 조건 체크
//        day2_6();
    } // 산책 중 종이 발견
}
