package mushroom;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

// Given groups containing email ids, merge groups with common email ids. E.g.
// G1 : a@gmail.com, 2@gmail.com
// G2 : foo@bar.com
// G3 : bar@foo.com, 2@gmail.com
// G4 : 2@gmail.com
// 
// Should yield
// (G1, G3, G4), (G2)

public class EmailGroup {

	private static HashMap<String,HashSet<String>> findGroups(HashMap<String, List<String>> input) {
		var email2Line = new HashMap<String, String>();
		var line2Emails = new HashMap<String, HashSet<String>>();
		var groups = new HashMap<String, HashSet<String>>();
		for (var key : input.keySet()) {
			var group = input.get(key);
			String line = null;
			for (var email : group) {
				// Check to see if any email was already seen before in this line, if so then
				// merge it with
				// previous line/email.
				var line2 = email2Line.get(email);
				if (line2 == null || line2.equals(line)) {
					continue;
				}
				if (line == null) {
					line = line2;
					continue;
				}
				// Need to merge |line2| with |line| and delete |line2|
				var set = line2Emails.get(line2);
				for (var e : set) {
					if (email2Line.containsKey(e)) {
						email2Line.put(e, line);
					}
				}
				System.out.println("------------" + line2);
				line2Emails.remove(line2);
				line2Emails.get(line).addAll(set);				
			}
			if (line == null) {
				// Did not find an email that was already seen.
				line = key;
			}
			for (var email : group) {
				// Add to email -> Line number map.
				var l = email2Line.get(email);
				if (l == null) {
					l = line;
					email2Line.put(email, l);
				}
				// Add to line number -> email id map.
				var set = line2Emails.get(l);
				if (set == null) {
					set = new HashSet<String>();
					set.add(email);
					line2Emails.put(l, set);
				} else {
					// line number already exists.
					set.add(email);
				}
				// groups fixes
				var g = groups.get(line);
				if (g == null) {
					g = new HashSet<String>();
					g.add(line);
					groups.put(line, g);
				}
				g.add(key);
			}
		}
		return groups;
	}

	public static void main(String[] args) {
		var input = new HashMap<String, List<String>>();
		input.put("G1", Arrays.asList("a@gmail.com", "2@gmail.com"));
		input.put("G2", Arrays.asList("foo@gmail.com"));
		input.put("G3", Arrays.asList("bar@gmail.com", "2@gmail.com"));
		System.out.println(findGroups(input));
	}
}
