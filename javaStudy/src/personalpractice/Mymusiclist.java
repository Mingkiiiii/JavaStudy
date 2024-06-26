package personalpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Mymusiclist {

    private static ArrayList<String> playList = new ArrayList<>(Arrays.asList("비의 랩소디:임재현", "Perfect Night:LE SSERAFIM (르세라핌)",
			"To. X:태연 (TAEYEON)", "Drama:aespa", "사랑은 늘 도망가:임영웅", "첫 눈:EXO", "헤어지자 말해요:박재정", "인사:범진", "에피소드:이무진",
			"Do or Die:임영웅", "모래 알갱이:임영웅", "Seven (feat. Latto) - Clean Ver.:정국", "우리들의 블루스:임영웅",
			"그대만 있다면 (여름날 우리 X 너드커넥션 (Nerd Connection)):너드커넥션 (Nerd Connection)", "Baddie:IVE (아이브)",
			"다시 만날 수 있을까:임영웅", "이제 나만 믿어요:임영웅", "무지개:임영웅", "London Boy:임영웅", "아버지:임영웅", "Polaroid:임영웅",
			"Love Lee:AKMU (악뮤)", "I AM:IVE (아이브)", "You & Me:제니 (JENNIE)", "인생찬가:임영웅", "A bientot:임영웅",
			"Love 119:RIIZE", "Standing Next to You:정국", "연애편지:임영웅", "Get A Guitar:RIIZE", "후라이의 꿈:AKMU (악뮤)",
			"Super Shy:NewJeans", "너의 모든 순간:성시경", "사막에서 꽃을 피우듯:우디 (Woody)", "Ditto:NewJeans",
			"잘 지내자, 우리 (여름날 우리 X 로이킴):로이킴", "ETA:NewJeans", "Hype Boy:NewJeans", "퀸카 (Queencard):(여자)아이들",
			"별 떨어진다 (I Do):디오 (D.O.)", "어떻게 이별까지 사랑하겠어, 널 사랑하는 거지:AKMU (악뮤)", "사랑할 수밖에:볼빨간사춘기", "Discord:QWER",
			"Either Way:IVE (아이브)", "Smoke (Prod. Dynamicduo, Padi):다이나믹 듀오", "사랑인가 봐:멜로망스", "Dynamite:방탄소년단",
			"봄날:방탄소년단", "Off The Record:IVE (아이브)", "Merry PLLIstmas:PLAVE", "MANIAC:VIVIZ (비비지)", "Spicy:aespa",
			"사건의 지평선:윤하 (YOUNHA)", "Fast Forward:전소미", "사랑하지 않아서 그랬어:임한별", "음악의 신:세븐틴 (SEVENTEEN)",
			"그대가 내 안에 박혔다(그내박):순순희(기태)", "잠시라도 우리:성시경", "Kitsch:IVE (아이브)", "OMG:NewJeans", "취중고백:김민석",
			"이브, 프시케 그리고 푸른 수염의 아내:LE SSERAFIM (르세라핌)", "Steal The Show (From “엘리멘탈”):Lauv", "LOVE DIVE:IVE (아이브)",
			"Butter:방탄소년단", "심(心):DK(디셈버)", "파이팅 해야지 (Feat. 이영지):부석순 (SEVENTEEN)", "눈이 오잖아(Feat.헤이즈):이무진",
			"여섯 번째 여름:PLAVE", "그중에 그대를 만나:김호중", "물론:허각", "After LIKE:IVE (아이브)",
			"모든 날, 모든 순간 (Every day, Every Moment):폴킴", "I Don't Think That I Like Her:Charlie Puth",
			"Chill Kill:Red Velvet (레드벨벳)", "주저하는 연인들을 위해:잔나비", "Bubble:STAYC(스테이씨)", "손오공:세븐틴 (SEVENTEEN)",
			"해요 (2022):#안녕", "예뻤어:DAY6 (데이식스)", "I Love You:안세하", "화이트 (White):폴킴", "다정히 내 이름을 부르면:경서예지",
			"그대가 있는 곳, 언제 어디든:로이킴", "사랑..그게 뭔데:지아", "Dangerously:Charlie Puth", "GODS:NewJeans",
			"Attention:NewJeans", "UNFORGIVEN (feat. Nile Rodgers):LE SSERAFIM (르세라핌)", "한 페이지가 될 수 있게:DAY6 (데이식스)",
			"나에게 그대만이:탑현", "Dear. PLLI:PLAVE", "Closer Than This:지민", "3D (feat. Jack Harlow):정국",
			"I Love My Body:화사 (HWASA)", "기다릴게:PLAVE", "Yes or No:정국", "Snowman:Sia",
			"편지 한 장 (부제: 서른에 만난 첫 세상) (A letter):김호중", "I Just Love Ya:PLAVE"));
    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, ArrayList<String>> userMap = new HashMap<>();
       
        while(true) {
        	System.out.println("고객님의 닉네임을 입력해주세요:");
            String userNm = scan.nextLine();
            //putIfAbsent
            //Key 값이 존재하는 경우 Map의 Value의 값을 반환하고, Key값이 존재하지 않는 경우
            //Key와 Value를 Map에 저장하고 Null을 반환합니다
            userMap.putIfAbsent(userNm, new ArrayList<>());

            if ("종료".equals(userNm)) {
            	System.out.println("종료합니다.");
                break; }
            
            printSongs(playList);

            
            System.out.println("좋아하는 가수의 이름을 입력하세요:");
            String artist = scan.nextLine();
            
            
            ArrayList<String> artistSongs = getArtistSongs(playList, artist);
            if (artistSongs.isEmpty()) {
                System.out.println(artist + "의 노래가 플레이리스트에 없습니다.");
            } else {
                
                System.out.println("저장하고 싶은 노래의 순번을 입력하세요 (예: 1, 4):");
                String[] selectedSongNumbers = scan.nextLine().split(",");
                addSongsToUserPlayList(userMap, userNm, artistSongs, selectedSongNumbers);

                
                printUserPlayList(userMap, userNm);
                
                }
            if ("종료".equals(userNm)) {
            	System.out.println("종료합니다.");
                break; 
        }
            
           
        }
        scan.close();

       
    }

    private static void printSongs(ArrayList<String> playList) {
        System.out.println("전체 플레이리스트:");
        for (int i = 0; i < playList.size(); i++) {
            System.out.print((i + 1) + ". " + playList.get(i) + "  ");
            if ((i + 1) % 5 == 0) System.out.println();
        }
        System.out.println("\n====================================");
    }

    private static ArrayList<String> getArtistSongs(ArrayList<String> playList, String artist) {
        ArrayList<String> artistSongs = new ArrayList<>();
        for (String song : playList) {
            if (song.contains(artist)) {
                artistSongs.add(song);
            }
        }

        for (int i = 0; i < artistSongs.size(); i++) {
            System.out.println((i + 1) + ". " + artistSongs.get(i));
        }
        return artistSongs;
    }

    private static void addSongsTowUserPlayList(HashMap<String, ArrayList<String>> userMap, String userNm, 
                                               ArrayList<String> artistSongs, String[] selectedSongNumbers) {
        ArrayList<String> userPlayList = userMap.get(userNm);
        for (String numberStr : selectedSongNumbers) {
            try {
                int songIndex = Integer.parseInt(numberStr.trim()) - 1;
                if (songIndex >= 0 && songIndex < artistSongs.size()) {
                    userPlayList.add(artistSongs.get(songIndex));
                } else {
                    System.out.println("유효하지 않은 노래 번호: " + (songIndex + 1));
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자 형식이 올바르지 않습니다: " + numberStr);
            }
        }
    }

    private static void printUserPlayList(HashMap<String, ArrayList<String>> userMap, String userNm) {
        ArrayList<String> userPlayList = userMap.get(userNm);
        System.out.println(userNm + "님의 플레이리스트:");
        for (int i = 0; i < userPlayList.size(); i++) {
            System.out.println((i + 1) + ". " + userPlayList.get(i));
        }
    }
}
