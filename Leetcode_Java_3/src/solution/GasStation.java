package solution;

public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int gasInCar = 0;
		int total = 0;
		int idx = -1;
		int length = gas.length;

		for (int i = 0; i < length; i++) {
			gasInCar += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (gasInCar < 0) {
				idx = i;
				gasInCar = 0;
			}
		}

		return (total >= 0) ? idx + 1 : -1;
	}
}
