package practiceFRQs.practice_3_2;

import java.util.List;

public class MultipleGroups implements NumberGroup {
	private List<NumberGroup> groups;
	
	public boolean contains(int num) {
		for (NumberGroup group : groups) if (group.contains(num)) return true;
		return false;
	}
}