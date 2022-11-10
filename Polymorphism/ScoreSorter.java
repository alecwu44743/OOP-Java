public class ScoreSorter implements Comparable <ScoreSorter> {
    public int ch;
    public int en;
    public int ma;
    public int tc;

    public ScoreSorter(int ch, int en, int ma) {
        this.ch = ch;
        this.en = en;
        this.ma = ma;
        this.tc = ch + en + ma;
    }

    public int getCh() {
        return this.ch;
    }

    public int getEn() {
        return this.en;
    }

    public int getMa() {
        return this.ma;
    }

    public int getTc() {
        return this.tc;
    }

    public int compareTo(ScoreSorter s) {
        // decreasing order
        if (this.tc < s.tc) {
            return 1;
        } else if (this.tc > s.tc) {
            return -1;
        } else {
            if (this.ch < s.ch) {
                return 1;
            } else if (this.ch > s.ch) {
                return -1;
            } else {
                if (this.en < s.en) {
                    return 1;
                } else if (this.en > s.en) {
                    return -1;
                } else {
                    if (this.ma < s.ma) {
                        return 1;
                    } else if (this.ma > s.ma) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            }
        }
    }
}