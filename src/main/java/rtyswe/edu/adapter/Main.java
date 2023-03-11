package rtyswe.edu.adapter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        OutputStreamAdapter adapter = new OutputStreamAdapter(System.out);
        adapter.write(new String[]{"aboba", "123123"});
    }

}
