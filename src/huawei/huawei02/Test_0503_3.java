package huawei.huawei02;

/**
 * @Author: xianz
 * @Date: 2020/5/3 14:05
 * @Title: 字符串加密
 * @Description:
 * @InputDescription:
 * @OuputDescription:
 * @Analysis: 1.给定密钥单词，根据密钥生成26个字母对应表 2.用给定的明文密码通过密钥得到密文
 * 思路：用LinkedHashSet，按照顺序存并且不重复;；大小写的问题，先全部搞成小写，然后再判断
 * @TimeConsuming: 24min
 */
import java.util.*;
public class Test_0503_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String code = sc.nextLine();
            String infoIni = sc.nextLine();
            Set<Character> set = new LinkedHashSet<>();
            List<Character> list = new ArrayList<>();
            for(int i=0; i<code.length();i++){
                set.add(Character.toLowerCase(code.charAt(i)));
            }
            for(int i=0;i<26;i++){
                set.add((char)('a'+i));
            }
            for(Iterator<Character> iter = set.iterator(); iter.hasNext();){
                list.add(iter.next());
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<infoIni.length();i++){
                char temp = infoIni.charAt(i);
                if(Character.isLowerCase(temp)){
                    sb.append(Character.toLowerCase(list.get(temp - 'a')));
                }else if(Character.isUpperCase(temp)){
                    sb.append(Character.toUpperCase(list.get(temp-'A')));
                }else{
                    sb.append(temp);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
