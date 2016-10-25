
class Test
{
public static void generate2(String word) {
    for (int from = 0; from < word.length(); from++) {
        for (int to = from + 1; to <= word.length(); to++) {
            System.out.println(word.substring(from, to));
        }
    }
}

public static void main(String args[])
{
	generate2("rudrani");
}


}
