import java.io.File;

public class Find {
    private String directory;

    private Boolean useSubdirectory;

    public Find(String directory, Boolean useSubdirectory) {
        this.directory = directory;
        this.useSubdirectory = useSubdirectory;
    }

    private String searchin(String dir, String fileName) {
        File file = new File(dir);
        String[] dirs = file.list();
        for (int i = 0; i < dirs.length; i++) {
            String fullName;
            if (dirs[i].equals(fileName)) {
                fullName = directory;
            } else {
                fullName = directory + "/" + dirs[i];
            }
            if (new File(fullName + "/" + fileName).isFile()) {
                return fullName + "/" + fileName;
            }
            fullName = searchin(fullName, fileName);
        }
        return "ERROR";
    }

    private String search(String dir, String fileName) {
        File file = new File(dir);
        String fullName = dir + "/" + fileName;
        if (new File(fullName).isFile()) {
            return fullName;
        }
        return "ERROR";
    }

    public File find(String fileName){
        String result = "";
        File file = new File(directory);
        if (useSubdirectory){
            result = searchin(directory, fileName);
        }
        else {
            result = search(directory, fileName);
        }
        //if (result.equals("ERROR")) Завершить

        return new File(result);
    }
}
