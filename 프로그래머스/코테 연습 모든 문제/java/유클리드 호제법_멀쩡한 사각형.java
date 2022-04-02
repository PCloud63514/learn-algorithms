// 유클리드 호제법을 이용한 최대공약수 계산
class Solution {
    public long solution(int w, int h) {
        int x = Math.max(w, h);
        int y = Math.min(w, h);
        int q = gcd(x, y);

        return (long)w * h - (w + h - q);
    }
    // 유클리드 호제법
    public int gcd(int p, int q)
    {
        if (q == 0) return p;
        return gcd(q, p%q);
    }
}