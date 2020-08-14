package Test;

/**
 * @Author: xianz
 * @Date: 2020/8/10 10:22
 * @Title&Description:
 * @Analysis:
 * @Summary:
 * @TimeConsuming:
 */
public class TestOverLoad {
    public static void main(String[] args) {

    }

    @Override
    public String toString() {
        return super.toString();
    }

    protected int getPow(int a, int b){
        return a * b;
    }

    public int getPow(int a, double b){  //改变参数类型
        return (int)(a * b);
    }
    public int getPow(double a, int b){  //参数类型不同的情况下改变参数顺序
        return (int)(a * b);
    }



    public double getPow(double a, double b){  //改变参数类型，改变返回值
        return a * b;
    }

    public int getPow(int a, int b, int c){  //改变参数数量
        return a * b * c;
    }
}
