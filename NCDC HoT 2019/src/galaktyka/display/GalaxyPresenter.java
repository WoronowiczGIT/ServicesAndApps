package galaktyka.display;

import java.util.stream.IntStream;

public class GalaxyPresenter implements Presenter {
    private  String trail;
    private  String backGround;
    private  int score = 0;

    public GalaxyPresenter(String trail, String backGround) {
        this.trail = trail;
        this.backGround = backGround;
    }

    @Override
    public void display(boolean[][] matrix) {

        for (boolean[] row : matrix) {
            StringBuilder sb = new StringBuilder(row.length);

            IntStream
                    .range(0, row.length)
                    .forEach(index -> {
                        if (row[index]){
                            score++;
                            sb.append(trail);
                        }else{
                            sb.append(backGround);}
                    });
            System.out.println(sb.toString());
        }
        System.out.print(score);
    }
}
