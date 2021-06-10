package geeks.dp;

//https://www.geeksforgeeks.org/wildcard-pattern-matching/
//below is my approach accepted on practice, compare with geeks dp sol
public class WildcardPatternMatch {

    int wildCard(String pattern, String str) {
        return wildCardUtil(pattern, pattern.length(), str, str.length()) ? 1 : 0;
    }

    boolean wildCardUtil(String pattern, int pl, String str, int sl) {
        if (pl == 0 && sl == 0)
            return true;
        if (pl == 0 || sl < 0)
            return false;
        if (pattern.charAt(pl - 1) == '?')
            return wildCardUtil(pattern, pl - 1, str, sl - 1);
        if (pattern.charAt(pl - 1) == '*')
            return wildCardUtil(pattern, pl - 1, str, sl) || wildCardUtil(pattern, pl, str, sl - 1);
        if (sl != 0 && pattern.charAt(pl - 1) == str.charAt(sl - 1))
            return wildCardUtil(pattern, pl - 1, str, sl - 1);
        return false;
    }

    //accepted on practice, seems consistent with geeks
    boolean wildCardUtil2(String p, int pl, String s, int sl) {
        if (pl == 0)
            return sl == 0;
        if (sl == 0) {
            for (int i = 0; i < pl; i++) {
                if (p.charAt(i) != '*')
                    return false;
            }
            return true;
        }
        char pch = p.charAt(pl - 1);
        char sch = s.charAt(sl - 1);
        if (pch == '?' || pch == sch)
            return wildCardUtil2(p, pl - 1, s, sl - 1);
        if (pch == '*')
            return wildCardUtil2(p, pl - 1, s, sl) || wildCardUtil2(p, pl, s, sl - 1);
        return false;
    }
}
