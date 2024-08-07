import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] input1 = {"Pendanaan", "Terproteksi", "Untuk", "Dampak", "Berarti"};
        StringBuilder concatenaredString = new StringBuilder();

        //gabung
        for(String str:input1)
        {
            concatenaredString.append(str);
        }
        String result = concatenaredString.toString();
        System.out.println("digabung menjadi : " + result);

        //hitung
        HashMap<Character, Integer> hitung = new HashMap<>();
        for (char c:result.toCharArray())
        {
            if (Character.isLetter(c))
            {
                hitung.put(c, hitung.getOrDefault(c,0)+1);
            }
        }

        //cetak hitung
        HashMap<Character, Integer> total = new HashMap<>();
        for (char key:hitung.keySet())
        {
            total.put(key, hitung.get(key));
//            System.out.println(key + "=" + hitung.get(key));
        }
        System.out.println("dihitung menjadi : " + total);

        //sorted
        Map<Character,Integer> sorted = new TreeMap<>((a,b) ->
        {
            int banding = hitung.get(b).compareTo(hitung.get(a));
            if (banding==0)
            {
                if(Character.isUpperCase(a) && !Character.isUpperCase(b))
                {
                    return -1;
                }
                else if (!Character.isUpperCase(a)&&Character.isUpperCase(b))
                {
                    return 1;
                }
                else
                {
                    return a.compareTo(b);
                }
            }
            return banding;
        });
        sorted.putAll(hitung);

        //cetak urut
        System.out.println("diurutkan menjadi :");
        for (char key:sorted.keySet())
        {
            System.out.println(key + " = " + hitung.get(key));
        }

        //bikin string
        StringBuilder output1=new StringBuilder();
        for (char key:sorted.keySet())
        {
            output1.append(key);
        }

        //cetak hasil
        System.out.println("hasilnya menjadi : ");
        System.out.println(output1.toString());
    }
}