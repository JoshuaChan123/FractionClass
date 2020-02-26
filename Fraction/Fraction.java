public class Fraction{
    private int n;
    private int d;

    public Fraction(){
        this.n=0;
        this.d=1;
    }

    public Fraction(int num, int den){
        this.n=num;
        this.d=den;
        if(this.d==0){
            this.d=1;
        }
    }

    public Fraction(String frac){
        int slash= frac.indexOf("/");

        String num= frac.substring(0,slash);
        String den=frac.substring(slash+1, frac.length());
        this.n = Integer.parseInt(num);
        this.d = Integer.parseInt(den);
        if(this.d==0){
            this.d=1;   
        }
    }

    public Fraction (Fraction f){
        this.n=f.n;
        this.d=f.d;

    }

    public int getNum(){
        return this.n;
    }

    public int getDenom(){
        return this.d;
    }

    public String toString(){
        return this.n+"/"+this.d;
    }

    public double toDouble(){
        double n= this.n;
        double d=this.d;

        return n/d;
    }

    public void reduce(){
        int gcf= gcf(this.n, this.d);
        if(this.n<0 && this.d<0){
            this.n=Math.abs(this.n);
            this.d=Math.abs(this.d);
        }
        this.n=this.n/gcf;
        this.d=this.d/gcf;

    }

    public void setNum(int num){
        this.n=num;
    }

    public void setDenom(int den){
        this.d=den;
    }

    public static Fraction multiply(Fraction a, Fraction b){
        int n= a.n*b.n;
        int d= a.d*b.d;

        Fraction c= new Fraction (n,d);
        c.reduce();
        return c;
    }

    public static Fraction divide(Fraction a, Fraction b){
        int n= a.n*b.d;
        int d= a.d*b.n;

        Fraction c=new Fraction(n,d);
        c.reduce();
        return c;
    }

    public static Fraction add(Fraction a, Fraction b){
        Fraction c=new Fraction(a.n*b.d, a.d*b.d);
        Fraction d=new Fraction(b.n*a.d, b.d*a.d);

        Fraction e=new Fraction(c.n+d.n,d.d);
        e.reduce();

        return e;

    }

    public static Fraction subtract(Fraction a, Fraction b){
        Fraction c=new Fraction(a.n*b.d, a.d*b.d);
        Fraction d=new Fraction(b.n*a.d, b.d*a.d);

        int positive= Math.abs(c.n-d.n);
        Fraction e=new Fraction(positive,d.d);
        e.reduce();

        return e;
    }

    public int gcf(int a, int b){
        a=Math.abs(a);
        b=Math.abs(b);
        while(a!=b){
            if(a>b){
                a=a-b;   
            } else if(b>a){
                b=b-a;
            }
        }
        return a;
    }
}