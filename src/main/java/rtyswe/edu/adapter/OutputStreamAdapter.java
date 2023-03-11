package rtyswe.edu.adapter;

import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamAdapter extends OutputStream {

    private final OutputStream out;

    public OutputStreamAdapter(OutputStream out) {
        this.out = out;
    }

    public void write(String[] strings) throws IOException {
        for (String str : strings) {
            out.write((str + "\n").getBytes());
        }
    }

    @Override
    public void write(int b) throws IOException {
        out.write(b);
    }
}
