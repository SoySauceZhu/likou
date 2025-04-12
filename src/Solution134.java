public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0) {
            return -1;
        }


        /* You accumulate your “tank” as you move forward.

            If at station i the tank goes negative, it means no station between your current start and i can be a valid start (because they’d start with even less gas).

            So you reset the tank and set the next station (i+1) as the new candidate start.

            Furthermore, there is only one solution, so if you've tested pos `i` is not impossible,
            and you've tested pos `i+1` is possible, then `i+1` is the answer
         */


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
