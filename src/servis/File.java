package servis;

public class File {

    private final String osiedle;
    private final int idOsiedla;


    public File(String osiedle, int idOsiedla) {
        this.osiedle = osiedle;
        this.idOsiedla = idOsiedla;

    }

    @Override
    public String toString() {
        return "File " +
                "osiedle " + osiedle + '\'' +
                ", idOsiedla " + idOsiedla;
    }

    public String getOsiedle() {
        return osiedle;
    }

    public int getIdOsiedla() {
        return idOsiedla;
    }
}


