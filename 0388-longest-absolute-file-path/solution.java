class Solution {
    public int lengthLongestPath(String input) {
        // First check if input only is a directory or consists of at least one or more of a subdirectory or file 
        int depth_count = 0;
        int[] pathLen = new int[input.length() + 1];
        int maxPath = 0;
        
        // Recursively check for longest path to file

        String[] fileParse = input.split("\n");
        System.out.println(Arrays.toString(fileParse));

        for (int i = 0; i < fileParse.length; i++) {
            int depth = fileParse[i].lastIndexOf("\t") + 1;
            String name = fileParse[i].substring(depth);
            int len = name.length();

            if (depth == 0) {
                pathLen[depth] = name.length();
            }
            else {
                pathLen[depth] = pathLen[depth - 1] + 1 + name.length();
            }
            if (name.contains(".")) {
                maxPath = Math.max(maxPath, pathLen[depth]);
            }
            System.out.println(depth);
            System.out.println(name);
            System.out.println(len);
        }
        return maxPath;
        
    }
}
