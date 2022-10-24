public class Divis {

    int delim;
    int delitel;
    String rez = "";
    int lNum;


    public Divis(int delim, int delitel, int lNum) {
        this.delim = delim;
        this.delitel = delitel;
        this.lNum = lNum;
    }


    public int count() { //находим количество целых вхождений
        int iC = 1;
        int CountDelim =delim;
        while (CountDelim >= delitel) {
            CountDelim = CountDelim - delitel;
            if (CountDelim >= delitel) iC++;
        }
        return iC;
    }

    public int uvelich() { //Если делимое меньше - увеличиваем
        int r=0;
        while (delim < delitel) {
            r++;
            delim = delim * 10;
            if (r>=2) rez = rez + "0";
        }
        return delim;
    }

    public String result() {
        int i=0;// индикатор количества знаков после запятой
        int razn=-1;
        if (delim<delitel) rez="0";
        while (i != lNum-1) {
             if (delitel <= delim) {
             rez=rez+String.valueOf(count());
             delim=delim-count()*delitel;
             if (delim==0) i=lNum-1; //выходим из цикла если поделились без остатка

            } else {      //если делитель больше
             i++;
             if (i==1) rez = rez + ",";
             delim=uvelich();
             rez=rez+String.valueOf(count());
             delim=delim-count()*delitel;
             if (delim==0) i=lNum-1; //выходим из цикла если поделились без остатка
            }

        }
        return rez;
    }

}
