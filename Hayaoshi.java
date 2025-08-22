import java.util.Scanner;

public class Hayaoshi{
    private static boolean answered=false;//誰が押したかどうか
    private static String winner=null;//勝者の名前

    // ボタンを押したときの処理
    public static synchronized boolean pressButton(String playerName){
        if(!answered){
            answered=true;
            winner=playerName;
            System.out.println(playerName + "が最初に押しました");
            return true;
        }
        return false;//二人目以降は無効
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("早押しクイズ開始！");
        System.out.print("プレイヤー１は「１」、プレイヤー２は「２」と入力してください");

        while (!answered){
            String input = scanner.nextLine();
            if(input.equals("1")){
                pressButton("プレイヤー１");
            }
            else if(input.equals("2")){
                pressButton("プレイヤー２");
            }
            else{
                System.out.print("プレイヤー１は「１」、プレイヤー２は「２」と入力してください");
            }
        }
       
        System.out.println("勝者は"+winner+"です！");
        scanner.close();
    }
}