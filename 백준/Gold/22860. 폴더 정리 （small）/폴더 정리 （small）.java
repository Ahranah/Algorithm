import java.util.*;
import java.io.*;

public class Main {
    static Map<String, List<String>> fileTree = new HashMap<>();
    static int fileCount;
    static Set<String> fileTypes;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int folder = Integer.parseInt(st.nextToken());
        int file = Integer.parseInt(st.nextToken());

        for (int i = 0; i < folder + file; i++) {
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String child = st.nextToken();
            int isFolder = Integer.parseInt(st.nextToken());

            fileTree.putIfAbsent(parent, new ArrayList<>());
            fileTree.get(parent).add(child);

            if (isFolder == 1) {
                fileTree.putIfAbsent(child, new ArrayList<>());
            }
        }

        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            String[] path = br.readLine().split("/");
            String folderName = path[path.length - 1];

            fileCount = 0;
            fileTypes = new HashSet<>();
            dfs(folderName);

            System.out.println(fileTypes.size() + " " + fileCount);
        }
    }

    static void dfs(String folder) {
        if (!fileTree.containsKey(folder)) return;

        for (String child : fileTree.get(folder)) {
            if (fileTree.containsKey(child)) {
                dfs(child);
            } else {
                fileTypes.add(child);
                fileCount++;
            }
        }
    }
}