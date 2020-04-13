package practiceFRQs.practice_1_2;

public class BatteryCharger {
	private int[] rateTable;
	
	private int getChargingCost(int startHour, int chargeTime) {
		int cost = 0;
		for (int i = startHour; i < startHour + chargeTime; i++)
			cost += rateTable[i % 24];
		return cost;
	}
	
	public int getChargeStartTime(int chargeTime) {
		int bestTime = 0;
		int bestCost = getChargingCost(0, chargeTime);
		for (int i = 1; i < rateTable.length; i++) {
			int cost = getChargingCost(i, chargeTime);
			if (cost < bestCost) {
				bestTime = i;
				bestCost = cost;
			}
		}
		return bestTime;
	}
}