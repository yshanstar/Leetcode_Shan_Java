package solution;

/*
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
 */
public class GasStation2 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int gasInCar = 0;
		int totalGas = 0;
		int start = -1;
		int length = gas.length;

		for (int i = 0; i < length; i++) {
			gasInCar += gas[i] - cost[i];
			totalGas += gas[i] - cost[i];
			if (gasInCar < 0) {
				gasInCar = 0;
				start = i;
			}
		}

		return (totalGas >= 0) ? start+1 : -1;

	}
}
