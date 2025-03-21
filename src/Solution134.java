public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0) {
            return -1;
        }


        int pos = 0;
        int tank = 0;
        for (int i = 0; i < gas.length; i++) {
            // tank is overspent, this position is not a valid start
            // reset the tank and start from the next station
            tank += gas[i] - cost[i];
            if (tank < 0) {
                pos = i + 1;
                tank = 0;
            }
        }

        return pos;
    }

    public static void main(String[] args) {
        Solution134 solution134 = new Solution134();
        int[] gas = {2, 3, 4};
        int[] cost = {3, 4, 3};

        System.out.println(solution134.canCompleteCircuit(gas, cost));
    }
}
