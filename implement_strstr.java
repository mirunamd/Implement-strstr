// { Driver Code Starts
import java.util.*;

class Implement_strstr {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    sc.nextLine();
    while (t > 0) {
      String line = sc.nextLine();
      String a = line.split(" ")[0];
      String b = line.split(" ")[1];

      GfG g = new GfG();
      System.out.println(g.strstr(a, b));

      t--;
    }
  }
}

// } Driver Code Ends

class GfG {
  // Function to locate the occurrence of the string x in the string s.
  int strstr(String s, String x) {
    int M = x.length();
    int[] lps = new int[M];
    computeLPS(x, lps);
    int j = 0;

    int N = s.length();
    int i = 0;

    while (i < N) {
      if (s.charAt(i) == x.charAt(j)) {
        i++;
        j++;
      }
      if (j == M) {
        return i - j;
      } else if (i < N && s.charAt(i) != x.charAt(j)) {
        if (j > 0) {
          j = lps[j - 1];
        } else {
          i++;
        }
      }
    }
    return -1;
  }

  void computeLPS(String pat, int[] lps) {
    int i = 1;
    int len = 0;
    int N = pat.length();
    lps[0] = 0;
    while (i < N) {
      if (pat.charAt(i) == pat.charAt(len)) {
        lps[i++] = ++len;
      } else {
        if (len > 0) {
          len = lps[len - 1];
        } else {
          lps[i++] = 0;
        }
      }
    }
  }
}
