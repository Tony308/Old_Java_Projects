class Main {
    
    public static void main(String[] args) {
    	Members k = new Members();
    	
    	k.setSurname("Lovegood");
    	k.setfirstname("Katie");
    	k.setMiddlename("Louise");
    	k.setAge(21);
    	
    	System.out.println(k.getfirstname());
    	System.out.println(k.getMiddlename());
    	System.out.println(k.getSurname());
    	System.out.println("Age: "+ k.getAge());
    	int[] arr = {1, 50, 5 ,10, 15, 50, 24,26,27,100};
    	System.out.println(solution(50, 100, arr ));
    }
    
    public static int solution(int X, int Y, int[] A) {
        int N = A.length;
        int result = -1;
        int nX = 0;
        int nY = 0;
        for (int i = 0; i < N; i++) {
            if (A[i] == X)
                nX += 1;
            if (A[i] == Y)
                nY += 1;
            if (nX == nY && nX != 0 || nY != 0)
                result = i;
        }
        return result;
    }
	
}