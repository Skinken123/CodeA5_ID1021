public class Benchmark {
    public static void main(String[] args){
        runBenchFAVS();
        System.out.print("\n" + "\n");
        runBenchVSAF();
    }

    //benchmarks the time taken to append a linked list of a fixed size to a linked list with varied size
    public static long benchVarySizeAppendFixed(int fixed, int varied){
        LinkedList fixedList = new LinkedList(fixed);
        LinkedList variedList = new LinkedList(varied);

        long t0 = System.nanoTime();
        variedList.append(fixedList);
        long t1 = System.nanoTime();
        return t1-t0;
    }

    //benchmarks the time taken to append a linked list with varied size to a linked list of a fixed size
    public static long benchFixedAppendVarySize(int fixed, int varied){
        LinkedList fixedList = new LinkedList(fixed);
        LinkedList variedList = new LinkedList(varied);

        long t0 = System.nanoTime();
        fixedList.append(variedList);
        long t1 = System.nanoTime();
        return t1-t0;
    }

    //method to correctly execute the benchmark for diffrent size linked lists
    public static void runBenchFAVS(){
        int[] sizes = {100, 200, 400, 800, 1600, 3200}; //array som ska accessas, 12800, 25600, 51200
        int k = 10000; // så många gånger benchmark ska köras
        int fixed = 100; //size of fixed linked list

        //warmup
        benchFixedAppendVarySize(10000, 10000);

        for (int n : sizes){
            long min = Long.MAX_VALUE;
            long total = 0;
            for (int i = 0; i < k; i++){
                long temp = benchFixedAppendVarySize(fixed, n);
                if (temp < min) min = temp;
                total += temp;
            }
            System.out.print(n + " " + min + " " + total/k + "\n");
        }
    }

    public static void runBenchVSAF(){
        int[] sizes = {100, 200, 400, 800, 1600, 3200}; //array som ska accessas, 12800, 25600, 51200
        int k = 10000; // så många gånger benchmark ska köras
        int fixed = 100; //size of fixed linked list

        //warmup
        benchVarySizeAppendFixed(10000, 10000);

        for (int n : sizes){
            long min = Long.MAX_VALUE;
            long total = 0;
            for (int i = 0; i < k; i++){
                long temp = benchVarySizeAppendFixed(fixed, n);
                if (temp < min) min = temp;
                total += temp;
            }
            System.out.print(n + " " + min + " " + total/k + "\n");
        }
    }
}
