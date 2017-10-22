import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BurrowsWheelerTransform {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    String BWT(String text) {
        StringBuilder result = new StringBuilder();
        ArrayList<String> cycRot = new ArrayList<>();
        String rot = text;
        int lastCharIndex = rot.length()-1;
        for(int i=0;i<=lastCharIndex;i++){
            cycRot.add(rot);
            rot = rot.charAt(lastCharIndex) + rot.substring(0,lastCharIndex);
        }
        Collections.sort(cycRot);
        for(int i=0;i<cycRot.size();i++){
            result.append(cycRot.get(i).charAt(lastCharIndex));
        }
        // write your code here

        return result.toString();
    }

    static public void main(String[] args) throws IOException {
        new BurrowsWheelerTransform().run();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String text = scanner.next();
        System.out.println(BWT(text));
    }
}
