import java.lang.Integer;
import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle{
    public ArrayList<ArrayList<Integer>> generate(int numRows){
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for (int i=1; i<=numRows; i++){
            ArrayList<Integer> tmp;
            if( i == 1 ){
                ArrayList<Integer> begin = new ArrayList<Integer>();
                begin.add(1);
                res.add(begin);
                continue;
            }else{
                tmp = res.get(i-2);
                ArrayList<Integer> tmpRes = new ArrayList<Integer>();
                for (int j=0; j<=tmpRes.size(); j++){
                    if (j==0 ){
                        tmpRes.add(1);
                    }else if (j==tmpRes.size()){
                        tmpRes.add(1);
                    }else{
                        tmpRes.add(tmp.get(j-1)+tmp.get(j));
                    }
                }
                res.add(tmpRes);
            }
        }
        return res;
    }
}