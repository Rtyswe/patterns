package rtyswe.edu.chain.writer;

public class WriterUtils {

    private static final ChainWriter writer;

    static {
        ChainWriter rowWriter = new RowWriter();
        ColumnWriter columnWriter = new ColumnWriter();

        rowWriter.setNext(columnWriter);
        rowWriter.setPredicate(vehicle -> vehicle.getSize() <= 3);

        columnWriter.setPredicate(vehicle -> vehicle.getSize() > 3);
        writer = rowWriter;
    }

    private WriterUtils() {}

    public static ChainWriter getWriter() {
        return writer;
    }
}
