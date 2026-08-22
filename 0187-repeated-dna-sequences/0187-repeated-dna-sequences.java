class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if(n <10){
            return new ArrayList<>();
        }

        //map the characters to 2 bit since we are having only four characters
        int map[] = new int[256];
        map['A'] = 0;
        map['C'] = 1;
        map['G'] = 2;
        map['T'] = 3;

        int base = 4;
        int L =10;

        int baseL = (int) Math.pow(base,L-1);

        Set<Integer> found = new HashSet<>();
        Set<String> result = new HashSet<>();

        int rollingHash = 0;
        
        for(int i=0;i<L;i++){
            rollingHash =rollingHash *base +map[s.charAt(i)];
        }
        found.add(rollingHash);

        for(int i=L;i<n;i++){
            int outGoing =map[s.charAt(i-L)];
            rollingHash -= outGoing *baseL;

            int incomingVal = map[s.charAt(i)];
            rollingHash = rollingHash * base + incomingVal;

            if (!found.add(rollingHash)) {
                result.add(s.substring(i - L + 1, i + 1));
            }
        }

        return new ArrayList<>(result);

    }
}